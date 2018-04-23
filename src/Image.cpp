
#include "Image.hpp"


using namespace std;

Image::Image() {

}


Image::Image(string filename) {

	usleep(500000);
	OpenFile(filename);

	usleep(500000);
	ReadHeader();
	
	usleep(500000);

	//if(!(get_filename().find(".ppm") != string::npos))
	ReadFile();

	//CreateImage();

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


	cout << "Lendo o cabeçalho..." << endl;
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





