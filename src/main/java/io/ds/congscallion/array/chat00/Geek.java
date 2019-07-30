package io.ds.congscallion.array.chat00;

import java.util.HashMap;
import java.util.Map;

public class Geek {

  public String name;
  public int id;

  public Geek(String name, int id) {
    this.name = name;
    this.id = id;
  }

  @Override
  public boolean equals(Object obj) {

    if (obj == this) {
      return true;
    }

    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }

    Geek g = (Geek) obj;

    return g.name.equals(this.name) && g.id == this.id;
  }

  @Override
  public int hashCode() {
    return this.id;
  }
}

class GFG {


  public static void main(String[] args) {

    Geek g1 = new Geek("aa", 1);
    Geek g2 = new Geek("aa", 1);

    if (g1.hashCode() == g2.hashCode()) {
      if (g1.equals(g2)) {
        System.out.println("Both Objects are equal. ");
      } else {
        System.out.println("Both Objects are not equal. ");
      }
    } else {
      System.out.println("Both Objects are not equal. ");
    }

    Map<Geek, String> map = new HashMap<>();
    map.put(g1, "CSE");
    map.put(g2, "IT");

    for (Geek geek : map.keySet()) {
      System.out.println(map.get(geek));
    }

  }
}
