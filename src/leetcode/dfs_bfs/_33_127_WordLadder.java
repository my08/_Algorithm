package leetcode.dfs_bfs;

import java.util.*;

public class _33_127_WordLadder {
    public static void main(String[] args) {
        _33_127_WordLadder a = new _33_127_WordLadder();
        String[] words = {"hot", "dot", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(words.clone());
        String beginWord = "hit", endWord = "cog";
        //int answer = a.ladderLength(beginWord, endWord, wordList);
        int answer = a.ladderLengthLecture(beginWord, endWord, wordList);
        System.out.println(answer);
    }

    private int ladderLengthLecture(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || !wordList.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        queue.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String str = queue.poll();
                if(str.equals(endWord)) return level;
                for(String neighbor : neighbors(str, wordList)){
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    private List<String> neighbors(String str, List<String> wordList) {
        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        for(int i=0; i< str.length(); i++){
            char[] chars = str.toCharArray();
            for(char ch='a'; ch<='z'; ch++){
                chars[i]=ch; //[a]it~[z]it
                String word = new String(chars);
                if(dict.remove(word)){
                    res.add(word);
                }
            }
        }
        return res;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        if(wordList.size() == 2 && wordList.contains(beginWord) && wordList.contains(endWord) && !checkSimilarity(beginWord, endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int cnt = 1;
        while(!queue.isEmpty()){
            String word = queue.poll();
            System.out.println("current word : " + word);
//            //마지막 글자가 들어온 경우 종료
//            if(word.equals(endWord)){
//                return cnt++;
//            }
            for(String s : wordList) {
                System.out.println("current target word : " + s);
                if(checkSimilarity(s, word)){
                    if(!checkSimilarity(word, endWord)){
                        queue.offer(s);
                        System.out.println("current target word input : " + s);
                        wordList.remove(s);
                        break;
                    }else{
                        queue.offer(endWord);
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }

    private boolean checkSimilarity(String t1, String t2) {
        int diff = 0;
        char[] tc1 = t1.toCharArray();
        char[] tc2 = t2.toCharArray();
        int idx = 0;
        for (char c : tc1) {
            if (diff < 2) {
                if (c != tc2[idx]) {
                    diff++;
                }
                idx++;
            } else {
                return false;
            }
        }
        if(diff < 2) return true;
        else return false;
    }
}
