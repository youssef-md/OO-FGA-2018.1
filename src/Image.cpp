#include "Image.hpp"
#include <string>
#include <iostream> 

Image::Image() {

	cout << "Default Constructor" << endl;
}

Image::~Image() {
	cout << "Default Destructor" << endl;
}

Image::Image(string filename) {

	this->imgIn.open(filename);
	
	string filename_copy = "new-" + filename;
	this->imgOut.open(filename_copy);

	cout << "i/o fstream criados com sucesso" << endl;
}


void Image::readHeaderConfig() {

	char hash;
	getline(imgIn, this->magicNumber, '\n');
	imgIn.get(hash);// lendo o #

	getline(imgIn, this->beginMsg, ' ');
	getline(imgIn, this->sizeMsg, ' ');
	getline(imgIn, this->Ncript, '\n');

	cout << "MN:" << magicNumber << endl;
	cout << "Hash:" << hash << endl;
	cout << "BegMsg:" << beginMsg << endl;
	cout << "SizeMsg:" << sizeMsg << endl;
	cout << "Ncript:" << Ncript << endl;
}
