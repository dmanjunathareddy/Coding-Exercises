package com.softgroup.dsa.string;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = product;
            product *= nums[i];
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf.productExceptSelf(nums);
        System.out.println("Product Except Self: " + Arrays.toString(result));
    }
}
