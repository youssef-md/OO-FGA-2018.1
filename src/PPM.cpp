
#include "PPM.hpp"


using namespace std;




PPM::PPM() {

}

void PPM::ReadFile() {

	cout << "Lendo o arquivo..." << endl;
	usleep(500000);
	system("clear");

	//alocando memória para a matriz de struct
	imageMatrix = (PIXEL**) malloc (sizeof(PIXEL*) * get_height());

	for(int i = 0; i < get_width(); i++) {

		imageMatrix[i] = (PIXEL*) malloc (sizeof(PIXEL) * get_width());
	}


	for(int column = 0; column < get_height(); column++) {
		for(int row = 0; row < get_width(); row++) {

			fileIn.get(imageMatrix[column][row].r);
			fileIn.get(imageMatrix[column][row].g);
			fileIn.get(imageMatrix[column][row].b);
		}
	}

	CreateImage();
}

void PPM::CreateImage(){

   	usleep(500000);
	cout << "Criando uma imagem..." << endl;

	ofstream fileOut;
	fileOut.open("./img/copy_of_" + get_filename());

	fileOut << get_magicNumber() << endl;
	fileOut << get_width() << " " << get_height() << endl;
	fileOut << get_maxColorValue() << endl;

	for (int y = 0; y < get_height(); y++) {
        for (int x = 0; x < get_width(); x++) {
            fileOut<<(imageMatrix[y][x].r);
            fileOut<<(imageMatrix[y][x].g);
            fileOut<<(imageMatrix[y][x].b);
        }
    }

}




void PPM::decrypt() {

	usleep(500000);

	cout << "Descriptografando "<< get_filename() << "..." << endl;

	Decrypter * decrypter = new Decrypter(get_beginMsg(), get_sizeMsg(), get_key());



	decrypter->KeywordCipher(get_fileVector());

	delete(decrypter);	
}


