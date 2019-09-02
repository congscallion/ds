/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.algorithm.sorting;

/**
 *
 * <p><pre>
 * 排序算法用于根据元素上的比较运算符重新排列给定数组或列表元素。比较运算符用于确定相应数据结构中元素的新顺序。
 *
 * What is in-place sorting?
 *
 * 就地排序算法使用常量额外空间来生成输出（仅修改给定数组）。它仅通过修改列表中元素的顺序对列表进行排序。
 * 例如，插入排序和选择排序是就地排序算法，因为它们不使用任何额外的空间来排序列表，并且Merge Sort的典型实现不是就地排序，计数排序的实现也不是就地排序算法。
 *
 * What are Internal and External Sortings?
 *
 * 外部排序是一类可以处理大量数据的排序算法的术语。当被排序的数据不适合计算设备（通常是RAM）的主存储器时，需要进行外部排序，
 * 而是必须将它们驻留在较慢的外部存储器（通常是硬盘驱动器）中。外部排序通常使用混合排序合并策略。
 * 在排序阶段，读取，排序和写出临时文件的数据块足够小以适合主存储器。在合并阶段，已排序的子文件将合并为一个更大的文件。
 *
 * 外部排序的一个示例是外部合并排序算法，该算法对每个适合RAM的块进行排序，然后将排序后的块合并在一起。
 * 我们首先将文件划分为运行，使得运行的大小足够小以适合主存储器。然后使用合并排序排序算法对主内存中的每个运行进行排序
 * 最后将生成的运行合并到连续更大的运行中，直到文件被排序。
 *
 * 当所有数据都放在内存中时，排序称为内部排序。
 *
 * What is stable sorting?
 * 假设在待排序的文件中，存在两个或两个以上的记录具有相同的关键字，在用某种排序法排序后，若这些相同关键字的元素的相对次序仍然不变，则这种排序方法
 * 是稳定的。其中冒泡，插入，基数，归并属于稳定排序，选择，快速，希尔，归属于不稳定排序。
 *
 * Time Complexities of all Sorting Algorithms
 *
 *
 *       Algorithm	                TimeComplexity
 *                          Best	        Average	        Worst
 *   Selection Sort	    Ω(n^2)	        θ(n^2)	        O(n^2)
 *   Bubble Sort	    Ω(n)	        θ(n^2)	        O(n^2)
 *   Insertion Sort	    Ω(n)	        θ(n^2)	        O(n^2)
 *   Heap Sort	            Ω(n log(n))	        θ(n log(n))	O(n log(n))
 *   Quick Sort	            Ω(n log(n))	        θ(n log(n))	O(n^2)
 *   Merge Sort	            Ω(n log(n))	        θ(n log(n))	O(n log(n))
 *   Bucket Sort	    Ω(n+k)	        θ(n+k)	        O(n^2)
 *   Radix Sort     	    Ω(nk)	        θ(nk)	        O(nk)
 *
 *
 * </pre></p>
 *
 *
 * @author wangcong
 * @version $Id: Sort.java, v0.1 8/26/19 10:27 AM wangcong Exp $$
 */
public interface Sort {

}
