import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] myString = s.toCharArray();
        int length = 0;
        int start_index = 0;
        int end_index = 0;

        Map<Character,Integer> mymap = new HashMap<>();
        for (int i =0;i<myString.length;i++){
            mymap.put(myString[i],i);
        }

        Set myset = new HashSet();
        for (int i=0;i<myString.length;i++){
            if (!myset.contains(myString[i])){
                myset.add(myString[i]);
                end_index++;
            }else {
                if (end_index - start_index + 1>length){
                    length = end_index-start_index+1;
                }
                for (int j = start_index;j<=mymap.get(myString[i]);j++){
                    myset.remove(myString[j]);
                }
                start_index = mymap.get(myString[i])+1;
            }
        }

        String longestSubstring = "";
        for (int k =start_index;k<=end_index;k++){
            longestSubstring = ""+myString[k];
        }
        System.out.println(longestSubstring);

        return length;
    }

    public static  void main(String args[]){
        String mystring = "abcabcbb";
        LongestSubstring longestSubstring = new LongestSubstring();
        int length = longestSubstring.lengthOfLongestSubstring(mystring);
        System.out.println(length);
    }
}
