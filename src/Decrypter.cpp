#include "Decrypter.hpp"
#include <iostream>
#include <string>
#include <fstream>


Decrypter::Decrypter() {

}

Decrypter::Decrypter(string beginMsg, string sizeMsg, string keyConfig, string filename) {

	cout << "Constructor of Decrypter class" << endl;

	set_beginMsg(stoi(beginMsg));
	set_sizeMsg(stoi(sizeMsg));

	if(filename.find(".pgm") != string::npos) {

		set_shiftAlphabet(stoi(keyConfig));
		set_keyword(" ");

	} else if(filename.find(".ppm") != string::npos) {

		set_keyword(keyConfig);
		set_shiftAlphabet(0);

	}
	
}



void Decrypter::set_beginMsg(int beginMsg) {

	this->beginMsg = beginMsg;
}

int Decrypter::get_beginMsg() {

	return beginMsg;
}

void Decrypter::set_sizeMsg(int sizeMsg) {

	this-> sizeMsg = sizeMsg;
}

int Decrypter::get_sizeMsg() {

	return sizeMsg;
}

void Decrypter::set_shiftAlphabet(int shiftAlphabet) {

	this->shiftAlphabet = shiftAlphabet;
}
    
int Decrypter::get_shiftAlphabet() {

	return shiftAlphabet;
}

void Decrypter::set_keyword(string keyword) {

	this->keyword = keyword;
} 

string Decrypter::get_keyword() {

	return keyword;
}
