#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void criarImagem();

int main() {

	//criarImagem();

	string filename;
	getline(cin, filename);
 
	ifstream imgIn;
	imgIn.open(filename);
	

	ofstream imgOut;
	string filename_copy =  "copy_of_" + filename;
	imgOut.open(filename_copy);
	
	if(imgIn.is_open()) {

		char character;
		while(imgIn.get(character)) {
			
			imgOut << character;	
		}

	}else {

		cout << "erro" << endl;
	}

	imgIn.close();
	imgOut.close();


	return 0;
}

void criarImagem() {

	int width = 200, height = 200;

	fstream image;
	image.open("picture.ppm", ios::out);

	image << "P3" << endl;
	image << width << " " << height << endl;
	image << "255" << endl;

	
	for(int row = 0; row < height; row++) {
		for(int column = 0; column < width; column++) {

			int r = row % 200;
			int g = column % 200;
			int b = column * row % 200;

			image << r << " " << g << " " << b << endl;
		}
	}

	image.close();
}