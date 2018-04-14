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

public:


	string magicNumber;
	
	string beginMsg, sizeMsg, Ncript;

	string width, height, maxColorValue;


	Image();
	Image(string filename);
	~Image();

	

	//void createImageOutput();


};



#endif