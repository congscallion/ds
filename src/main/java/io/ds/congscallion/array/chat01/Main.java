/**
 * BrandBigData.com Inc. Copyright (c) 2019 All Rights Reserved.
 */
package io.ds.congscallion.array.chat01;

/**
 * @author wangcong
 * @version $Id: Main.java, v0.1 5/28/19 9:03 PM wangcong Exp $$
 */
public class Main {

  public static void main(String[] args) {

    int r = 5;

    // 声明一有5列的二维数组
    int arr[][] = new int[r][];

    // 给每行创建合适大小的数组
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new int[i + 1];

    }

    // 初始化
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = count++;
      }

    }

    // 打印数组
    System.out.println("Contents of 2D Jagged Array");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

  }

}
