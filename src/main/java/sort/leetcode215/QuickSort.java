package main.java.sort.leetcode215;

/**
 * 快速排序算法的运行时间依赖于划分是否平衡，即根据枢轴元素 pivot 将序列划分为两个子序列中的元素个数，而划分是否平衡又依赖于所使用的枢轴元素。下面我们在不同的情况下来分析快速排序的渐进时间复杂度。
 *
 *
 * 快速排序的最坏情况是，每次进行划分时，在所得到的两个子序列中有一个子序列为空。在快速排序过程中，如果总是选择r[low]作为枢轴元素，则在待排序序列本身已经有序或逆向有序时，快速排序的时间复杂度为Ο(n²)。
 *
 *
 * 快速排序的最好情况是，在每次划分时，都将序列一分为二，正好在序列中间将序列分成长度相等的两个子序列。此时，算法的时间复杂度T(n) = Θ(n log n)。
 *
 *
 * 在平均情况下，快速排序的时间复杂度 T(n) = kn ㏑ n，其中 k 为某个常数，经验证明，在所有同数量级的排序方法中，快速排序的常数因子 k 是最小的。因此就平均时间而言，快速排序被认为是目前最好的一种内部排序方法。

 */
public class QuickSort {
    //从大到小排序
    public static void quick(int[] s,int low,int high){
        if (low < high){
            int part = partition(s, low, high);
            quick(s,low,part -1);
            quick(s,part+1,high);
        }
    }
    public static int partition(int s[],int low, int high){
        int pivot = s[low]; //枢
        while (low < high){
            while (low < high && s[high] <= pivot) high--;
            s[low] = s[high];
            while (low < high && s[low] >= pivot) low++;
            s[high] = s[low];
        }
        s[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
       int s[]={5,2,7,3,9,10,8,6,1,4};
       quick(s,0,s.length-1);
       for (int i=0;i<s.length;i++){
           System.out.println(s[i] + " ");
       }
    }
}
