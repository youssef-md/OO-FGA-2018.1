#include <iostream>
#include <fstream>
#include <string>

using namespace std;

const int width = 200, height = 200;

void criarImagem();

int main() {

	//criarImagem();

	string filename;
	getline(cin, filename);

	ifstream imgIn;
	imgIn.open(filename);


	ofstream imgOut;
	string filename_copy = filename + "_copy";
	imgOut.open(filename_copy);
	
	if(imgIn.is_open()) {

		string line;
		while(getline(imgIn, line)) {

			imgOut << line << endl;
		}

	}else {

		cout << "erro" << endl;
	}

	imgIn.close();
	imgOut.close();


	return 0;
}

void criarImagem() {

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