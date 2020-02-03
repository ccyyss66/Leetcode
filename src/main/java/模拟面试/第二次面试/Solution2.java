package main.java.模拟面试.第二次面试;

public class Solution2 {
    public int[] beautifulArray(int N) {
        if (N==1) return new int[] {1};
        else if (N==2){
            return new int[] {2,1};
        }else {
             int[] even = beautifulArray(N/2);
             int[] old = beautifulArray((N+1)/2);
             int[] ans = new int[N];
             for (int i=0;i<even.length;i++){
                 ans[i] = even[i]*2;
             }
             for(int i=0;i<old.length;i++){
                 ans[even.length+i] = old[i]*2-1;
             }
            return ans;
        }

    }
}
