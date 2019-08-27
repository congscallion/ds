/**
 * BrandBigData.com Inc. 
 * Copyright (c) 2019 All Rights Reserved.
 */
package io.algorithm.sorting;

/**
 *<p><pre>
 * 像贪婪和动态编程一样，分而治之是一种算法范式。典型的Divide and Conquer算法使用以下三个步骤解决了问题。
 * 1.划分：将给定问题分解为相同类型的子问题。
 * 2.征服：递归解决这些子问题
 * 3.结合：适当地结合答案
 *</pre>
 *
 * 以下是一些标准算法，即Divide和Conquer算法。
 *
 * <p><pre>
 * 1）二进制搜索是一种搜索算法。在每个步骤中，算法将输入元素x与数组中的中间元素的值进行比较。如果值匹配，则返回middle的索引。
 * 否则，如果x小于中间元素，则算法在中间元素的左侧重复，否则在中间元素的右侧重复。
 *
 * 2）Quicksort是一种排序算法。该算法选择一个枢轴元素，重新排列数组元素，使得小于拾取的枢轴元素的所有元素移动到枢轴的左侧，并且所有更大的元素移动到右侧。
 * 最后，算法递归地对枢轴元素左右两侧的子阵列进行排序。
 *
 * 3）Merge Sort也是一种排序算法。算法将数组分成两半，递归地对它们进行排序，最后合并两个排序的一半。
 *
 * 4）最近的一对点问题是在x-y平面的一组点中找到最接近的点对。通过计算每对点的距离并比较距离以找到最小值，可以在O（n ^ 2）时间内解决该问题。
 * Divide and Conquer算法解决了O（nLogn）时间的问题。
 *
 * 5）Strassen算法是一种有效的算法来乘以两个矩阵。一个简单的乘法两个矩阵的方法需要3个嵌套循环，并且是O（n ^ 3）。
 * Strassen的算法在O（n ^ 2.8974）时间内乘以两个矩阵。
 *
 * 6）Cooley-Tukey快速傅里叶变换（FFT）算法是最常用的FFT算法。它是一种分而治之的算法，适用于O（nlogn）时间。
 *
 * 7）用于快速乘法的Karatsuba算法它通常将两个n位数乘以最多3 n ^ {\ log_23} \大约3 n ^ {1.585}个单位数乘法（并且恰好是n ^ {\ log_23}时n是2）的幂。
 * 因此，它比传统算法更快，后者需要n2个单位数产品。特别是，如果n = 210 = 1024，则精确计数分别为310 = 59,049和（210）2 = 1,048,576。
 *</pre>
 *
 * @author wangcong
 * @version $Id: DivideAndConquerAlgorithm.java, v0.1 8/26/19 3:01 PM wangcong Exp $$
 */
public interface DivideAndConquerAlgorithm {

}
