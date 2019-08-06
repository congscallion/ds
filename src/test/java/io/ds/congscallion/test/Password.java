/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.test;

import org.junit.Test;

/**
 * @author wangcong
 * @version $Id: Password.java, v0.1 7/18/19 1:59 PM wangcong Exp $$
 */
public class Password {


    @Test
    public void test() {

        int min = 222222;
        int max = 666666;

        for (int i = min; i <= max; i++) {
            String str = String.valueOf(i);

            if (str.indexOf("1") >= 0) {
                continue;
            }

            if (str.indexOf("4") >= 0) {
                continue;
            }
            if (str.indexOf("7") >= 0) {
                continue;
            }
            if (str.indexOf("8") >= 0) {
                continue;
            }
            if (str.indexOf("9") >= 0) {
                continue;
            }
            if (str.indexOf("0") >= 0) {
                continue;
            }

            if (str.indexOf("5") >= 0) {
                continue;
            }

            if (str.startsWith("33") && (str.contains("33") || str.contains("22") || str.contains("66"))) {
                System.out.println(str);
            }


        }

    }


}
