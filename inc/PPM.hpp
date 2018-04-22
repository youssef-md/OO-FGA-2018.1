#ifndef PPM_HPP
#define PPM_HPP

#include "Image.hpp"
#include "Decrypter.hpp"

#include <vector>
#include <fstream>
#include <string>
#include <unistd.h>

using namespace std;

class PPM : public Image {


public:
	PPM();
	PPM(string filename) : Image(filename){} // super()

	void decrypt();

};



#endif