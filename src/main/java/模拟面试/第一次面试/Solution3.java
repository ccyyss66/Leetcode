package main.java.模拟面试.第一次面试;

public class Solution3 {
    /**
     * 二分查找
     * @param A
     * @param K
     * @return
     */
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        double left=0,right=1.0,mid;

        int a=0,b=1;
        int number = 0;
        while (true){
            mid = (left+right)/2;
            number = 0;
            a = 0;
            for (int i=0,j=0;i<A.length;i++){
                while (j < A.length && A[i] > mid * A[j]) {
                    ++j;
                }
                number +=A.length - j;
                if (j <A.length && a * A[j] < A[i] * b) {
                    a = A[i];
                    b = A[j];
                }
            }
            if (number == K)
                return new int[] {a,b};
            else if (number<K){
                left = mid;
            }
            else {
                right = mid;
            }
        }

    }

    public static void main(String[] args) {
        int[] k ={1,2,3,5};
        Solution3 solution3 = new Solution3();
        solution3.kthSmallestPrimeFraction(k,3);
    }
}
