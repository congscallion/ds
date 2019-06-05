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


}
