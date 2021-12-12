package com.univers.lib.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jay.Xu
 *
 * @since 2021/12/12
 *
 * 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xm1rfd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCodeDay18 {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,3,4,1}));
        System.out.println(containsDuplicate(new int[]{1,3,4,2}));
    }

    public static boolean containsDuplicate(int[] nums) {
        // Map<Integer,Integer> map =new HashMap<>();
        // for(int num:nums){
        // if(map.containsKey(num)){
        // return true;
        // }else{
        // map.put(num,1);
        // }
        // }
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }
        }
        return false;
    }
}