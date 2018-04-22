#ifndef DECRYPTER_HPP
#define DECRYPTER_HPP

#include <vector>
#include <iostream>
#include <string>
#include <fstream>
#include <unistd.h>

using namespace std;

class Decrypter {

private:

    int beginMsg;
    int sizeMsg;
    string key;

public:

    Decrypter();
    Decrypter(int beginMsg, int sizeMsg, string key);

    void set_beginMsg(int beginMsg);
    int get_beginMsg();

    void set_sizeMsg(int sizeMsg);
    int get_sizeMsg();

    void set_key(string key);
    string get_key();

    void CaesarCipher(const vector<char>& baseVector);
    void KeywordCipher(const vector<char>& baseVector);


};


#endif