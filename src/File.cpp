
#include "File.hpp"


File::File() {

}

File::~File() {

	usleep(500000);
	cout << "Fechando o arquivo..." << endl;
	fileIn.close();
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

	cout << "Abrindo o arquivo..." << endl;
	set_filename(filename);
	fileIn.open(get_filepath());

	if(!fileIn.is_open())
		throw invalid_argument("O arquivo não existe");
}

	
void File::ReadFile() {

	cout << "Lendo o arquivo..." << endl;
	usleep(500000);

	char character;
	while( fileIn.get(character) )  {

		fileVector.push_back(character);	
	}

	system("clear");
}	
