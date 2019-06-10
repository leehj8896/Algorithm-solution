#include <ncurses.h>
#include <fstream>
#include <iostream>
#include "Game.h"
using namespace std;

int main()
{
    Game game;
    game.gameStart();

    initscr();
    keypad(stdscr, TRUE);
    curs_set(0);
    noecho();
    start_color();
    init_pair(1, COLOR_RED, COLOR_YELLOW);
    init_pair(2, COLOR_RED, COLOR_GREEN);
    bkgd(COLOR_PAIR(1));
    do
    {
        attron(COLOR_PAIR(2));
        border('*', '*', '*', '*', '*', '*', '*', '*');
        attroff(COLOR_PAIR(2));

        attron(COLOR_PAIR(1));

        char buff[4];
        sprintf(buff, "%d", game.getStepCount());
        mvprintw(2, 5, buff);

        sprintf(buff, "%d", game.getPushCount());
        mvprintw(3, 5, buff);

        for (int j = 0; j < game.getMaps()[game.getCurrentStage()].size(); j++)
        {
            for (int k = 0; k < game.getMaps()[game.getCurrentStage()][j].size(); k++)
            {
                char buff[1];
                sprintf(buff, "%d", game.getMaps()[game.getCurrentStage()][j][k]);
                mvprintw(j + 5, k + 5, buff);
            }
        }
        refresh();

        int input = getch();
        game.move(input);

        clear();
    } while (!game.checkAllSuccess());

    attroff(COLOR_PAIR(1));

    endwin();
}