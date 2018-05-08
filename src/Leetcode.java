import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Leetcode {

    public int[] my_twoSum(int[] nums, int target) {
        int[] index_two = new int[2];
        out:
        for(int i =0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if ((nums[i]+nums[j])==target){
                    index_two[0] = i;
                    index_two[1] = j;
                    break out;
                }
            }
        }
        return index_two;
    }

    public int[] twoSum(int[] nums,int target){

        Map<Integer,Integer> numsMap = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            numsMap.put(nums[i],i);
        }
        for (int i = 0; i <nums.length ; i++) {
            int complement = target - nums[i];
            if(numsMap.containsKey(complement)&&numsMap.get(complement)!=i){
                return new int[]{i, numsMap.get(complement)};
            }
        }
        System.out.println("数组里面没这两个数！");
        return null;
    }

    public ListNode my_addTwoNumbers(ListNode l1, ListNode l2) {
        //先排除两个数有0值的情况
        if (l1.val==0){
            return l2;
        }
        if (l2.val==0){
            return l1;
        }

        ListNode listNode = l1;
        int flag = 0;
        while (l1!=null&&l2!=null){
            if (l1.val+l2.val+flag>=10){
                l1.val = l1.val+l2.val+flag-10;
                flag =1;
            }else {
                l1.val = l1.val+l2.val+flag;
                flag = 0;
            }
            l1=l1.next;
            l2=l2.next;
        }
        return listNode;
    }

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public void printAll(ListNode listNode){
        String num = "";
        while(listNode!=null){
            num = num + listNode.val;
            listNode = listNode.next;
        }
        System.out.println(num);
    }

    public ListNode ArrayToListNode(int[] num){
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        for (int i=0;i<num.length;i++){
            listNode.next = new ListNode(num[i]);
            listNode = listNode.next;
        }
        return head;
    }


    public static void main(String args[]){

        Leetcode myLeetcode = new Leetcode();

        //twoSum
        /*
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] index_two = myLeetcode.twoSum(nums,target);
        System.out.println("["+index_two[0]+","+index_two[1]+"]!");
        */

        //addTwoNumbers

       /*
        int[] num1 = {2,4,3,5};
        int[] num2 = {5,6,4};
        ListNode listNode1 = myLeetcode.ArrayToListNode(num1);
        ListNode listNode2 = myLeetcode.ArrayToListNode(num2);
        ListNode myListNode = myLeetcode.addTwoNumbers(listNode1.next,listNode2.next);
        myLeetcode.printAll(myListNode);
        */



    }



}
