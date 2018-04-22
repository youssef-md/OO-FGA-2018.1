
#include "Image.hpp"


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


	char hashtag;
	string magicNumber, str_width, str_height, str_maxColorValue;
	string str_beginMsg, str_sizeMsg, str_key;

	getline(fileIn, magicNumber, '\n');

	fileIn.get(hashtag);
	
	getline(fileIn, str_beginMsg, ' ');
	getline(fileIn, str_sizeMsg, ' ');
	getline(fileIn, str_key, '\n');

	getline(fileIn, str_width, ' ');
	getline(fileIn, str_height, '\n');
	getline(fileIn, str_maxColorValue, '\n');

	setAttributes(magicNumber, str_width, str_height, str_maxColorValue,
					   str_beginMsg, str_sizeMsg, str_key);


	cout << get_filepath() << endl;

}

void Image::setAttributes(string magicNumber, string width, string height, string maxColorValue,
							   string beginMsg, string sizeMsg, string key) {

	set_magicNumber(magicNumber);
	set_width(stoi(width));
	set_height(stoi(height));
	set_maxColorValue(stoi(maxColorValue));

	set_beginMsg(stoi(beginMsg));
	set_sizeMsg(stoi(sizeMsg));
	set_key(key);

}




void Image::CreateImage() {


	vector<char> imageVector = get_fileVector();

	CreateFile("./img/copy_of_" + get_filename());

	fileOut << get_magicNumber() << endl;
	fileOut << get_width() << " " << get_height() << endl;
	fileOut << get_maxColorValue() << endl;

	for(unsigned int i = 0; i < imageVector.size(); i++) {

		fileOut << imageVector[i];
	}

}



