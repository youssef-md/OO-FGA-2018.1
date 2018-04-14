#include "Image.hpp"
#include <iostream>

using namespace std;

int main() {

	string filename;
	cout << "file name: ";
	
	getline(cin, filename);

	Image * img = new Image(filename);

	return 0;
}