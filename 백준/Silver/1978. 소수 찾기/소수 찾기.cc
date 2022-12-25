#include <iostream>

using namespace std;

int main()
{
    int n, count=0;
    int arr[100];
    
    cin >> n;
    
    for(int i=0; i<n; i++){
        cin >> arr[i];
        
        int tmp=0;
        for(int j=1; j<=arr[i]; j++){
            if(arr[i] % j == 0) tmp++;
        }
        
        if(tmp==2) count++;
    }
    
    cout << count;
    
    return 0;
}