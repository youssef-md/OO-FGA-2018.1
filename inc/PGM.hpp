#ifndef PGM_HPP
#define PGM_HPP

#include "Image.hpp"
#include <vector>
#include <fstream>
#include <string>

using namespace std;

class PGM : public Image {


public:
	PGM();
	PGM(string filename) : Image(filename){}


};



#endif