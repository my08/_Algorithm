package leetcode.stringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class _15_483_FindAllAnagrams {
    public static void main(String[] args) {
        String txt = "abab";
        String pat = "ab";
        List<Integer> answer = findAnagrams(txt, pat);
        //List<Integer> answer = findAnagramsMine(txt, pat);
        for(Integer i : answer){
            System.out.println(i);
        }
    }
    /*
    Runtime: 1287 ms, faster than 8.28% of Java online submissions for Find All Anagrams in a String.
    Memory Usage: 40.3 MB, less than 27.18% of Java online submissions for Find All Anagrams in a String.
    */
    private static List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        if(txt==null || txt.length() ==0 || pat==null||pat.length()==0||txt.length()<pat.length()){
            return result;
        }

        int[] patArr = new int[256]; //[0,0,0,0,1,1,1,0,0]
        for(int i=0; i<pat.length(); i++){
            patArr[pat.charAt(i)]++;
        }

        for(int i=0; i<txt.length()-pat.length()+1; i++){
            int[] txtArr = new int[256];
            for(int j=0; j<pat.length(); j++){
                txtArr[txt.charAt(i+j)]++;
            }

            if(check(patArr, txtArr)){
                result.add(i);
            }
        }

        return result;
    }

    private static boolean check(int[] patArr, int[] txtArr) {
        for(int i=0; i<patArr.length; i++){
            if(patArr[i] != txtArr[i]){
                return false;
            }
        }
        return true;
    }

    /*
    Runtime: 1999 ms, faster than 5.01% of Java online submissions for Find All Anagrams in a String.
    Memory Usage: 40 MB, less than 71.34% of Java online submissions for Find All Anagrams in a String.
    */
    public static List<Integer> findAnagramsMine(String txt, String pat) {
        char[] pc = pat.toCharArray();
        Arrays.sort(pc);
        pat = String.valueOf(pc);

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < txt.length() - pat.length() + 1; i++) {
            char[] substr = txt.substring(i, i + pat.length()).toCharArray();
            Arrays.sort(substr);
            if (String.valueOf(substr).equals(pat)) {
                answer.add(i);
            }
        }
        return answer;
    }
}
