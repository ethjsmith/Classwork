/*

Battle sequence in class exercise
9 - 18 - 2019
Dr. G

*/

#include <iostream>
#include "Character.h"

using namespace std;

int main()
{
//struct character hero;
//hero.alive = true;
//hero.hitpoints = 99;
//hero.strength = 10;

struct character hero2(true,99,10);

struct character villan;
villan.alive = true;
}

//1. In Character.h create a character struct that can hold at least a status, hitPoints, and a strength value
//2. Create a enum status that will allow for a status of alive or dead
//3. Typdef a hero and a bad guy as character structs
//4. Create a badguy and a hero in main using the created typdef and send them to battle in the battle function in Character
//5. Battle as long as no one is dead
//6. Generate a hit value with a random number from 1 to strength
//7. Create a battleNum variable that resides in Character.cpp that keeps track with the number of battles fought, but allow Driver to access it