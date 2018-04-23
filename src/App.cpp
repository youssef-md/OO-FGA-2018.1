#include "Image.hpp"
#include "PGM.hpp"
#include "PPM.hpp"
#include "ImageEditor.hpp"

#include <string>
#include <iostream>
#include <stdexcept>


using namespace std;


int main() {

	string filename;
	
	cout << "nome do arquivo: ";
	
	getline(cin, filename);

	if(filename.find("pgm") != string::npos) {

		PGM * imgPGM = new PGM(filename);
		ImageEditor * imageEditor = new ImageEditor(imgPGM->get_fileVector(),
													imgPGM->get_magicNumber(),
													imgPGM->get_width(),
													imgPGM->get_height(),
													imgPGM->get_maxColorValue());
		
		imgPGM->decrypt();

		imageEditor->Reflect();

		imageEditor->CreateImage(imgPGM->get_filename());

		delete imgPGM;
		delete imageEditor;

	} else if(filename.find("ppm") != string::npos) {

		PPM * imgPPM = new PPM(filename);

		imgPPM->decrypt();
		
		delete imgPPM;

	} else {

		throw invalid_argument(".pgm or .ppm was not identified");
	}

	
	

	return 0;
}