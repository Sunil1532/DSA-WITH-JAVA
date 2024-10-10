class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty()||nums[stack.peek()]>nums[i]){
                stack.push(i);
            }
        }
        int max=0;
        for(int j=n-1;j>=0;--j){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[j]){
                max=Math.max(max,j-stack.pop());
            }
        }
        return max;
    }
}


Topics
Companies
A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.

 

Example 1:

Input: nums = [6,0,8,2,1,5]
Output: 4
Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
