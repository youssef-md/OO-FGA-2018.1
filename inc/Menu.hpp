#ifndef MENU_HPP
#define MENU_HPP

#include "PGM.hpp"
#include "PPM.hpp"
#include "ImageEditor.hpp"

#include <string>
#include <stdexcept>
#include <unistd.h>
#include <stdlib.h>

class Menu {

private:
	ImageEditor * imgEditor;
	PGM * imgPGM;
	PPM * imgPPM;
	string filename;


	bool flagPPM;
	bool flagPGM;
	bool imageEdited;

	void ImageEditingChoice();
	void CreatingImageEditorObject();

public:
	Menu();
	~Menu();

	void Welcome();
	void InputData();
	void Options();


	void setObject();
};



#endif