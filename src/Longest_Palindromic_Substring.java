import java.util.HashMap;
import java.util.Map;

public class Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {
        Map<Character,String> mymap = new HashMap<>();
        mymap = stringToHashMap(s);

        for(int i=0;i<s.length();i++){

        }
        return null;
    }

    //判断一个String是否是Palindromic(对称数)
    public boolean checkIfPalindromic(String s){
        int start = 0;
        int end = s.length();
        while (start<=end){
           if(s.charAt(start)!=s.charAt(end)){
                return false;
           }
           start++;
           end--;
        }
        return true;
    }

    //将一个字符串转化为HashMap类型。
    public Map<Character,String> stringToHashMap(String s){
        Map<Character,String>  mymap = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            Character char_index_i = s.charAt(i);
            if (mymap.containsKey(char_index_i)){
                String newValue = ""+mymap.get(char_index_i)+"-"+i;
                mymap.put(char_index_i,newValue);
            }else {
                mymap.put(char_index_i,""+i);
            }
        }
        return mymap;
    }
    public static void main(String args[]){
        Longest_Palindromic_Substring mylongest_palindromic_substring = new Longest_Palindromic_Substring();

    }
}
