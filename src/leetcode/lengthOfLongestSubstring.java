package leetcode;
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

/* 窗口定义 */
class window
{
	public int beg;
	public int end;
	public window()
	{
		beg = 0;
		end = 0;
	}
	public window(int b,int e)
	{
		this.beg = b;
		this.end = e;
	}
	public int size()
	{
		if(beg <= end)
		{
			return end - beg;
		}
		return 0;
	}
	public void rightExpand(int step)
	{
		this.end += step;
	}
	public void leftContract(int step)
	{
		this.beg += step;
	}
	public void rightContract(int step)
	{
		this.end -= step;
	}
	public void leftExpand(int step)
	{
		this.beg -= step;
	}
}
class Solution3 {
	static int isSubstringConsistOfChar(String substring,char c)
	{
		for(int index = 0;index < substring.length();++index)
		{
			if(substring.charAt(index) == c)
			{
				return index;
			}
		}
		return -1;
	}
	
    public static int lengthOfLongestSubstring(String s) {
        window w = new window();
        int maxSize = 0;
        while(w.end < s.length())
        {
        	int stringContainChar = isSubstringConsistOfChar(s.substring(w.beg, w.end),s.charAt(w.end));
        	if(stringContainChar == -1)
        	{
        		++w.end;
        	}
        	else
        	{
        		maxSize = Math.max(maxSize, w.size());
        		w.beg = w.beg + stringContainChar + 1;
        	}
        }
        maxSize = Math.max(maxSize, w.size());
        return maxSize;
    }
    
    public static void main(String []args)
    {
    	System.out.println(Solution3.lengthOfLongestSubstring("pwwkew"));
    }
}