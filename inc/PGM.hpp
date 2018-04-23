#ifndef PGM_HPP
#define PGM_HPP

#include "Image.hpp"

#include "ImageEditor.hpp"

#include <vector>
#include <fstream>
#include <string>
#include <unistd.h>

using namespace std;

class PGM : public Image {


public:

	PGM();
	PGM(string filename) : Image(filename){} // super()

	void decrypt();


};



#endif