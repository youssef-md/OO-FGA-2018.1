#ifndef IMAGE_HPP
#define IMAGE_HPP

#include "File.hpp"
#include "Decrypter.hpp"

#include <iostream>
#include <vector>
#include <fstream>
#include <string>
#include <unistd.h>

using namespace std;

class Image : public File, public Decrypter {

private:

	void ReadHeader();
	string magicNumber;
	int width, height;
	int maxColorValue;

protected:

	string beginMsg;

public:
	
	Image();
	Image(string filename);

	void super(string filename);

	void set_magicNumber(string magicNumber);
	string get_magicNumber();

	void set_width(int width);
	int get_width();

	void set_height(int height);
	int get_height();

	void set_maxColorValue(int maxColorValue);
	int get_maxColorValue();
	
	void setAttributes(string magicNumber, string width, string height, string maxColorValue,
					   string beginMsg, string sizeMsg, string key);

};



#endif