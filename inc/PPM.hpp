#ifndef PPM_HPP
#define PPM_HPP

#include "Image.hpp"

#include "ImageEditor.hpp"

#include <vector>
#include <fstream>
#include <string>
#include <unistd.h>

using namespace std;

typedef struct {

	char r;
	char g;
	char b;
}PIXEL;

class PPM : public Image {

private: 
	PIXEL **imageMatrix;
	unsigned int *messageInt;


public:
	PPM();
	~PPM();
	PPM(string filename) : Image(filename){} // super()

	void ReadFile(); //@override from class File;
	void decrypt();

	//refact
	void FindingMessage();
	void KeywordDecipher();
	void CreateImage();

};



#endif