
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



void Image::ReadHeader() {

	char hashtag;
	getline(fileIn, magicNumber, '\n');
	fileIn.get(hashtag);// lendo o #

	getline(fileIn, beginMsg, ' ');
	getline(fileIn, sizeMsg, ' ');
	getline(fileIn, Ncript, '\n');
	getline(fileIn, width, ' ');
	getline(fileIn, height, '\n');
	getline(fileIn, maxColorValue, '\n');

	cout << "MN:" << magicNumber << endl;
	cout << "Hash:" << hashtag << endl;
	cout << "BegMsg:" << beginMsg << endl;
	cout << "SizeMsg:" << sizeMsg << endl;
	cout << "Ncript:" << Ncript << endl;
	cout << get_filepath() << endl;
}



void Image::CreateImage() {

	CreateFile("./img/copy_of_" + get_filename());

	fileOut << magicNumber << endl;
	fileOut << width << " " << height << endl;
	fileOut << maxColorValue << endl;

	long int sizeVector = fileVector.size();

	for(int i = 0; i < sizeVector; i++) {

		fileOut << fileVector[i];
	}

}