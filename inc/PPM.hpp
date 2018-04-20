#ifndef PPM_HPP
#define PPM_HPP

#include "Image.hpp"
#include <vector>
#include <fstream>
#include <string>

using namespace std;

class PPM : public Image {


public:
	PPM();
	PPM(string filename);

};



#endif