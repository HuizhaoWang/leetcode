import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


public class LongestSubstring {

    public Map<Character,Integer> charArrayToMap(char[] mychars){
        Map<Character,Integer> map = new HashMap<>();
        for (int i =0;i<mychars.length;i++){
            map.put(mychars[i],i);
        }
        return map;
    }

    public void Traversal(Map<Character,Integer> map){
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Character,Integer> entry = (Map.Entry<Character,Integer>) iter.next();
            char key = entry.getKey();
            int index = entry.getValue();
            System.out.println(""+key+":"+index);
        }
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        char[] mychars = s.toCharArray();
        int length = 1;
        int start_index = 0;//用于记录当前最长字串起始位置
        int end_index = 0;//用于记录当前最长字串结束位置
        int maybe_start = 0;//用于记录可能的起始位置
        int index = 0;//用于记录重复的位置
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<mychars.length;i++){
            if (!map.containsKey(mychars[i])){
                map.put(mychars[i],i);
            }else {
                index = map.get(mychars[i]);
                if (i-maybe_start>length){
                    end_index = i -1;
                    start_index = maybe_start;
                    length = i - maybe_start;
                }
                for (int j = maybe_start;j<=index;j++){
                    map.remove(mychars[j]);
                }
                maybe_start = index+1;
                map.put(mychars[i],i);
            }
        }
        for (int i = start_index; i <=end_index ; i++) {
            System.out.println(mychars[i]+":"+i);
        }
        return length;
    }

    public static void main(String args[]){
        String mychars = "abcbcbacdbcad";

        LongestSubstring longestSubstring = new LongestSubstring();
        int length = longestSubstring.lengthOfLongestSubstring(mychars);
        System.out.println(length);


    }
}
