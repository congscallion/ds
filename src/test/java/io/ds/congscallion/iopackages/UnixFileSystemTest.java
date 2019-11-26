package io.ds.congscallion.iopackages;

import org.junit.Test;

import java.io.File;


public class UnixFileSystemTest {

    @Test
    public void test1(){
        UnixFileSystemDemo unixFileSystem = new UnixFileSystemDemo();


        String a = unixFileSystem.normalize("a/c/v/f/f/[a]");
        System.out.println(a);

        boolean absolute = unixFileSystem.isAbsolute(new File("/a.txt"));
        System.out.println(absolute);

        String resolve = unixFileSystem.resolve("/ab/f/g", "ik/dl");
        System.out.println(resolve);

    }
}
