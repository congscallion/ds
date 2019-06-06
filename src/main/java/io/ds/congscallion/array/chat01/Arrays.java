/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat01;

/**
 * @author wangcong
 * @version $Id: Arrays.java, v0.1 6/5/19 9:06 AM wangcong Exp $$
 */
public class Arrays {


    public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) {

        int low = fromIndex;
        int hight = toIndex - 1;

        while (low <= hight) {

            int mid = (low + hight) >>> 1;
            double midVal = a[mid];

            if (midVal < key) {

                low = mid + 1;

            } else if (midVal > key) {
                hight = mid - 1;
            } else {

                long midBits = Double.doubleToLongBits(midVal);
                long keyBits = Double.doubleToLongBits(key);

                if (midBits == keyBits) {
                    return mid;
                } else if (midBits < keyBits) {
                    low = mid + 1;
                } else {
                    hight = mid - 1;
                }

            }

        }
        return -(low + 1);
    }


    public static byte[] copyOf(byte[] original, int newLength) {

        byte[] copy = new byte[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));

        return copy;
    }


    public static boolean deepEquals(Object[] a1, Object[] a2) {

        if (a1 == a2) {
            return true;
        }
        if (a1 == null || a2 == null) {
            return false;
        }

        int length = a2.length;
        if (a1.length != length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            Object e1 = a1[i];
            Object e2 = a2[i];

            if (e1 == e2) {
                continue;
            }

            if (e1 == null) {
                return false;
            }

            boolean eq = deepEquals0(e1, e2);
            if (!eq) {
                return false;
            }
        }

        return true;
    }

    private static boolean deepEquals0(Object e1, Object e2) {
        assert e1 != null;

        boolean eq;
        if (e1 instanceof Object[] && e2 instanceof Object[]) {
            eq = deepEquals((Object[]) e1, (Object[]) e2);
        } else {
            eq = e1.equals(e2);
        }
        return eq;
    }


}
