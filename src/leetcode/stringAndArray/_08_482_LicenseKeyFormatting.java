package leetcode.stringAndArray;

public class _08_482_LicenseKeyFormatting {
    public static void main(String[] args) {
        String S = "2-5g-3-J";
        int K = 2;
        String answer = licenseKeyFormatting(S, K);
        System.out.println(answer);

    }
    public static String licenseKeyFormatting(String S, int K) {
        String answer = "";
        S = S.replaceAll("-", "").toUpperCase();

        //1. StringBuilder
//      Runtime: 40 ms, faster than 29.34% of Java online submissions for License Key Formatting.
//      Memory Usage: 39.7 MB, less than 36.59% of Java online submissions for License Key Formatting.
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<S.length(); i++){
            sb.append(S.charAt(i));
        }

        for(int i=K; i<S.length(); i+=K){
            sb.insert(S.length()-i, '-');
            System.out.println(sb);
        }

        answer = sb.toString();

        //2. String
//      Runtime: 115 ms, faster than 14.51% of Java online submissions for License Key Formatting.
//      Memory Usage: 40.1 MB, less than 16.00% of Java online submissions for License Key Formatting.
        /*
        int i = S.length(); //4
        while(i > 0){
            if(i-K>0){
                answer = "-"+S.substring(i-K, i) + answer;//2, 4
                i = i-K;
            }else{
                answer = S.substring(0, i) + answer;
                i = 0;
            }
        }
        */

        return answer;
    }
}
