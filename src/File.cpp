#include "File.hpp"
#include <iostream>
#include <fstream>
#include <string> 
#include <vector>

File::File() {
	cout << "Default Constructor File class" << endl;
}


void File::set_filename(string filename) {

	this->filename = filename;
	set_filepath("./img/" + filename);
}

string File::get_filename() {

	return this->filename;
}

void File::set_filepath(string filepath) {

	this->filepath = filepath;
}

string File::get_filepath() {

	return this->filepath;
}

void File::OpenFile(string filename) {

	set_filename(filename);
	this->fileIn.open(get_filepath()); //arquivo a ser lido
}

void File::ReadFile(string filename) {

	if(this->fileIn.is_open()) {

		char character;
		while( ! (this->fileIn.eof()) )  {

			this->fileIn.get(character);
			this->fileVector.push_back(character);	
		}

	}else {
		cout << "O arquivo não existe" << endl;
	}
}