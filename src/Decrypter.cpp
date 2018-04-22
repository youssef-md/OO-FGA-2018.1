
#include "Decrypter.hpp"


Decrypter::Decrypter() {

}


Decrypter::Decrypter(int beginMsg, int sizeMsg, string key) {

	cout << "Constructor of Decrypter class" << endl;

	set_beginMsg(beginMsg);
	set_sizeMsg(sizeMsg);
	set_key(key);	
}


void Decrypter::set_beginMsg(int beginMsg) {

	this->beginMsg = beginMsg;
}

int Decrypter::get_beginMsg() {

	return beginMsg;
}

void Decrypter::set_sizeMsg(int sizeMsg) {

	this->sizeMsg = sizeMsg;
}

int Decrypter::get_sizeMsg() {

	return sizeMsg;
}


void Decrypter::set_key(string key) {

	this->key = key;
} 

string Decrypter::get_key() {

	return key;
}

void Decrypter::decryptPGM(const vector<char>& baseVector) {
	
	cout << "Caesar Cipher" << endl;
/*
	cout << "Begin: " << get_beginMsg() << endl;
	cout << "Size: " << get_sizeMsg() << endl;
	cout << "Shift: " << stoi(get_key()) << endl;
*/

	int shiftAlpha = stoi(get_key());
	char cryptedLetter;

	cout << "A mensagem descriptograda é: ";

	for(int i = 0, msgPosition = get_beginMsg(); i < get_sizeMsg(); i++, msgPosition++) {

		cryptedLetter = baseVector[msgPosition];
		int decryptedLetter = 0;

		if(isalpha(cryptedLetter)) {

			if(islower(cryptedLetter)) {

				if(((int)cryptedLetter - shiftAlpha) < 97)
					decryptedLetter = ((int)cryptedLetter - shiftAlpha) + 26;
				else 
					decryptedLetter = (int)cryptedLetter - shiftAlpha;

			} else {

				if(((int)cryptedLetter - shiftAlpha) < 65)
					decryptedLetter = ((int)cryptedLetter - shiftAlpha) + 26;
				else
					decryptedLetter = (int)cryptedLetter - shiftAlpha;
			}

			cout << (char)decryptedLetter;

		} else 
			cout << cryptedLetter;
	}

	cout << endl;
}

void Decrypter::decryptPPM(const vector<char>& baseVector) {
	
	cout << "Keyword Cipher" << endl;

	cout << "Begin: " << get_beginMsg() << endl;
	cout << "Size: " << get_sizeMsg() << endl;
	cout << "Shift: " << get_key() << endl;


}