
#include "Decrypter.hpp"


Decrypter::Decrypter() {

}


Decrypter::Decrypter(int beginMsg, int sizeMsg, string key) {

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

void Decrypter::CaesarCipher(const vector<char>& baseVector) {
	
	cout << "Método de criptografia: Caesar Cipher" << endl;

	int shiftAlpha = stoi(get_key());
	char cryptedLetter;

	usleep(1000000);
	system("clear");

	cout << "+----------------------------------------------+" << endl;
	cout << "|              Mensagem decifrada              |" << endl;
	cout << "+----------------------------------------------+" << endl;
	usleep(500000);

	for(int i = 0, msgPosition = get_beginMsg(); i < get_sizeMsg(); i++, msgPosition++) {

		cryptedLetter = baseVector[msgPosition];
		int decryptedLetter = 0;

		if(isalpha(cryptedLetter)) { // se for letra

			if(islower(cryptedLetter)) { // se for minúscula

				if(((int)cryptedLetter - shiftAlpha) < 97)
					decryptedLetter = ((int)cryptedLetter - shiftAlpha) + 26;
				else 
					decryptedLetter = (int)cryptedLetter - shiftAlpha;

			} else { // se for maiúscula

				if(((int)cryptedLetter - shiftAlpha) < 65)
					decryptedLetter = ((int)cryptedLetter - shiftAlpha) + 26;
				else
					decryptedLetter = (int)cryptedLetter - shiftAlpha;
			}

			cout << (char)decryptedLetter;

		} else // se não for letra
			cout << cryptedLetter;
	}

	cout << endl;

	usleep(2000000);
}

void Decrypter::KeywordCipher(const vector<char>& baseVector) {
	
	cout << "Método de criptografia: Keyword Cipher" << endl;

/*
	cout << "Begin: " << get_beginMsg() << endl;
	cout << "Size: " << get_sizeMsg() << endl;
	cout << "Shift: " << get_key() << endl;
*/
	usleep(500000);
	cout << "A mensagem descriptograda é: ";
	


	cout << endl;
	usleep(2000000);
}