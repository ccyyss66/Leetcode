package main.java.leetcode50;

public class Solution {

    public double myPow(double x, int n) {
        long N = n;
        if (N<0) {
            x= 1/x;
            N = -N;
    }
    return fastMyPow(x,N);
}
    private double fastMyPow(double x ,long N){
        if (N==0) return 1.0;
        double half = fastMyPow(x,N/2);
        if (N%2==0){
            return half*half;
        }
        else
            return half*half*x;
    }
}
