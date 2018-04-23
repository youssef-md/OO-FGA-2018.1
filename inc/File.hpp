#ifndef FILE_HPP
#define FILE_HPP

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <stdexcept>
#include <unistd.h>

using namespace std;

class File {

private:

	string filename;
	string filepath;

	vector<char> fileVector;

	void set_filename(string filename);
	void set_filepath(string filepath);
	
	
protected: 

//é necessário herdar de File para ter os atributos de um arquivo

	File();
	~File();

	ifstream fileIn;
	
	void OpenFile(string filename);
	void ReadFile();
	

public:

	string get_filename();
	string get_filepath();
	vector<char> const &get_fileVector() const { return fileVector; }
};




#endif