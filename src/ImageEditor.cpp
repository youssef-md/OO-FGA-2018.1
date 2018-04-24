
#include "ImageEditor.hpp"

using namespace std;

ImageEditor::ImageEditor(const vector<char>& baseImage, string magicNumber, 
				     	 int width, int height, int maxPixel) {

	this->baseImage = baseImage;
	set_magicNumber(magicNumber);
	set_width(width);
	set_height(height);
	set_maxColorValue(maxPixel);
}

ImageEditor::~ImageEditor() {
	
}

void ImageEditor::CreateImage(string filename) {

	usleep(500000);
	cout << "Criando uma imagem..." << endl;

	ofstream fileOut;
	fileOut.open("./img/copy_of_" + filename);

	fileOut << get_magicNumber() << endl;
	fileOut << get_width() << " " << get_height() << endl;
	fileOut << get_maxColorValue() << endl;

	for(unsigned int i = 0; i < baseImage.size(); i++) 
		fileOut << baseImage[i];
	
}

void ImageEditor::Reflect() {
	
	usleep(500000);
	cout << "Espelhando..." << endl;	

	char character;
	unsigned int i,j;
	for(i = 0,  j = baseImage.size(); i < (baseImage.size()/2); i++, j-- ) {

		character = baseImage[i];
		baseImage[i] = baseImage[j];
		baseImage[j] = character;
	}
}

void ImageEditor::Inverse() {

	for(unsigned int i = 0; i < baseImage.size(); i++) 
		baseImage[i] = 255 - baseImage[i];
	
}