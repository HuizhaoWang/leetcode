import java.util.HashMap;
import java.util.Map;

public class Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {
        Map<Character,String> mymap = new HashMap<>();
        mymap = stringToHashMap(s);
        int s_length = s.length();
        int start=0;
        int end=0;
        int longest = end - start;
        for(int i=0;i<s_length;i++){
            if (longest>=(s_length-i)){
                break;
            }
            char mykey = s.charAt(i);
            String myvalue_indexs = mymap.get(mykey);
            String indexs[] = myvalue_indexs.split("-");
            for(int j=indexs.length-1;j>=0;j--){
                int index = Integer.parseInt(indexs[j]);
                if (((index-i)>longest)&&checkIfPalindromic(s.substring(i,index+1))){
                    start = i;
                    end = index;
                    continue;
                }
            }

        }
        return s.substring(start,end+1)+":"+start+","+end;
    }

    //判断一个String是否是Palindromic(对称数)
    public boolean checkIfPalindromic(String s){
        int start = 0;
        int end = s.length()-1;
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
            char char_index_i = s.charAt(i);
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
        String newString = "ccc";
        System.out.println(mylongest_palindromic_substring.longestPalindrome(newString));

    }
}
