public class Solution {
    public int MaxArea(int[] height) {
        
        int max = 0;

        int left = 0;
        int right = height.Length - 1;

        while (left < right) {
            int b = right - left;
            int h = Math.Min(height[left], height[right]);
            int area = b * h;
            max = Math.Max(max, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
