/*
Header file for a generic character
*/

#include<string>
using namespace std;
enum status{alive, dead};
struct chara {
	string name;
	status state;
	int hitPoints;
	int strength;
	
	chara(string n, int hp, int s){
		name = n;
		status state = alive;
		hitPoints = hp;
		strength = s;
	}
};
void battle(chara a, chara b);

STATE statusCheck(chara a);
