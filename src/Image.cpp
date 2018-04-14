
#include "File.hpp"
#include "Image.hpp"

#include <iostream>
#include <string>

using namespace std;

Image::Image() {

	cout << "Default Constructor Image class" << endl;
}

Image::~Image() {
	cout << "Default Destructor" << endl;
} 

Image::Image(string filename) {

	cout << "Constructor of Image class" << endl;

	OpenFile(filename);

	ReadHeader();
	ReadFile(filename);

}



void Image::ReadHeader() {

	char hashtag;
	getline(this->fileIn, this->magicNumber, '\n');
	this->fileIn.get(hashtag);// lendo o #

	getline(this->fileIn, this->beginMsg, ' ');
	getline(this->fileIn, this->sizeMsg, ' ');
	getline(this->fileIn, this->Ncript, '\n');

	cout << "MN:" << magicNumber << endl;
	cout << "Hash:" << hashtag << endl;
	cout << "BegMsg:" << beginMsg << endl;
	cout << "SizeMsg:" << sizeMsg << endl;
	cout << "Ncript:" << Ncript << endl;
	cout << get_filepath() << endl;
}



