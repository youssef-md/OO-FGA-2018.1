#ifndef IMAGEEDITOR_HPP
#define IMAGEEDITOR_HPP

#include "Image.hpp"

#include <fstream>
#include <vector>
#include <string>
#include <unistd.h>

class ImageEditor :  public Image {

private:

	vector<char> baseImage;

public:

	ImageEditor();
	ImageEditor(const vector<char>& baseImage,
				string magicNumber, int width, 
				int height, int maxPixel);

	~ImageEditor();

	void CreateImage(string filename);
	void Reflect();
	void Inverse();

};



#endif