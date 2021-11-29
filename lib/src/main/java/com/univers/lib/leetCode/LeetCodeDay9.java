package com.univers.lib.leetCode;

/**
 * Created by Jay.Xu
 *
 * @since 2021/11/28
 * 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xah8k6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCodeDay9 {
    public static void main(String[] args) {
        String demo = "A man, a plan, a canal: Panama";
        String demo2 = "i am A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(demo));
        System.out.println(isPalindrome(demo2));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;
        int indexLeft = 0;
        int indexRight = s.length() - 1;
        while (indexLeft < indexRight) {
            while (indexLeft < indexRight && !Character.isLetterOrDigit(s.charAt(indexLeft))) {
                indexLeft++;
            }
            while (indexLeft < indexRight && !Character.isLetterOrDigit(s.charAt(indexRight))) {
                indexRight--;
            }
            if (Character.toLowerCase(s.charAt(indexLeft)) != Character.toLowerCase(s.charAt(indexRight))) {
                return false;
            }
            indexLeft++;
            indexRight--;
        }
        return true;
    }
}
