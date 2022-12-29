#include <iostream>

using namespace std;

int main()
{
    int n, num=2;
    
    cin >> n;
    
    while(n!=1){
        if(n%num == 0){
            n /= num;
            cout << num << endl;
            num=2;
        }else num++;
    }
    
    return 0;
}