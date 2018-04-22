
#include "PPM.hpp"


using namespace std;

PPM::PPM() {

}

void PPM::decrypt() {

	usleep(500000);

	cout << "Descriptografando "<< get_filename() << "..." << endl;

	Decrypter * decrypter = new Decrypter(get_beginMsg(), get_sizeMsg(), get_key());

	decrypter->KeywordCipher(get_fileVector());

	delete(decrypter);	
}


