#ifndef MENU_HPP
#define MENU_HPP

#include "PGM.hpp"
#include "PPM.hpp"
#include "ImageEditor.hpp"

#include <string>
#include <stdexcept>
#include <unistd.h>

class Menu {

private:
	ImageEditor * imgEditor;
	PGM * imgPGM;
	PPM * imgPPM;
	string filename;

	

public:
	Menu(string filename);
	~Menu();

	bool flagPPM;
	bool flagPGM;
	bool imageEditing;

	void menu();
	void ImageEditingChoice();
};



#endif