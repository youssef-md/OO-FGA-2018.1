#ifndef FILE_HPP
#define FILE_HPP

#include <string>
#include <fstream>

using namespace std;

class File {

private:
	string filename;
	string filepath;

protected: 
	ifstream fileIn;
	ofstream fileOut;

public:
	File();

	void set_filename(string filename);
	string get_filename();

	void set_filepath(string filepath);
	string get_filepath();

	void OpenFile(string filename);

};




#endif