
#include "PPM.hpp"


using namespace std;

PPM::PPM() {

}

void PPM::decrypt() {

	cout << "Descriptografando a "<< get_filename() << " ..." << endl;

	Decrypter * decrypter = new Decrypter();

	decrypter->decryptPPM(get_fileVector());
	
}


