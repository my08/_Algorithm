package leetcode.stringAndArray;

/*
String, StringBuilder, StringBuffer의 차이점
1. String : 객체 생성시 할당된 메모리 공간 변경이 없음.
- +연산 혹은 concat 시행 시
 : 기존 문자열에 더해지는것이 아닌 새로운 객체 생성 후 해당 객체 참조(in heap memory) -> 성능이 좋지 않음.

2. StringBuffer
 : Synchronized, 멀티스레드 환경에서 동기화 지원

3. StringBuilder
 : 동기화 보장X(단일 스레드 환경에서 사용하는것이 좋다)
 */
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
