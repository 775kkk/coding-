#include <stdio.h>
#include <malloc.h>

// -6+2076-4*3/2+56*3

// if ((strM[i]-'0')>=0)
//         {
//             result+=(flagZnaka ? +(strM[i]-'0') : -(strM[i]-'0'));
//         }
//         else
//         {   
//             if (true)
//             {
//             flagZnaka= (strM[i]=='-' ? false : true); 
//             }
            
//         }
        

int VblCHISLI(char* strM){
    int result=1;
    bool flagZnaka=true;
    int mainChisl=0;
    int flagPriorityOP = 0;// 0 1* 2/ 3//
    for (int i = 0; strM[i]!='\0'; i++)
    {
        if (strM[i]>57)
        {
            continue;
        }
        else if ((strM[i]-'0')>=0)
        {
            mainChisl*=10;
            mainChisl+=strM[i]-'0';
        }
        else{
            if (strM[i]=='*' || strM[i]=='/')
            {
                flagPriorityOP = ((strM[i]=='*' || strM[i]=='/') ? 1 : 2 );
            }
            (strM[i]=='*' || strM[i]=='/') ? flagPriorityOP = ((strM[i]=='*') ? 1 : ((strM[i+1]=='/') ? 3 : 2) ) : NULL;
            else{
            result+=(flagZnaka ? +(mainChisl) : -(mainChisl));
            mainChisl=0;
            (strM[i]=='-' || strM[i]=='+') ? flagZnaka= (strM[i]=='-' ? false : true): NULL;
            }
        }
        
        
    }
    

}

int main(){

    char* stroka = "-6+2076-4*3/2+56*3";
    char i = '0';
    int c = (int)('6');
    int result = 1;
    char strM = '5';
    result=int( result+(strM-'0'));

    printf("%i,%i,%i,%i,%i",'0','9','a');
    // printf("\n%i",'-');
    // printf("\n%i",')'-'0');




}