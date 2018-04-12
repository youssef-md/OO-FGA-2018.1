#ifndef IMAGE_HPP
#define IMAGE_HPP

#include <vector>
#include <fstream>
#include <string>

using namespace std;

class Image {

private:

	ifstream imgIn;
	ofstream imgOut;

	string magicNumber;
	
	string beginMsg, sizeMsg, Ncript;

	string width, height, maxColorValue;


	vector<char> imgVector;


public:
	
	Image();
	Image(string filename);
	~Image();


	void readHeaderConfig();


};



#endif