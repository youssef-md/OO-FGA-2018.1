
#include "PGM.hpp"


using namespace std;

PGM::PGM() {

}

void PGM::decrypt() {

	cout << "Descriptografando a "<< get_filename() << " ..." << endl;

	Decrypter * decrypter = new Decrypter(get_beginMsg(), get_sizeMsg(), get_key());

	decrypter->decryptPGM(get_fileVector());

	delete(decrypter);
}

