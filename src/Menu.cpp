
#include "Menu.hpp"

Menu::Menu(string filename) {

	this->filename = filename;

	flagPGM = false;
	flagPPM = false;

	if(filename.find(".pgm") != string::npos){

		imgPGM = new PGM(filename);
		flagPGM = true;

	} else if(filename.find(".ppm") != string::npos){

		imgPPM = new PPM(filename);
		flagPPM = true;

	} else {

		throw invalid_argument(".pgm or .ppm was not identified!");
	}

}

Menu::~Menu() {

	if(flagPGM && imageEditing){

		delete imgEditor;
		delete imgPGM;


	} else if(flagPPM && imageEditing) {

		delete imgEditor;
		delete imgPPM;
		
	} else if(flagPGM) {

		delete imgPGM;

	} else if(flagPPM) {

		delete imgPPM;
	}
}

void Menu::menu() {

	int choice = 0;
	bool stop = false;

	while(!stop){

		usleep(500000);
		cout << "O que voce deseja fazer ?" << endl;
		usleep(500000);
		cout << "(1)Decifrar a mensagem   (2)Editar a imagem   (3)Sair" << endl;
		cin >> choice;

		switch(choice) {

			case 1:
				if(flagPGM)
					imgPGM->decrypt();
				else if(flagPPM)
					imgPPM->decrypt();

				break;

			case 2:
				ImageEditingChoice();
				break;

			case 3:
				usleep(500000);
				cout << "bye bye õ/" << endl;
				stop = true;
				break;
				
		}
	}
}

void Menu::ImageEditingChoice() {

	int operation = 0;
	usleep(500000);
	cout << "(1)Espelhar  (2)Inverter cores " << endl;
	cin >> operation;

	if(operation != 1 && operation != 2){
		cout << "Operacao invalida!" << endl;
		return;
	}

	imageEditing = true;
	if(flagPGM)
		imgEditor = new ImageEditor(imgPGM->get_fileVector(),
									imgPGM->get_magicNumber(),
									imgPGM->get_width(),
									imgPGM->get_height(),
									imgPGM->get_maxColorValue());
	else if(flagPPM)
		imgEditor = new ImageEditor(imgPPM->get_fileVector(),
									imgPPM->get_magicNumber(),
									imgPPM->get_width(),
									imgPPM->get_height(),
									imgPPM->get_maxColorValue());

	switch(operation) {

		case 1:
			imgEditor->Reflect();
			break;
		case 2:
			imgEditor->Inverse();
			break;

	}

	imgEditor->CreateImage(filename);
}