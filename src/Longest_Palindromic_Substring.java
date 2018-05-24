import java.util.HashMap;
import java.util.Map;

public class Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {
        Map<Character,String> mymap = stringToHashMap(s);
        int s_length = s.length();
        int start=0;
        int end=0;
        int longest = 1;
        for(int i=0;i<s_length;i++){
            if (longest>=(s_length-i)){
                break;
            }
            char mykey = s.charAt(i);
            String myvalue_indexs = mymap.get(mykey);
            String indexs[] = myvalue_indexs.split("-");
            for(int j=indexs.length-1;j>=0;j--){
                int index = Integer.parseInt(indexs[j]);
                if (((index-i+1)>longest)&&checkIfPalindromic(s.substring(i,index+1))){
                    start = i;
                    end = index;
                    longest = end - start + 1;
                    break;
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
                String newValue = mymap.get(char_index_i)+"-"+i;
                mymap.put(char_index_i,newValue);
            }else {
                mymap.put(char_index_i,""+i);
            }
        }
        return mymap;
    }

    public int start = 0;
    public int end = 0;

    public String new_longestPalindrome(String s){
        if(s.length()<2) return s;
        for(int i=0;i<s.length()-1;i++){
            getPalindrom(s,i,i);
            getPalindrom(s,i,i+1);
        }
        return s.substring(start,end+1);
    }

    public void getPalindrom(String s,int low,int high){
        while (low>=0&&high<s.length()&&s.charAt(low)==s.charAt(high)){
            low --;
            high ++;
        }
        if (high-low>end-start){
            end = high;
            start = low;
        }
    }

    public static void main(String args[]){
        Longest_Palindromic_Substring mylongest_palindromic_substring = new Longest_Palindromic_Substring();
        String newString = "aa";
//        System.out.println(mylongest_palindromic_substring.stringToHashMap(newString));
//        System.out.println(mylongest_palindromic_substring.longestPalindrome(newString));

        System.out.println(mylongest_palindromic_substring.new_longestPalindrome(newString));

    }
}
