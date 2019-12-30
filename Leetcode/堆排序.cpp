//
//  堆排序.cpp
//  Leetcode
//
//  Created by cysmbp15 on 2019/12/16.
//  Copyright © 2019 cysmbp15. All rights reserved.
//
//最大堆
#include <stdio.h>
#include <algorithm>
#include <iostream>

using namespace std;

void adjust(int a[],int size,int i){
    int j = 2*i+1;
    int temp = a[i];//把当前结点的数赋给temp变量，后面会发现这个变量很有用
    while (j<size){
        if (j+1<size && a[j]<a[j+1]) j++;
        if (temp > a[j]){
            break;
        }else{
            a[i] = a[j];//判断过程，把最大的孩子结点的数赋给父结点。并利用递归思想找出子节点的子节点。
            i = j;
            j =2 * j + 1;
        }
    }
    a[i] = temp;//i已经成为了孩子结点的下标，赋值temp，也就是原本父结点的值，达成交换。
}

void heapsort(int a[],int size){
    for (int i=size/2-1;i>=0;i--){
        adjust(a,size,i);
    }
    for (int i= size-1;i>=1;i--){
        swap(a[i],a[0]);
        adjust(a, i, 0);
    }
}

//int main()
//{
//    int a[10] = {5,10,7,34,23,58,2,55,35,45};
//    heapsort(a,10);
//    for (int i=0;i<10;i++)
//        cout << a[i] << " ";
//    return 0;
//}

