package leetcode;

/**
 * 给出两个 非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class Solution2 {
	/* 将ListNode转化为数字 */
	static long convertListNodeToInteger(ListNode l)
	{
		int mul = 1;
		long result = 0;
		ListNode p = l;
		
		while(p != null)
		{
			System.out.println("p.val"+p.val+" result:"+result);
			result = result + p.val * mul;
			mul *= 10;
			p = p.next;
		}
		System.out.println("\n");
		return result;
	}
	
	/* 使用尾插法将整数转化为链表 */
	static ListNode convertIntegerToListNode(ListNode l, long value)
	{
		//System.out.println(value);
		int last = 0; 
		long remain = value;
		ListNode p = l;
		
		do
		{
			last = (int)(remain % 10);
			p.val = last;
			//System.out.println(remain);
			remain /= 10;
			if(remain != 0)
			{
				p.next = new ListNode(0);
				p = p.next;
			}
			else
			{
				p.next = null;
			}
		}
		while(remain != 0);
		return l;
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long v1 = convertListNodeToInteger(l1);
        long v2 = convertListNodeToInteger(l2);
        ListNode l = new ListNode(0);
        convertIntegerToListNode(l,(long)(v1 + v2));
        return l;
    }
    
    public static void main(String[] s)
    {
    	ListNode l1 = new ListNode(0);
    	ListNode l2 = new ListNode(0);
  
    	l1 = convertIntegerToListNode(l1,9);
    	l2 = convertIntegerToListNode(l2,9999999991L);
    	
    	//long result1 = convertListNodeToInteger(l1);
    	//System.out.println(result1);
    	//long result2 = convertListNodeToInteger(l2);
    	//System.out.println(result2);
    	ListNode l3 = addTwoNumbers(l1,l2);
    	long result = convertListNodeToInteger(l3);
    	
    	//System.out.println("result1 + result2 = "+(result1+result2));
    	
    	//System.out.println(result);
    }
}