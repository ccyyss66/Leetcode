//
//  leetcode-6.cpp
//  Leetcode
//
//  Created by cysmbp15 on 2019/12/11.
//  Copyright © 2019 cysmbp15. All rights reserved.
//

#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <map>
#include <string>
#include <vector>
using namespace std;
#define INT_MAX 0x7fffffff
double findk(int l1,vector<int> nums1,int l2,vector<int> nums2,int k){
    if (l1>=nums1.size()) return nums2[l2+k-1];
    if (l2>=nums2.size()) return nums1[l1+k-1];
    if (k==1) return min(nums1[l1],nums2[l2]);
    int l1mid = (l1+k/2-1)<nums1.size() ? nums1[l1+k/2-1] : INT_MAX;
    int l2mid = (l2+k/2-1)<nums2.size() ? nums2[l2+k/2-1] : INT_MAX;
    if (l1mid>l2mid){
        return findk(l1, nums1, l2+k/2, nums2, k-k/2);
    }
    else
        return findk(l1+k/2, nums1, l2, nums2, k-k/2);
}
double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    int len1 = (int)nums1.size();
    int len2 = (int)nums2.size();
    int k = (len1 + len2) / 2 +1;
    double result;
    if ((len1 + len2) % 2 !=0) {
        result = findk(0,nums1,0,nums2,k);
    }
    else{
        result = (findk(0, nums1, 0, nums2, k-1)+findk(0, nums1, 0, nums2, k))/2;
    }
    return result;
}

//int main(int argc, const char * argv[]){
//    vector<int> a,b;
//    a = {1,2};
//    b = {3,4};
//    double r = findMedianSortedArrays(a,b);
//    printf("%.1f",r);
//    return 0;
//}

