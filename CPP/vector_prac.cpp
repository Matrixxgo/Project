//
//  main.cpp
//  cppProj
//
//  Created by Saqlain on 1/2/18.
//  Copyright © 2018 Saqlainisgreat. All rights reserved.
//

#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <assert.h>
using namespace std;

class RunCounter {
    string something;
public:
    RunCounter(string aString){
        something = aString;
    }
    int runs(int x);
};

int RunCounter::runs(int x){
    string something3 = something;
    string something2 = something;
    int ones = 0;
    int zeros = 0;
    replace(something2.begin(), something2.end(), '0', ' ');
    istringstream iss(something2);
    vector<string> results((istream_iterator<string>(iss)),istream_iterator<string>());
    for (int i=0; i<results.size(); ++i){
        if (results[i].size() == x){
            ones = ones + 1;
        }
    }
    
    replace(something3.begin(), something3.end(), '1', ' ');
    istringstream ss(something3);
    vector<string> results_zero((istream_iterator<string>(ss)),istream_iterator<string>());
    for (int j=0; j<results_zero.size(); ++j){
        if (results_zero[j].size() == x){
            zeros = zeros + 1;
        }
    }
    
    if (ones > 0 && zeros > 0){
        return 2;
    }
    else if (ones > 0 && zeros == 0){
        return 1;
    }
    else if (zeros > 0 && ones ==  0){
        return 1;
    }
    else{
        return 0;
    }

};


int main(int argc, const char * argv[]) {
    RunCounter counter {"001100010000010011111001111110001"};
    cout << counter.runs(1)<<"\n";
    cout << counter.runs(2)<<"\n";
    cout << counter.runs(3)<<"\n";
    cout << counter.runs(4)<<"\n";
    cout << counter.runs(5)<<"\n";
    //assert(counter.runs(1) == 1);
    //assert(counter.runs(2) == 2);
    //assert(counter.runs(3) == 1);
    //assert(counter.runs(4) == 0);
    return 0;
}
