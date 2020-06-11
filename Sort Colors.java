class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[] {0, 0, 0};
        
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            
            for (int colorIndex = target; colorIndex < colors.length; colorIndex++) {
                int index = colors[colorIndex]++;
                
                if (colorIndex == 0 || index >= colors[colorIndex - 1]) {
                    nums[index] = colorIndex;
                }
            }
        }
    }
}