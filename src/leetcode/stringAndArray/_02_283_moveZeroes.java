package leetcode.stringAndArray;

 class _02_283_moveZeroes {
    public static void moveZeroes(int[] nums) {
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
        //Memory Usage: 39.3 MB, less than 58.34% of Java online submissions for Move Zeroes.
        int count=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                nums[count++] = nums[i];
            }
        }
        while(count < nums.length){
            nums[count++] = 0;
        }
//        for(int i = count; i<nums.length; i++) {
//            nums[i]=0;
//        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }

    }
}
