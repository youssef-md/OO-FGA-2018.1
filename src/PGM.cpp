
#include "PGM.hpp"


using namespace std;

PGM::PGM() {

}

void PGM::decrypt() {

	usleep(500000);

	cout << "Descriptografando "<< get_filename() << "..." << endl;

	Decrypter * decrypter = new Decrypter(get_beginMsg(), get_sizeMsg(), get_key());

	decrypter->CaesarCipher(get_fileVector());

	delete(decrypter);
}

