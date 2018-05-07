import java.util.HashMap;
import java.util.Map;

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

    public static void main(String args[]){

        Leetcode myLeetcode = new Leetcode();

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] index_two = myLeetcode.twoSum(nums,target);
        System.out.println("["+index_two[0]+","+index_two[1]+"]!");
        
    }

}
