
#include "PGM.hpp"


using namespace std;

PGM::PGM() {

}

void PGM::decrypt() {

	cout << "Descriptografando a "<< get_filename() << " ..." << endl;

	Decrypter * decrypter = new Decrypter();

	decrypter->decryptPGM(get_fileVector());
}

