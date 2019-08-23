/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array;

import java.util.BitSet;

/**
 *
 *
 * @author wangcong
 * @version $Id: BitSet1.java, v0.1 8/23/19 3:09 PM wangcong Exp $$
 */
public class BitSet1 {


    public static void main(String[] args) {

        BitSet bs1 = new BitSet();
        bs1.set(0);
        bs1.set(1);
//        bs1.set(3);
        bs1.set(8);

        System.out.println(bs1);

        System.out.println(bs1.get(0));
        System.out.println(bs1.get(1));
        System.out.println(bs1.get(2));
        System.out.println(bs1.get(3));
        System.out.println(bs1.get(4));
        System.out.println(bs1.get(5));
        System.out.println(bs1.get(6));
        System.out.println(bs1.get(7));
        System.out.println(bs1.get(8));

        int cardinality = bs1.cardinality();
        System.out.println(cardinality);
        System.out.println(bs1.length());



        BitSet bs2 = new BitSet();

        bs2.set(0);
        bs2.set(1);
        bs2.set(2);
        bs2.set(3);
        bs2.set(4);


        bs1.xor(bs2);

        System.out.println(bs1);


        bs2.xor(bs1);
        System.out.println(bs2);


    }


}
