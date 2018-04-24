
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
	usleep(800000);
	system("clear");

	usleep(500000);
	cout << "+----------------------------------------------+" << endl;
	cout << "|              Mensagem decifrada              |" << endl;
	cout << "+----------------------------------------------+" << endl;
	usleep(500000);


	int shiftAlpha = stoi(get_key());
	char cryptedLetter;

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
}

void Decrypter::KeywordCipher(unsigned int *messageInt) {

	cout << "Método de criptografia: Keyword Cipher" << endl;
	usleep(800000);

	system("clear");

	usleep(500000);
	cout << "+----------------------------------------------+" << endl;
	cout << "|              Mensagem decifrada              |" << endl;
	cout << "+----------------------------------------------+" << endl;
	usleep(500000);


	string alphabet = "abcdefghijklmnopqrstuvwxyz";
    int alphaLen = 26;

    string keyword = get_key();

    int msgLen = get_sizeMsg();

    char msg[msgLen]; 

    for (int i = 0; i < msgLen; ++i) {

        int number;
        number = messageInt[i];
        msg[i] = alphabet[number-1];     
    }

    string temp = "";
    for (int i = 0; i < (int)keyword.length(); i++) 
        temp += keyword[i];
    

    for (int i = 0; i < 26; i++) 
        temp+= (char)(i+97);
    


    for (int i = 0; i < (int)temp.length(); i++) {

        bool found = false;

        for (int j = 0; j <(int)keyword.length(); j++) {

            if(temp[i] == keyword[j]){

                found = true;
                break;
            }
        }

        if (found == false)
        	keyword += temp[i];      
    }



    string decryptedMsg = "";
    for (int i = 0; i < msgLen ; i++) {
        
        if (msg[i] == 0) 
            decryptedMsg += " ";
        else{

            int counter = 0;
            for (int j = 0; j < alphaLen; j++) {

                if (msg[i] == keyword[j]) {
                    decryptedMsg += alphabet[counter];
                    break;

                }else
                    counter ++;
            }
        }
    }

    cout << decryptedMsg << endl;;
}
