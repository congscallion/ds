///**
// * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
// */
//package io.ds.congscallion.array.chat01;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.Test;
//
///**
// * @author wangcong
// * @version $Id: ArraysTest.java, v0.1 6/5/19 9:14 AM wangcong Exp $$
// */
//public class ArraysTest {
//
//
//    @Test
//    public void testBinarySearch() {
//
//        double[] a = {10.0d, 11.02d, 121.132d, 1891.3432423d};
//        int index = Arrays.binarySearch(a, 0, a.length, 10.0d);
//        assertThat(index == 0).isTrue();
//        index = Arrays.binarySearch(a, 0, a.length, 1891.3432423d);
//        assertThat(index == 3).isTrue();
//        index = Arrays.binarySearch(a, 0, a.length, 1891.2d);
//        assertThat(index < 0).isTrue();
//
//    }
//
//
//    @Test
//    public void testDeepEquals() {
//        // 比较基本类型
//        int a1[][] = {{10, 20},
//                {40, 50},
//                {60, 70}};
//
//        int a2[][] = {{30, 20},
//                {10, 0},
//                {60, 80}};
//
//        int a3[][] = {{10, 20},
//                {40, 50},
//                {60, 70}};
//
//        assertThat(java.util.Arrays.deepEquals(a1, a2)).isFalse();
//        assertThat(java.util.Arrays.deepEquals(a1, a3)).isTrue();
//
//        // 比较引用类型
//        Object[][] o1 = {{null}, {null}};
//        Object[][] o2 = {{null}, {null}};
//        assertThat(java.util.Arrays.deepEquals(o1, o2)).isTrue();
//
//        Object[] o3 = {null, null, null};
//        Object[] o4 = {null, null, null};
//        assertThat(java.util.Arrays.deepEquals(o3, o4)).isTrue();
//
//        // 比较自定义对象
//        Employee e1[][] = {{new Employee(10, "Geek1"), new Employee(11, "Geek2")},
//                {new Employee(12, "Geek3"), new Employee(13, "Geek4")}};
//
//        Employee e2[][] = {{new Employee(10, "Geek1"), new Employee(11, "Geek2")},
//                {new Employee(12, "Geek3"), new Employee(13, "Geek4")}};
//
//        Employee e3[][] = {{new Employee(12, "Geek2"), new Employee(25, "Geek4")},
//                {new Employee(15, "Geek3"), new Employee(30, "Geek1")}};
//
//        assertThat(java.util.Arrays.deepEquals(e1, e2)).isTrue();
//        assertThat(java.util.Arrays.deepEquals(e2, e3)).isFalse();
//        assertThat(java.util.Arrays.deepEquals(e1, e3)).isFalse();
//
//    }
//
//
//    class Employee {
//
//        int Eid;
//        String Ename;
//
//        public Employee(int Eid, String Ename) {
//            this.Eid = Eid;
//            this.Ename = Ename;
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            Employee s = (Employee) obj;
//            return (this.Eid == s.Eid && this.Ename.equals(s.Ename));
//        }
//    }
//
//
//    @Test(expected = AssertionError.class)
//    public void testAssertKeyWrod() {
//
//        int a = 0;
//        assert a == 1 : "变量a不等于1";
//
//    }
//
//
//    @Test
//    public void testParallelPrefix() {
//
//        int[] a = {1, 2, 3, 4};
//
//        java.util.Arrays.parallelPrefix(a, (x, y) -> x + y);
//
//        System.out.println(java.util.Arrays.toString(a));
//    }
//
//    @Test
//    public void testParallelSetAll() {
//
//        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//
//        java.util.Arrays.parallelSetAll(a, i -> {
//            if (i % 2 == 0) {
//                return a[i] * 2;
//            } else {
//                return a[i];
//            }
//
//        });
//        System.out.println(java.util.Arrays.toString(a));
//
//        System.out.println(1 << 13);
//
//    }
//
//
//}
