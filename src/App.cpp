#include "Image.hpp"
#include <iostream>

using namespace std;

int main() {

	string filename;
	cout << "file name: ";
	
	getline(cin, filename);

/*
	int op = 0;
	cout << "(1) PGM  (2) PPM" << endl;
	cin >> op;
	cout << op;
*/
	
	Image * img = new Image(filename);

	delete img;

	return 0;
}