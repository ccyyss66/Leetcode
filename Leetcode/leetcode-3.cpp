//
//  leetcode-3.cpp
//  Leetcode
//
//  Created by cysmbp15 on 2019/12/11.
//  Copyright © 2019 cysmbp15. All rights reserved.
//

#include<stdio.h>
#include "leetcode-3.hpp"
#include <iostream>
#include <algorithm>
#include <map>
#include <string>
using namespace std;

int lengthOfLongestSubstring(string s){
    map<char,int> hash;
    int maxlength=0;
    for (int i=0,j=0;j<s.length();j++){
        i = max(i,hash[s[j]]);
        hash[s[j]] = j+1;
        maxlength = max(maxlength,j-i+1);
    }
    
    return maxlength;
}

//int main(int argc, const char * argv[]) {
//    // insert code here...
//    string s;
//    cin >> s;
//    cout << lengthOfLongestSubstring(s) << endl;
//    return 0;
//}
