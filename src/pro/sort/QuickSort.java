package pro.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3,2,8,1,5,9,6,10,7,4};

        quickSort(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++){
            System.out.print( arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr, int x, int y) {

        if (x >= y) { // 원소가 1개인 경우
            return;
        }
        int pivot = x;
        int left = pivot + 1;
        int right = y;
        int temp;
        while (left < right) {
            while (left <= y && arr[left] < arr[pivot]) {
                left++;
            }
            while (right >= pivot && arr[pivot] < arr[right]) {
                right--;
            } if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else {
                temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            }
            quickSort(arr, x, right - 1);
            quickSort(arr, right + 1, y);
        }
    }

}
