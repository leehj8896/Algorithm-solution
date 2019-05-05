#include <iostream>
#include <fstream>
using namespace std;

int main()
{
    ifstream inFile("input.txt");

    int t;
    inFile >> t;

    while (t--)
    {
        int n, k;
        inFile >> n >> k;

        int *grid = new int[n + 2];
        int *neighbor = new int[n + 2];
        for (int i = 0; i < n + 2; i++)
        {
            if (i == 0 || i == n + 1)
            {
                grid[i] = 0;
                neighbor[i] = 0;
            }
            else
                inFile >> grid[i];
        }

        while (k--)
        {
            for (int i = 1; i <= n; i++)
                neighbor[i] = grid[i - 1] + grid[i + 1];

            for (int i = 1; i <= n; i++)

                if (neighbor[i] < 3 || neighbor[i] > 7)
                {
                    if(grid[i] > 0)
                        grid[i]--;
                }
                else if (neighbor[i] != 3 && grid[i] < 9)
                {
                    grid[i]++;
                }

            
        }
            for (int i = 1; i <= n; i++)
                cout << grid[i] << " ";
            cout << endl;

        delete[] grid, neighbor;
    }
}