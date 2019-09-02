package io.ds.congscallion.string;


/**
 * 计算给定字符串所有字符拼列
 *
 * 比如给定字符串"xyz"， 程序将输出："xyz, xzy, yxz, yzx, zxy, zyx"
 */
public class StringPermutations {

  public static void permute(String word, int l, int r) {

    if (l == r) {
      System.out.println(word);
    } else {

      for (int i = l; i <= r; i++) {
        word = swap(word, l, i);
        permute(word, l + 1, r);
        word = swap(word, l, i);
      }
    }

  }

  private static String swap(String word, int i, int j) {
    char[] charArray = word.toCharArray();
    char temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }


  public static void permute2(String str, String ans) {
    // If string is empty
    if (str.length() == 0) {
      System.out.print(ans + " ");
      return;
    }

    for (int i = 0; i < str.length(); i++) {

      // ith character of str
      char ch = str.charAt(i);

      // Rest of the string after excluding
      // the ith character
      String ros = str.substring(0, i) +
          str.substring(i + 1);

      // Recurvise call
      permute2(ros, ans + ch);
    }
  }


  public static void main(String[] args) {
//    String str = "ABC";
//    int n = str.length();
//    StringPermutations.permute(str, 0, n-1);

    String s = "abc";
    permute2(s, "");


  }


}
