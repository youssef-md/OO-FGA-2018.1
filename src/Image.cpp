
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

	CreateImage();


}



void Image::ReadHeader() {

	char hashtag;
	getline(this->fileIn, this->magicNumber, '\n');
	this->fileIn.get(hashtag);// lendo o #

	getline(this->fileIn, this->beginMsg, ' ');
	getline(this->fileIn, this->sizeMsg, ' ');
	getline(this->fileIn, this->Ncript, '\n');
	getline(this->fileIn, this->width, ' ');
	getline(this->fileIn, this->height, '\n');
	getline(this->fileIn, this->maxColorValue, '\n');

	cout << "MN:" << this->magicNumber << endl;
	cout << "Hash:" << hashtag << endl;
	cout << "BegMsg:" << this->beginMsg << endl;
	cout << "SizeMsg:" << this->sizeMsg << endl;
	cout << "Ncript:" << this->Ncript << endl;
	cout << get_filepath() << endl;
}



void Image::CreateImage() {

	CreateFile("./img/copy_of_" + get_filename());

	this->fileOut << this->magicNumber << endl;
	this->fileOut << this->width << " " << this->height << endl;
	this->fileOut << this->maxColorValue << endl;

	long int vectorLen= this->fileVector.size();

	for(int i = 0; i < vectorLen; i++) {
		this->fileOut << this->fileVector[i];
	}

}