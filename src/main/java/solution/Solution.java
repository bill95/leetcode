package solution;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /*   给定一个 32 位有符号整数，将整数中的数字进行反转。

       示例 1:

       输入: 123
       输出: 321
       示例 2:

       输入: -123
       输出: -321
       示例 3:

       输入: 120
       输出: 21
       注意:

       假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。*/
    public int reverse(int x) {
        String st = String.valueOf(x);
        long l1 = Long.parseLong(st);
        long x1 = Math.abs(l1);
        String s = String.valueOf(x1);
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        long l = Long.parseLong(s1);
        if (x < 0) {
            l = -l;
        }

        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        }
        return x < 0 ? -Integer.parseInt(s1) : Integer.parseInt(s1);
    }

    /* 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

     示例 1:

     输入: 121
     输出: true
     示例 2:

     输入: -121
     输出: false
     解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     示例 3:

     输入: 10
     输出: false
     解释: 从右向左读, 为 01 。因此它不是一个回文数。
     进阶:

     你能不将整数转为字符串来解决这个问题吗？*/
    public boolean isPalindrome(int x) {
        String text = String.valueOf(x);

        if (x < 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder(text);
        String text2 = sb.reverse().toString();
        return text.equals(text2);
    }

    /* 给定一个字符串，找出不含有重复字符的最长子串的长度。

     示例：

     给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

     给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

     给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。*/
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int res = 0;
        HashSet<Character> sets = new HashSet<Character>();
        while (i < n && j < n) {
            if (!sets.contains(s.charAt(j))) {
                sets.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                sets.remove(s.charAt(i++));
            }
        }
        return sets.size();
    }


}
