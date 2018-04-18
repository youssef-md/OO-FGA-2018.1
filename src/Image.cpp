
#include "File.hpp"
#include "Image.hpp"

#include <iostream>
#include <string>

using namespace std;

Image::Image() {

	cout << "Default Constructor Image class" << endl;
}


Image::Image(string filename) {

	cout << "Constructor of Image class" << endl;

	OpenFile(filename);

	ReadHeader();
	ReadFile(filename);

	CreateImage();

}

void Image::set_magicNumber(string magicNumber) {

	this->magicNumber = magicNumber;
}

string Image::get_magicNumber() {

	return magicNumber;
}

void Image::set_width(int width) {

	this->width = width;
}

int Image::get_width() {

	return width;
}

void Image::set_height(int height) {

	this->height = height;
}

int Image::get_height() {
	
	return height;
}

void Image::set_maxColorValue(int maxColorValue) {

	this->maxColorValue = maxColorValue;
}

int Image::get_maxColorValue() {

	return maxColorValue;
}


void Image::ReadHeader() {

	getline(fileIn, magicNumber, '\n');

	char hashtag;
	fileIn.get(hashtag);

	string str_width, str_height, str_maxColorValue;

	string str_beginMsg, str_sizeMsg, str_shiftAlphabet;

	//faz sentido estar nessa classe?-------------
	getline(fileIn, str_beginMsg, ' ');
	getline(fileIn, str_sizeMsg, ' ');
	getline(fileIn, str_shiftAlphabet, '\n');
	//--------------------------------------------
	getline(fileIn, str_width, ' ');
	getline(fileIn, str_height, '\n');
	getline(fileIn, str_maxColorValue, '\n');


	set_width(stoi(str_width));
	set_height(stoi(str_height));
	set_maxColorValue(stoi(str_maxColorValue));

	set_beginMsg(stoi(str_beginMsg));
	set_sizeMsg(stoi(str_sizeMsg));
	set_shiftAlphabet(stoi(str_shiftAlphabet));



	cout << "MN:" << get_magicNumber() << endl;
	cout << "Dimensão:" << get_width() << " x " << get_height() << endl; 
	cout << "maxColorValue: " << get_maxColorValue() << endl;

	cout << "Hashtag:" << hashtag << endl;
	cout << "BegMsg:" << beginMsg << endl;
	cout << "SizeMsg:" << sizeMsg << endl;
	cout << "Ncript:" << Ncript << endl;
	cout << get_filepath() << endl;

}






void Image::CreateImage() {

	CreateFile("./img/copy_of_" + get_filename());

	fileOut << get_magicNumber() << endl;
	fileOut << get_width() << " " << get_height() << endl;
	fileOut << get_maxColorValue() << endl;

	for(unsigned int i = 0; i < fileVector.size(); i++) {

		fileOut << fileVector[i];
	}

}



