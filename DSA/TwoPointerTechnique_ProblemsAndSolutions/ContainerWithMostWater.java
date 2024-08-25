public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            // Calculate the area with the current pair of lines
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // Update the maximum area if the current area is larger
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointers based on the height comparison
            if (height[left] < height[right]) {
                left++; // Move left pointer to the right
            } else {
                right--; // Move right pointer to the left
            }
        }
        
        return maxArea; // Return the maximum area found
    }
}
