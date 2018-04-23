#ifndef PPM_HPP
#define PPM_HPP

#include "Image.hpp"

#include "ImageEditor.hpp"

#include <vector>
#include <fstream>
#include <string>
#include <unistd.h>

using namespace std;

struct pixel { 

	int r;
	int g;
	int b;
};

class PPM : public Image {

private: 
	vector<pixel> imageVector;


public:
	PPM();
	PPM(string filename) : Image(filename){} // super()

	void ReadFile(); 
	void decrypt();

};



#endif