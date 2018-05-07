import java.util.HashMap;
import java.util.Map;

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
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

        Map<Integer,Integer> numsMap = new HashMap<Integer, Integer>();
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先排除两个数有0值的情况
        if (l1.val==0){
            return l2;
        }
        if (l2.val==0){
            return l1;
        }

        int flag = 0;
        while (l1!=null&&l2!=null){
            if (l1.val+l2.val+flag>=10){
                l1.val = l1.val+l2.val+flag-10;
            }else {
                l1.val = l1.val+l2.val+flag;
            }
            l1=l1.next;
            l2=l2.next;
        }

        if (l1==null){
            while (flag==1&&l2.val==9&&l2!=null){
                ListNode listNode = new ListNode(0);
                l1 = listNode;
                l2 = l2.next;
            }
            ListNode listNode = new ListNode(0);
            l1 = listNode;
            l1.val=1+l2.val;

            l1.next = l2;
        }

        if (l2==null){
            while(flag==1&&l1.val==9&&l1!=null){
                l1.val = 0;
                l1 = l1.next;
            }
            l1.val +=flag;
        }
        return l1;
    }

    public String printAll(ListNode listNode){
        String num = "";
        while(listNode!=null){
            num += listNode.val;
            listNode = listNode.next;
        }
        return num;
    }

    public static void main(String args[]){

        Leetcode myLeetcode = new Leetcode();



        /*twoSum
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] index_two = myLeetcode.twoSum(nums,target);
        System.out.println("["+index_two[0]+","+index_two[1]+"]!");
        */



    }

}
