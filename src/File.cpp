
#include "File.hpp"


File::File() {
	cout << "Default Constructor File class" << endl;
}

File::~File() {

	cout << "Default Destructor File class" << endl;
	fileIn.close();
	fileOut.close();
}

void File::set_filename(string filename) {

	this->filename = filename;
	set_filepath("./img/" + filename);
}

string File::get_filename() {

	return filename;
}

void File::set_filepath(string filepath) {

	this->filepath = filepath;
}

string File::get_filepath() {

	return filepath;
}

void File::OpenFile(string filename) {

	set_filename(filename);
	fileIn.open(get_filepath()); //arquivo a ser lido
}

	
void File::ReadFile(string filename) {

	if(fileIn.is_open()) {

		char character;
		while( fileIn.get(character) )  {

			fileVector.push_back(character);	
		}

	}else {
		//tratar o erro, e impedir que o código contine!
		cout << "O arquivo não existe" << endl;
		return ;
	}
}

void File::CreateFile(string filename) {

	fileOut.open(filename);
}
