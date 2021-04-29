// Ethan Smith
// C++ (cs3150)
// Clock assignment
// Demonstrate basic class constructions by making a clock class.
//
//     A clock object should hold: hour, minute, seconds, timezone as private variables. 10 points
//     Create a single constructor with an initializer list and default values as demonstrated in class. 10 points
//     Create a destructor. 5 points
//     Create appropriate getters and setters. 5 points
//     Create methods for displaying the time in standard and military time. 10 points
//     Create a method called tic that advances the seconds by one and adjusts the minutes and hours as needed. 10 points
//     Create a driver that makes a clock object and tests its functionality. 10 points (no points with out this)

#include <iostream>
#include <iomanip>

using namespace std;

class Clock{
  private:
    int second,minute,hour;
    string timezone;
  public:
    int getSecond();
    int getMinute();
    int getHour();
    string getTimezone();
    void setSecond(int);
    void setMinute(int);
    void setHour(int);
    Clock();
    Clock(int,int,int,string);
    ~Clock();
    void displayTime(int); // pass display a parameter based on type of time
    void tick();
    void minuteadd();
    void secondadd();
    void houradd();
};
int Clock::getSecond(){
  return second;
}
int Clock::getMinute(){
  return minute;
}
int Clock::getHour(){
  return hour;
}
string Clock::getTimezone(){
  return timezone;
}
void Clock::setSecond(int s){
  second = s;
}
void Clock::setMinute(int s){
  minute = s;
}
void Clock::setHour(int s){
  hour = s;
}
Clock::~Clock(){
  delete &second;
  delete &minute;
  delete &hour;
  delete &timezone;
}
Clock::Clock(){
  second = 0;
  minute = 0;
  hour = 2;
  timezone = "MST";
}
Clock::Clock(int s,int m, int h, string t){
  second =  s;
  minute = m;
  hour = h;
  timezone = t;
}
void Clock::displayTime(int s){
  int tmptime;
  cout << "current time in timezone: " << timezone << " ";
  if (s){
    if (hour > 12){
      tmptime = hour - 12;
      cout << "PM ";
    }
    else{
      cout << "AM ";
    }
  }
  else{
    // international time
    tmptime = hour;
  }
  cout << setw(2) << setfill('0')<< tmptime << ":" << setw(2) << setfill('0')<< minute <<":" << setw(2) << setfill('0')<< second << endl;
}
void Clock::tick(){
  secondadd();
}
void Clock::secondadd(){
  second += 1;
  if (second >= 60) {
    second = 0;
    minuteadd();
  }
}
void Clock::minuteadd(){
  minute += 1;
  if (minute >= 60) {
    minute = 0;
    houradd();
  }
}
void Clock::houradd(){
  hour += 1;
  if (hour >=24){
    hour = 0; // :)
  }
}
int main(int argc, char *argv[]) {
  Clock c;
  Clock c2(59,59,24,"MST");
  c.displayTime(0);
  c.displayTime(1);
  c2.displayTime(0);
  c2.displayTime(1);
  c2.tick();
  c2.displayTime(0);
  c2.displayTime(1);
}
