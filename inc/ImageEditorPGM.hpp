#ifndef IMAGEEDITORPGM_HPP
#define IMAGEEDITORPGM_HPP

#include "Image.hpp"

#include <fstream>
#include <vector>
#include <string>
#include <unistd.h>
#include "PPM.hpp" // incluir a struct RGB


class ImageEditorPGM :  public Image {

private:

	vector<char> baseImage;

public:

	ImageEditorPGM(const vector<char>& baseImage,
				   string magicNumber, int width, 
				   int height, int maxPixel);

	~ImageEditorPGM();

	void CreateImage(string filename);
	//void CreateImage(struct PIXEL **imageMatrix);

	void Reflect();
	void Inverse();

};



#endif