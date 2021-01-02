package leetcode.stringAndArray;

public class _18_42_TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    /*
    Runtime: 1 ms, faster than 83.54% of Java online submissions for Trapping Rain Water.
    Memory Usage: 38.4 MB, less than 86.14% of Java online submissions for Trapping Rain Water.
     */
    public static int trap(int[] height) {

        int result= 0;
        if(height == null || height.length<=2){
            return result;
        }

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        //make left arr
        int max = height[0];
        left[0] = height[0];

        for(int i=1; i< height.length; i++){
            if(max < height[i]){
                max = height[i];
                left[i] = height[i];
            }else{
                left[i] = max;
            }
        }

        //make right arr
        max = height[height.length-1];
        right[height.length-1] = height[height.length-1];

        for(int i=height.length-2; i>=0; i--){
            if(max < height[i]){
                max = height[i];
                right[i] = height[i];
            }else{
                right[i] = max;
            }
        }

        for(int i=0; i<height.length; i++){
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;

    }
}
