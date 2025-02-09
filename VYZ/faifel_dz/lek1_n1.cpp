#include "stdio.h"
#include <malloc.h>
// #include <myfunc.h> напишу напрямую тут

// инициализация массива -> маллок с сразу вставкой чисел int <myfunc.h>
int* initializ_int(int* arrM, size_t lenMainArr){
    int* RETarr = (int*)malloc(lenMainArr * sizeof(int));
    for (size_t i = 0; i < lenMainArr; i++){
        RETarr[i] = arrM[i];
    }
    return RETarr;
}

int* MaxRange(int* X, int* Y, int n){
    if(n<2)
    {
        printf("? --> n<2\n");
        return NULL;
    }

    // из формулы вычисления расстояния между точками корень((x2-x1)^2+(y2-y1)^2)
    //  следует, чем больше больше отличаются координаты точек тем больше расстояни между ними
    // находим максимально удаленную точку и максимально близкую точку к нулю, выдаем из за результат 
    int maxSum = -2147483647;
    int maxPoint;
    int minSum = 2147483647;
    int minPoint;
    for (int i = 0; i < n; i++){
        if ((X[i]*X[i])+(Y[i]*Y[i])>maxSum)
        {
            maxSum = (X[i]*X[i])+(Y[i]*Y[i]);
            maxPoint = i;
        }
        if ((X[i]*X[i])+(Y[i]*Y[i])<minSum)
        {
            minSum = (X[i]*X[i])+(Y[i]*Y[i]);
            minPoint = i;
        }
    }
    printf("max range mejdy %i and %i\n", maxPoint+1, minPoint+1);
    int arr1[2] = {maxPoint+1,minPoint+1};
    return initializ_int(arr1,2);// маллок чтобы вывести результат в значениях, свои функции из <myfunc.h> для личного удобства
}

int* MaxPloshadTreygolnik(int* X, int* Y, int n){
    if (n<3)
    {
        printf("Treygolnik nevozmojno sostavit ==> n<3\n");
        return NULL;
    }
    // формула площади треугольника по координатам вершин s=1/2*((x1-x3)*(y2-y3)-(x2-x3)*(y1-y3)) ->max
    // (a-b)(c-d)-(f-b)(j-d) ->  ac−ad−bc−fj+fd+bj 
    // x1*y2 −x1*y3 -x3*y2 −x2*y1 +x2*y3 +x3*y1 ->max ==> 

    // x1*y3 and x3*y2 and x2*y1 -> min
    // x1*y2 and x2*y3 and x3*y1 -> max
    // возможно есть способ решить таким образом, но у меня не получится, по идее надо найти 3 точки которые равноудалены и максимально удалены друг от друга
    // можно сказать площадь это характеристика n равноудаленных и максимально удаленных точек, чем больше площадь тем лучше соотношение равноудаленности и максимальной удаленности точек друг от друга
    // если рассматривать конечный квадрат то в нем самым большим является половина квадрата -> прямоугольный угол, две его точки равноудалены от третьей
    // а эти две между собой нет, но они максимально удалены от друг друга в квадрате. Такое соотношение равноудаленности и максимальной удаленности точек друг от друга
    // и будет являться максимальным идеалом при котором площадь максимальна. Возможно есть гдето формула для этого, но я её не знаю, самая похожая на нее это формула площади->бесконечности
    // у меня нет идей как схитрить по другому, поэтому просто переберу все возможные варианты и выведу максимальный
    int maxPloshad = 0;
    int point1, poitn2, point3;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            for (int k = 0; k < n; k++){
                if (i!=j && i!=k && j!=k){
                    int ploshad = (X[i]*Y[j]-X[i]*Y[k]-X[k]*Y[j]-X[j]*Y[i]+X[j]*Y[k]+X[k]*Y[i]);// /2
                    if (ploshad>maxPloshad)
                    {
                        maxPloshad = ploshad;
                        point1 = i;
                        poitn2 = j;
                        point3 = k;
                    }
                }
            }
        }
    }
    printf("Max ploshad treygolnika mezhdu %i %i %i sostavlaet %i\n", point1+1, poitn2+1, point3+1,(X[point1]*Y[poitn2]-X[point1]*Y[point3]-X[point3]*Y[poitn2]-X[poitn2]*Y[point1]+X[poitn2]*Y[point3]+X[point3]*Y[point1])/2 );
    int result[3] = {point1+1,poitn2+1,point3+1};
    return initializ_int(result,3);
}

int* MaxPloshadKvadrat(int* X, int* Y, int n){
    if (n<4)
    {
        printf("Kvadrat nevozmojno sostavit ==> n<4\n");
        return NULL;
    }
    // площадь квадрата это его сторона в квадрате, надо найти точки которые квадрат еще сделают -> 4 равноудаленные точки
    int maxPloshad = 0;
    int point1, poitn2, point3, point4;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
            for (int k = 0; k < n; k++){
                for (int l = 0; l < n; l++){
                    if (i!=j && i!=k && i!=l && j!=k && j!=l && k!=l){
                        if ((X[i]-X[j])*(X[i]-X[j])+(Y[i]-Y[j])*(Y[i]-Y[j])==(X[i]-X[k])*(X[i]-X[k])+(Y[i]-Y[k])*(Y[i]-Y[k]) && (X[i]-X[j])*(X[i]-X[j])+(Y[i]-Y[j])*(Y[i]-Y[j])==(X[i]-X[l])*(X[i]-X[l])+(Y[i]-Y[l])*(Y[i]-Y[l]))
                        {//проверили равноудаленность
                            int ploshad = (X[i]-X[j])*(X[i]-X[j]);
                            if (ploshad>maxPloshad)
                            {
                                maxPloshad = ploshad;
                                point1 = i;
                                poitn2 = j;
                                point3 = k;
                                point4 = l;
                            }
                        }
                    }
                }
            }
        }
    }
    if (maxPloshad==0)
    {
        printf("Kvadrat neydalos sostavit\n");
        return NULL;
    }
    else{
        printf("Max ploshad kvadrata mezhdu %i %i %i %i sostavlaet %i\n", point1+1, poitn2+1, point3+1, point4+1, (X[point1]-X[poitn2])*(X[point1]-X[poitn2]));
        int result[4] = {point1+1,poitn2+1,point3+1,point4+1};
        return initializ_int(result,4);
    }
}

int main(){
    // задано n точек с массивами соотвествующих координатпо x y
    size_t n = 5;
    int Y[n]= {10,2,3,4,5};
    int X[n]= {10,21,3,-43,5};
    // #1 найти максимально удаленные точки
    int* arr = MaxRange(X,Y,n);
    // for (size_t i = 0; i < 2; i++){
    //     printf("%i ", arr[i]);
    // }
    // #2 найти максимальную площадь треугольника
    int* arr2 = MaxPloshadTreygolnik(X,Y,n);
    // for (size_t i = 0; i < 3; i++){
    //     printf("%i ", arr2[i]);
    // }
    // #3 найти максимальную площадь квадрата
    int* arr3 = MaxPloshadKvadrat(X,Y,n);
    // for (size_t i = 0; i < 4; i++){
    //     printf("%i ", arr3[i]);
    // }
}
