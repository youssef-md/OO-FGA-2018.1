#include <fstream>

using namespace std;

const int width = 500, height = 500;

int main(int argc, char ** argv) {

	//<header>
	ofstream img ("pic.ppm");

	img << "P3" << endl;
	img << width << " " << height << endl;
	img << "255" << endl;
	//</header>

	//<generating the matrix of the img>

	for(int row = 0; row < height; row++) {
		for(int column = 0; column < width; column++) {

			int r = row % 500;
			int g = column % 500 ;
			int b = column * row % 500;

			img << r << " " << g << " " << b << endl;

		}
	}

	//</generating the matrix of the img>
}