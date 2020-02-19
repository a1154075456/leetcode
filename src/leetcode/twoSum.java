package leetcode;

import java.util.*;
/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 
 * 两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution1 {
	/* 使用HashMap将元素与其下标对应起来进行处理 */
    public static int[] twoSum(int[] nums, int target) {
    	HashMap<Integer,Integer> hashlist = new HashMap<Integer,Integer>(nums.length);
        /* 第一步，将nums数组中的元素插入HashMap中 */
    	for(int index = 0;index < nums.length;++index)
    	{
    		hashlist.put(nums[index], index);
    	}
    	/* 第二步，再次遍历数组，查找符合条件的元素 */
    	for(int index = 0;index < nums.length;++index)
    	{
    		Integer mateValue = target - nums[index];
    		if(hashlist.containsKey(mateValue) && hashlist.get(mateValue) != index)
    		{
    			return new int[] {index,hashlist.get(mateValue)};
    		}
    	}
    	return null;
    }
    
    public static void main(String[] args)
    {
    	int[] nums = new int[] {2,7,11,15};
    	int target = 9;
    	int[] result = Solution1.twoSum(nums, target);
    	if(result != null)
    	{
    		for(int e : result)
    		{
    			System.out.println(e);
    		}
    	}
    }
}