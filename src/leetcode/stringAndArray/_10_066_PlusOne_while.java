package leetcode.stringAndArray;

public class _10_066_PlusOne_while {
    public static void main(String[] args) {
        int[] digits = {9,9,9};
        int[] result = plusOne(digits);

        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
    public static int[] plusOne(int[] digits) {
        /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
        Memory Usage: 37.5 MB, less than 65.04% of Java online submissions for Plus One.
         */
        int index = digits.length-1;
        int carry = 1;

        while(index>=0 && carry>0){
            digits[index] = (digits[index]+1)%10;
            if(digits[index] == 0){//10인 경우(자리수+)
                carry = 1;
            }else{
                carry = 0;
            }
            --index;
        }

        if(carry == 1){
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }
}
