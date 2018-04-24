
#include "PPM.hpp"


using namespace std;




PPM::PPM() {

}
PPM::~PPM() {
	free(*imageMatrix);
	free(messageInt);
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
	FindingMessage();
}

void PPM::CreateImage(){

   	usleep(500000);
	cout << "Criando uma imagem..." << endl;

	ofstream fileOut;
	fileOut.open("./img/copy_of_" + get_filename());

	fileOut << get_magicNumber() << endl;
	fileOut << get_width() << " " << get_height() << endl;
	fileOut << get_maxColorValue() << endl;

	for (int column = 0; column < get_height(); column++) {
        for (int row = 0; row < get_width(); row++) {
            fileOut << (imageMatrix[column][row].r);
            fileOut << (imageMatrix[column][row].g);
            fileOut << (imageMatrix[column][row].b);
        }
    }

}


void PPM::FindingMessage() {

	messageInt = (unsigned int *) malloc (sizeof(unsigned int) * get_sizeMsg());

	unsigned int begin = get_beginMsg()/3;
    unsigned int division = (get_beginMsg()%3);
    unsigned int beginTrack = (begin/get_width());
    unsigned int beginRow = begin - (beginTrack * get_width());

	for (unsigned int i = beginTrack; i <= beginTrack ; i++) {

		int z = 0;

		for (unsigned int j = beginRow; j < beginRow + get_sizeMsg(); j++) {
			if(division == 1){

			    messageInt[z] = ((unsigned int)imageMatrix[i][j].g % 10)+((unsigned int)imageMatrix[i][j].b % 10)+((unsigned int)imageMatrix[i][j+1].r % 10);

			}else if(division == 2){

			    messageInt[z] = ((unsigned int)imageMatrix[i][j].b%10)+((unsigned int)imageMatrix[i][j+1].r%10)+((unsigned int)imageMatrix[i][j+1].g%10);

			}else if(division == 0){

				messageInt[z] = ((unsigned int)imageMatrix[i][j].r%10)+((unsigned int)imageMatrix[i][j].g%10)+((unsigned int)imageMatrix[i][j].b%10);

			}

			z++;
		}

		z--;
	}

	ofstream TextoCrip;
    TextoCrip.open("TextoCrip.txt");
    for (int y = 0; y < get_sizeMsg(); y++) {
        
            TextoCrip << messageInt[y]<<" ";
    }

}




void PPM::decrypt() {

	usleep(500000);
	cout << "Descriptografando "<< get_filename() << "..." << endl;
	usleep(500000);

	Decrypter * decrypter = new Decrypter(get_beginMsg(), get_sizeMsg(), get_key());

	decrypter->KeywordCipher(messageInt);

	usleep(2000000);

	delete(decrypter);	
}


