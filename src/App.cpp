#include "Image.hpp"
#include "PGM.hpp"
#include "PPM.hpp"
#include <string>
#include <iostream>
#include <stdexcept>

using namespace std;

int main() {

	string filename;
	
	cout << "nome do arquivo: ";
	
	getline(cin, filename);

	if(filename.find(".pgm") != string::npos) {

		PGM * imgPGM = new PGM(filename);
		delete imgPGM;

	} else if(filename.find(".ppm") != string::npos) {

		PPM * imgPPM = new PPM(filename);
		delete imgPPM;

	} else {

		throw invalid_argument(".pgm or .ppm was not identified");
	}

	
	

	return 0;
}