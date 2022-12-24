#include <iostream>

using namespace std;

int main()
{
    int x, y, tmp, max_factor;

    cin >> x >> y;

    if(x>y){
        tmp=x;
        x=y;
        y=tmp;
    }

    for(int i=1; i<=x; i++){
        if((x%i==0) && (y%i==0)) max_factor = i;
    }

    cout << max_factor << '\n';
    cout << x*y/max_factor;

    return 0;
}