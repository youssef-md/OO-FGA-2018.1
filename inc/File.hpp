#ifndef FILE_HPP
#define FILE_HPP

#include <string>
#include <fstream>
#include <vector>

using namespace std;

class File {

private:
	string filename;
	string filepath;

	void set_filename(string filename);


	void set_filepath(string filepath);

	
protected: 
	ifstream fileIn;
	ofstream fileOut;

	vector<char> fileVector;

	void ReadFile(string filename);
	void OpenFile(string filename);


public:
	File();

	string get_filename();
	string get_filepath();


};




#endif