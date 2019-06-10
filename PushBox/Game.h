#include <vector>
#include <utility>
using namespace std;

class Game
{
private:
    int numOfStages;
    vector<vector<vector<int>>> maps;
    vector<pair<int, int>> playerPositions;
    vector<vector<pair<int, int>>> goalPositions;
    vector<bool> finished;
    int currentStage;
    int stepCount, pushCount;

public:
    int getCurrentStage() { return currentStage; }
    int getStepCount() { return stepCount; }
    int getPushCount() { return pushCount; }
    vector<bool> getFinised() { return finished; }
    vector<vector<vector<int>>> getMaps() { return maps; }

    void gameStart();
    void setMaps();
    void setPlayer();
    void move(int direction);
    void walk(int y, int x, int nextY, int nextX);
    void push(int y, int x, int nextY, int nextX, int afterY, int afterX);
    bool checkSuccess();
    bool checkGoal(int y, int x);
    void nextStage();
    bool checkAllSuccess();
};
