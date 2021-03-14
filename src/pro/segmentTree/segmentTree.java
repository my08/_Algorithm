package pro.segmentTree;

import java.io.*;

public class segmentTree {


    public static void main(String[] args) {
        int N = 5;
        int[] nums = {0,1,2,3,4,5}; //처음 입력 배열
        //segment tree size
        int h = (int) Math.ceil(Math.log(N)/Math.log(2)); //log2N
        int size = (int) Math.pow(2, h+1);
        long[] tree = new long[size]; //segment tree 배열

        //초기화
        init(nums, tree, 1, 1, 5);
        //갱신(3->6)
        update(tree, 1, 1, 5, 3, 6-3);
        //합(부분 합 과정)
        long answer = sum(tree, 1, 1, 5, 2, 5);
        System.out.println(answer);
    }

    private static long sum(long[] tree, int node, int start, int end, int left, int right) {

        //left와 right 값이 start와 end범위를 벗어날 경우
        if(left > end || right < start){
            return 0;
        }
        //left와 right가 start와 end를 완전히 포함하는 경우
        if(left <= start && end <= right){
            return tree[node];
        }

        int mid = (start+end)/2;
        return sum(tree, node*2, start, mid, left, right)
                + sum(tree, node*2+1, mid+1, end, left, right);

    }

    private static void update(long[] tree, int node, int start, int end, int index, int diff) {
        //변경 대상이 범위 대상 밖일 경우
        if(start > index || end < index){
            return;
        }
        //기존 숫자 대비 값 증감을 합에 더해준다.
        tree[node] += diff;

        if(start != end){
            int mid = (start+end)/2;
            update(tree, node*2, start, mid, index, diff);
            update(tree, node*2+1, mid+1, end, index, diff);
        }
    }

    private static long init(int[] nums, long[] tree, int node, int start, int end) {
        //is leaf node
        if(start == end){
            return tree[node] = nums[start];
        }

        //중간을 기준으로 좌/우 노드 이동
        int mid = (start + end) / 2;

        //구간의 합 = 좌+우
        return tree[node]
                = init(nums, tree, node*2, start, mid)
                + init(nums, tree, node*2+1, mid+1, end);
    }

}
