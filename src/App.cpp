#include "Image.hpp"
#include <iostream>

using namespace std;

int main() {

	string filename;
	cout << "file name: ";
	
	getline(cin, filename);

	Image * img_ppm = new Image(filename);
 	img_ppm->readHeaderConfig();

	return 0;
}