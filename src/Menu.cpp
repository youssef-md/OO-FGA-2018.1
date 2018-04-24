
#include "Menu.hpp"

Menu::Menu() {

	Welcome();
	InputData();
	setObject();
}

Menu::~Menu() {

	if(flagPGM && imageEdited){

		delete imgEditor;
		delete imgPGM;


	} else if(flagPPM && imageEdited) {

		delete imgEditor;
		delete imgPPM;
		
	} else if(flagPGM) {

		delete imgPGM;

	} else if(flagPPM) {

		delete imgPPM;
	}
}

void Menu::Options() {

	int choice = 0;
	bool stop = false;

	while(!stop){

		usleep(500000);
		cout << "+----------------------------------------------+" << endl;
		cout << "|           O que voce deseja fazer?           |" << endl;
		cout << "|                                              |" << endl;
		cout << "|(1)Decifrar        (2)Editar           (3)Sair|" << endl;
		cout << "|----------------------------------------------+" << endl;
		cout << "+----->";
		cin >> choice;
		usleep(500000);
		system("clear");

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
				cout << "+----->bye bye õ/" << endl;
				stop = true;
				break;
				
		}
	}
}

void Menu::ImageEditingChoice() {

	int operation = 0;
	usleep(500000);
	cout << "+----------------------------------------------+" << endl;
	cout << "|        (1)Espelhar     (2)Inverter a cor     |" << endl;
	cout << "|----------------------------------------------+" << endl;
	cout << "+----->";
	cin >> operation;
	usleep(500000);
	system("clear");


	if(operation != 1 && operation != 2)
		throw invalid_argument("Operação inválida");

	if(!imageEdited) {

		CreatingImageEditorObject();
		imageEdited = true;
	}


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

void Menu::CreatingImageEditorObject() {


	if(flagPGM)
		imgEditor = new ImageEditor(imgPGM->get_fileVector(),
									imgPGM->get_magicNumber(),
									imgPGM->get_width(),
									imgPGM->get_height(),
									imgPGM->get_maxColorValue());
	
}


void Menu::Welcome() {

	usleep(500000);
	cout << "Author: Youssef Muhamad" << endl;
	usleep(500000);
	cout << "Object Oriented C++" << endl;
	usleep(500000);
	
	system("clear");

	cout << "+----------------------------------------------+" << endl;
	cout << "|     Coloque a imagen dentro da pasta /img    |" << endl;
	cout << "+----------------------------------------------+" << endl;
	usleep(1500000);
	system("clear");

}

void Menu::InputData() {

	cout << "+----------------------------------------------+" << endl;
	cout << "|     Entre o nome da imagem com o formato     |" << endl;
	cout << "|----------------------------------------------+" << endl;
	cout << "+----->";
	getline(cin, filename);

	usleep(500000);
	system("clear");
}

void Menu::setObject() {

	flagPGM = false;
	flagPPM = false;

	if(filename.find(".pgm") != string::npos){

		imgPGM = new PGM(filename);
		imgPGM->ReadFile();
		flagPGM = true;

	} else if(filename.find(".ppm") != string::npos){

		imgPPM = new PPM(filename);
		imgPPM->ReadFile();
		flagPPM = true;

	} else {

		throw invalid_argument(".pgm or .ppm was not identified!");
	}
}



