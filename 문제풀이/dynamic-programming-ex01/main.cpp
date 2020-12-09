#include <cstdio>

//i,j까지 비용의 합
int minCost(int map[4][4], int cost[4][4], int direction[4][4], int i, int j){

    if(i < 0 || j < 0){
        return 0;
    }
    else if(i == 0 && j == 0){
        cost[i][j] = map[i][j];
        return cost[i][j];
    }else{
        
        if(i==0){
            cost[i][j-1] = minCost(map,cost,direction,i,j-1);
            cost[i][j]= cost[i][j-1] + map[i][j];
            direction[i][j]=2;
        }else if(j==0){
            cost[i-1][j] =minCost(map,cost,direction,i-1,j);
            cost[i][j]=cost[i-1][j]+map[i][j];
            direction[i][j]=1;
        }else{
            cost[i][j - 1] = minCost(map, cost, direction,i, j - 1);
            cost[i - 1][j] = minCost(map, cost,direction, i - 1, j);
            if(cost[i][j - 1] > cost[i - 1][j]){
                cost[i][j]=cost[i - 1][j] + map[i][j];
                direction[i][j]=1;
            }
            else{
                cost[i][j]=cost[i][j - 1] + map[i][j];
                direction[i][j]=2;
            }
        }
        return cost[i][j];
    }
}

void printArr(int arr[4][4]){
    for(int i = 0; i < 4; i++){
        for(int j = 0; j < 4; j++){
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }
}

int main(){

    int map[4][4] = {
        {6,7,12,5},
        {5,3,11,18},
        {7,17,3,3},
        {8,10,14,9}
    };

    int cost[4][4] = {
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
    };

    int direction[4][4] = {
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
    };

    printf("%d\n", minCost(map,cost,direction, 3,3));
    printArr(cost);
    printArr(direction);
}