#ifndef MENU_HPP
#define MENU_HPP

#include "PGM.hpp"
#include "PPM.hpp"
#include "ImageEditorPGM.hpp"

#include <string>
#include <stdexcept>
#include <unistd.h>
#include <stdlib.h>

class Menu {

private:
	ImageEditorPGM * editorPGM;
	PGM * imgPGM;
	PPM * imgPPM;
	string filename;


	bool flagPPM;
	bool flagPGM;
	bool imageEdited;

	void ImageEditingChoicePGM();
	void ImageEditingChoicePPM();
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