package com.itheima.test;

import org.junit.Test;

/**
 * @Author: hsp
 * @Date: 2022/12/31-12-31-22:57
 * @Description: com.itheima.test
 * @version: 1.0.0
 */
public class Sulotion01 {

    @Test
    public void test(){
        int[] nums = {1, 2,3,4,5,6,7,8,9,10};
        int res = maxSubArray(nums);
        System.out.println("----res----->"+res);
    }

    private static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("----sum1-------->"+sum);
            res=Math.max(sum, res);
            sum = sum < 0? 0:sum;
            System.out.println("-----sum2------->"+sum);
        }
        return res;
    }
}
