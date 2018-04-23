#include "Image.hpp"
#include "PGM.hpp"
#include "PPM.hpp"
#include "ImageEditor.hpp"
#include "Menu.hpp"
#include <string>
#include <iostream>
#include <stdexcept>
#include <unistd.h>

using namespace std;


int main() {

	string filename;
	
	cout << "nome do arquivo: ";
	
	getline(cin, filename);

	Menu * menu = new Menu(filename);

	menu->menu();

	
	

	return 0;
}