public class Leetcode {


    public int[] twoSum(int[] nums, int target) {
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


    public static void main(String args[]){

        Leetcode myLeetcode = new Leetcode();

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] index_two = myLeetcode.twoSum(nums,target);
        System.out.print("刷的第一个题目，继续加油！");
        System.out.print("刷的第一个题目，继续加油！");
        System.out.print("刷的第一个题目，继续加油！");
        
    }

}
