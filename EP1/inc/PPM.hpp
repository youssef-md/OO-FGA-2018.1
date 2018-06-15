#ifndef PPM_HPP
#define PPM_HPP

#include "Image.hpp"

#include <vector>
#include <fstream>
#include <string>
#include <unistd.h>

using namespace std;

struct PIXEL{

	char r;
	char g;
	char b;
};

class PPM : public Image {

private: 
	unsigned int *messageInt;


public:

	struct PIXEL **imageMatrix;

	PPM();
	~PPM();
	PPM(string filename) : Image(filename){} // super()

	void ReadFile(); 
	void CreateImage();

	void FindingMessage();
	void decrypt();

	void GreyScale();
	void InvertColor();

};



#endif