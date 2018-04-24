
#include "ImageEditorPGM.hpp"

using namespace std;

ImageEditorPGM::ImageEditorPGM(const vector<char>& baseImage, string magicNumber, 
				     	 int width, int height, int maxPixel) {

	this->baseImage = baseImage;
	set_magicNumber(magicNumber);
	set_width(width);
	set_height(height);
	set_maxColorValue(maxPixel);
}

ImageEditorPGM::~ImageEditorPGM() {
	
}

void ImageEditorPGM::CreateImage(string filename) {

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
/*
void ImageEditorPGM::CreateImage(struct PIXEL **imageMatrix){

   	usleep(500000);
	cout << "Criando uma imagem..." << endl;

	ofstream fileOut;
	fileOut.open("./img/copy_of_" + get_filename());

	fileOut << get_magicNumber() << endl;
	fileOut << get_width() << " " << get_height() << endl;
	fileOut << get_maxColorValue() << endl;

	for (int column = 0; column < get_height(); column++) {
        for (int row = 0; row < get_width(); row++) {
            fileOut << (imageMatrix[column][row].r);
            fileOut << (imageMatrix[column][row].g);
            fileOut << (imageMatrix[column][row].b);
        }
    }

}
*/

void ImageEditorPGM::Reflect() {
	
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

void ImageEditorPGM::Inverse() {

	for(unsigned int i = 0; i < baseImage.size(); i++) 
		baseImage[i] = 255 - baseImage[i];
	
}