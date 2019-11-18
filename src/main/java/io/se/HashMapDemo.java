package io.se;

import java.util.HashMap;


/**
 * HashMap要点：
 * 1、如何有效的根据Key值查找Value?
 * 2、如何解决Hash冲突?
 * 3、HashMap如何改善hash值?
 * 4、HashMap如何提高hash值对数组长度的取模运算?
 * 5、链表长度过长怎么办?
 * 6、什么时候扩容?
 * 7、每次扩多少?
 * 8、扩容时，链表拆分是如何工作的?
 * <p>
 * <p>
 * static final int tableSizeFor(int cap)
 * tableSizeFor这个方法用于找到大于等于initialCapacity的最小的2的幂
 */
public class HashMapDemo {


    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(i + "", i + "");
        }


        HashMap<String, String> map2 = new HashMap<>(map);


    }

}
