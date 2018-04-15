#ifndef IMAGE_HPP
#define IMAGE_HPP

#include "File.hpp"
#include <vector>
#include <fstream>
#include <string>

using namespace std;

class Image : public File {

private:

	void ReadHeader();
	void CreateImage();
	string magicNumber;
	int width, height;
	int maxColorValue;

public:
	
	string beginMsg, sizeMsg, Ncript;

	Image();
	Image(string filename);

	void set_magicNumber(string magicNumber);
	string get_magicNumber();

	void set_width(int width);
	int get_width();

	void set_height(int height);
	int get_height();

	void set_maxColorValue(int maxColorValue);
	int get_maxColorValue();


};



#endif