package leetcode.stringAndArray;

public class _10_066_PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,2,3};
        int[] result = plusOne(digits);

        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
    public static int[] plusOne(int[] digits) {
        /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
        Memory Usage: 37.3 MB, less than 89.82% of Java online submissions for Plus One.
         */
        int length = digits.length;

        digits[length-1] = digits[length-1] + 1;
        for(int i=1; i<=length; i++){
            int last = digits[length-i];
            if(last >= 10){
                if(i == length){
                    return makeNew(digits);
                }else {
                    digits[length - i] = digits[length - i] - 10;
                    digits[length - i - 1] += 1;
                }
            }
        }
        return digits;
    }

    private static int[] makeNew(int[] d) {
        int[] arr = new int[d.length+1];
        arr[0] = 1;
        arr[1] = 0;
        for(int i=2; i<d.length; i++){
            arr[i] = d[i-1];
        }
        return arr;
    }
}
