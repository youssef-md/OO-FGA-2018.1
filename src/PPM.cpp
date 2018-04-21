
#include "PPM.hpp"


using namespace std;

PPM::PPM() {

}

void PPM::decrypt() {

	cout << "Descriptografando a "<< get_filename() << " ..." << endl;

	Decrypter * decrypter = new Decrypter(get_beginMsg(), get_sizeMsg(), get_key());

	decrypter->decryptPPM(get_fileVector());

	delete(decrypter);	
}


