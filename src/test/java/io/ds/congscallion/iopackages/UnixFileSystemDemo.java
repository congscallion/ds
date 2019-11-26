package io.ds.congscallion.iopackages;

import sun.security.action.GetPropertyAction;


import java.io.File;
import java.io.IOException;
import java.security.AccessController;

public class UnixFileSystemDemo {

    private final char slash;
    private final char colon;
    private final String javaHome;

    public UnixFileSystemDemo() {
        slash = AccessController.doPrivileged(
                new GetPropertyAction("file.separator")).charAt(0);
        colon = AccessController.doPrivileged(
                new GetPropertyAction("path.separator")).charAt(0);
        javaHome = AccessController.doPrivileged(
                new GetPropertyAction("java.home"));
    }


    /* -- Normalization and construction -- */

    public char getSeparator() {
        return slash;
    }

    public char getPathSeparator() {
        return colon;
    }

    /* A normal Unix pathname contains no duplicate slashes and does not end
       with a slash.  It may be the empty string. */

    /* Normalize the given pathname, whose length is len, starting at the given
       offset; everything before this offset is already normal. */
    private String normalize(String pathname, int len, int off) {
        if (len == 0) return pathname;
        int n = len;
        while ((n > 0) && (pathname.charAt(n - 1) == '/')) n--;
        if (n == 0) return "/";
        StringBuffer sb = new StringBuffer(pathname.length());
        if (off > 0) sb.append(pathname.substring(0, off));
        char prevChar = 0;
        for (int i = off; i < n; i++) {
            char c = pathname.charAt(i);
            if ((prevChar == '/') && (c == '/')) continue;
            sb.append(c);
            prevChar = c;
        }
        return sb.toString();
    }

    /* Check that the given pathname is normal.  If not, invoke the real
       normalizer on the part of the pathname that requires normalization.
       This way we iterate through the whole pathname string only once. */
    public String normalize(String pathname) {
        int n = pathname.length();
        char prevChar = 0;
        for (int i = 0; i < n; i++) {
            char c = pathname.charAt(i);
            if ((prevChar == '/') && (c == '/'))
                return normalize(pathname, n, i - 1);
            prevChar = c;
        }
        if (prevChar == '/') return normalize(pathname, n, n - 1);
        return pathname;
    }

    public int prefixLength(String pathname) {
        if (pathname.length() == 0) return 0;
        return (pathname.charAt(0) == '/') ? 1 : 0;
    }

    public String resolve(String parent, String child) {
        if (child.equals("")) return parent;
        if (child.charAt(0) == '/') {
            if (parent.equals("/")) return child;
            return parent + child;
        }
        if (parent.equals("/")) return parent + child;
        return parent + '/' + child;
    }

    public String getDefaultParent() {
        return "/";
    }

    public String fromURIPath(String path) {
        String p = path;
        if (p.endsWith("/") && (p.length() > 1)) {
            // "/foo/" --> "/foo", but "/" --> "/"
            p = p.substring(0, p.length() - 1);
        }
        return p;
    }


    public int getPrefixLength(File parent) {
        if (parent.getPath().length() == 0) return 0;
        return (parent.getPath().charAt(0) == '/') ? 1 : 0;
    }


    /* -- Path operations -- */

    public boolean isAbsolute(File f) {
        return (getPrefixLength(f) != 0);
    }

    public String resolve(File f) {
        if (isAbsolute(f)) return f.getPath();
        return resolve(System.getProperty("user.dir"), f.getPath());
    }


    static String parentOrNull(String path) {
        if (path == null) return null;
        char sep = File.separatorChar;
        int last = path.length() - 1;
        int idx = last;
        int adjacentDots = 0;
        int nonDotCount = 0;
        while (idx > 0) {
            char c = path.charAt(idx);
            if (c == '.') {
                if (++adjacentDots >= 2) {
                    // Punt on pathnames containing . and ..
                    return null;
                }
            } else if (c == sep) {
                if (adjacentDots == 1 && nonDotCount == 0) {
                    // Punt on pathnames containing . and ..
                    return null;
                }
                if (idx == 0 ||
                        idx >= last - 1 ||
                        path.charAt(idx - 1) == sep) {
                    // Punt on pathnames containing adjacent slashes
                    // toward the end
                    return null;
                }
                return path.substring(0, idx);
            } else {
                ++nonDotCount;
                adjacentDots = 0;
            }
            --idx;
        }
        return null;
    }

    /* -- Attribute accessors -- */

    public native int getBooleanAttributes0(File f);


    public native boolean checkAccess(File f, int access);

    public native long getLastModifiedTime(File f);

    public native long getLength(File f);

    public native boolean setPermission(File f, int access, boolean enable, boolean owneronly);

    /* -- File operations -- */

    public native boolean createFileExclusively(String path)
            throws IOException;

    public boolean delete(File f) {
        // Keep canonicalization caches in sync after file deletion
        // and renaming operations. Could be more clever than this
        // (i.e., only remove/update affected entries) but probably
        // not worth it since these entries expire after 30 seconds
        // anyway.
        return delete0(f);
    }

    private native boolean delete0(File f);

    public native String[] list(File f);

    public native boolean createDirectory(File f);

    public boolean rename(File f1, File f2) {
        // Keep canonicalization caches in sync after file deletion
        // and renaming operations. Could be more clever than this
        // (i.e., only remove/update affected entries) but probably
        // not worth it since these entries expire after 30 seconds
        // anyway.
        return rename0(f1, f2);
    }

    private native boolean rename0(File f1, File f2);

    public native boolean setLastModifiedTime(File f, long time);

    public native boolean setReadOnly(File f);


    /* -- Filesystem interface -- */

    public File[] listRoots() {
        try {
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkRead("/");
            }
            return new File[]{new File("/")};
        } catch (SecurityException x) {
            return new File[0];
        }
    }

    /* -- Disk usage -- */
    public native long getSpace(File f, int t);

    /* -- Basic infrastructure -- */

    public int compare(File f1, File f2) {
        return f1.getPath().compareTo(f2.getPath());
    }

    public int hashCode(File f) {
        return f.getPath().hashCode() ^ 1234321;
    }

}
