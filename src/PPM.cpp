
#include "PPM.hpp"


using namespace std;

PPM::PPM() {

	ReadFile();

}

void PPM::ReadFile() {

	cout << "Lendo com o vetor de struct" << endl;

	vector<char> fileVector = get_fileVector();

	imageVector.push_back(pixel());
}


void PPM::decrypt() {

	usleep(500000);

	cout << "Descriptografando "<< get_filename() << "..." << endl;

	Decrypter * decrypter = new Decrypter(get_beginMsg(), get_sizeMsg(), get_key());

	

	decrypter->KeywordCipher(get_fileVector());

	delete(decrypter);	
}


