/**
 * Copyright(c) 2020-2025 www.5ysa.com
 */
package io.ds.congscallion.collection;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.junit.Test;

/**
 * @author slydm
 * @data TreeMapTest.java 20-2-8 上午10:33
 */
public class TreeMapTest {


  /**
   * TreeMap中的默认排序
   */
  @Test
  public void test1(){

    TreeMap<Integer, String> map = new TreeMap<>();
    map.put(3, "val");
    map.put(2, "val");
    map.put(1, "val");
    map.put(5, "val");
    map.put(4, "val");

    assertEquals("[1, 2, 3, 4, 5]", map.keySet().toString());
  }

  /**
   * 使用字符串时，它们将按照其自然顺序（即按字母顺序）排序
   */
  @Test
  public void test2(){
    TreeMap<String, String> map = new TreeMap<>();
    map.put("c", "val");
    map.put("b", "val");
    map.put("a", "val");
    map.put("e", "val");
    map.put("d", "val");

    assertEquals("[a, b, c, d, e]", map.keySet().toString());

  }

  /**
   * TreeMap中的自定义排序
   */
  @Test
  public void test3(){
    TreeMap<Integer, String> map =  new TreeMap<>(Comparator.reverseOrder());
    map.put(3, "val");
    map.put(2, "val");
    map.put(1, "val");
    map.put(5, "val");
    map.put(4, "val");

    assertEquals("[5, 4, 3, 2, 1]", map.keySet().toString());

  }


  /**
   * 现在我们知道TreeMap将所有条目存储在已排序的顺序中。
   * 由于TreeMap的这一属性，我们可以执行类似的查询；找到“最大”，找到“最小”，找到所有小于或大于某个值的键，等等。
   */
  @Test
  public void test4(){
    TreeMap<Integer, String> map = new TreeMap<>();
    map.put(3, "val");
    map.put(2, "val");
    map.put(1, "val");
    map.put(5, "val");
    map.put(4, "val");

    Integer highestKey = map.lastKey();
    Integer lowestKey = map.firstKey();

    Set<Integer> keysLessThan3 = map.headMap(3).keySet();
    Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();

    assertEquals(new Integer(5), highestKey);
    assertEquals(new Integer(1), lowestKey);
    assertEquals("[1, 2]", keysLessThan3.toString());
    assertEquals("[3, 4, 5]", keysGreaterThanEqTo3.toString());

  }

  @Test
  public void test5(){

    TreeMap<Integer, String> map = new TreeMap<>();
    map.put(1,"val");
    map.put(3,"val");
    map.put(5,"val");
    map.put(7,"val");
    map.put(9,"val");

    assertEquals(new Integer(5), map.floorEntry(5).getKey());
    assertEquals(new Integer(5), map.floorKey(5));

    assertEquals(new Integer(3), map.lowerEntry(5).getKey());
    assertEquals(new Integer(3), map.lowerKey(5));

    assertEquals(new Integer(5), map.higherKey(3));
  }

}
