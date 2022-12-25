#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int n, m;
    int check[1000001];
    
    cin >> m >> n;
    
    for(int i=2; i<=n; i++){
        check[i]=i;
    }
    
    for(int i = 2; i<=sqrt(n); i++){
        if(check[i] == 0) continue;
        
        for(int j=i+i; j<=n; j += i){
            check[j] = 0;
        }
    }
    
    for(int i=m; i<=n; i++){
        if(check[i] != 0) cout << check[i] << '\n';
    }
    
    return 0;
}