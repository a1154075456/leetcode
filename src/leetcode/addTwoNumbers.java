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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode result = new ListNode(0);
       ListNode p = l1;
       ListNode q = l2;
       ListNode r = result;
       int bitsum = 0;
	   int flag = 0;
	   
       for(p = l1,q = l2;p != null && q != null;p = p.next,q=q.next)
       {
    	   bitsum = p.val + q.val + flag;
    	   if(bitsum >= 10)
    	   {
    		   bitsum -= 10;
    		   flag = 1;
    	   }
    	   else
    	   {
    		   flag = 0;
    	   }
    	   r.val = bitsum;
    	   if(p.next == null && q.next == null && flag == 0)
    	   {
    		   r.next = null;
    		   return result;
    	   }
    	   else
    	   {
    		   r.next = new ListNode(0);
    		   r = r.next;
    	   }
       }
       if(q != null)
       {
    	   p = q;
       }
     
       while(p != null || flag != 0)
       {
    	   if(p == null)
    	   {
    		   bitsum = flag;
    	   }
    	   else
    	   {
    	       bitsum = p.val + flag;
    	   }
    	   if(bitsum >= 10)
    	   {
    		   bitsum -= 10;
    		   flag = 1;
    	   }
    	   else
    	   {
    		   flag = 0;
    	   }
    	   r.val = bitsum;
    	   if((p == null || p.next == null) && flag == 0)
    	   {
    		   r.next = null;
    		   return result;
    	   }
    	   else
    	   {
    		   r.next = new ListNode(0);
    		   r = r.next;
    	   }
    	   if(p != null)
    	   {
    		   p = p.next;
    	   }
       }
       return result;
    }
    
    public static void main(String[] s)
    {
    	ListNode l1 = new ListNode(0);
    	ListNode l2 = new ListNode(0);
  
    	l1 = convertIntegerToListNode(l1,465);
    	l2 = convertIntegerToListNode(l2,9999999991L);
    	/*ListNode p = l2;
    	while(p != null)
    	{
    		System.out.println(p.val);
    		p = p.next;
    	}*/
    	//long result1 = convertListNodeToInteger(l1);
    	//System.out.println(result1);
    	long result2 = convertListNodeToInteger(l2);
    	System.out.println(result2);
    	//ListNode l3 = addTwoNumbers(l1,l2);
    	//long result = convertListNodeToInteger(l3);
    	
    	//System.out.println("result1 + result2 = "+(result1+result2));
    	
    	//System.out.println(result);
    }
}