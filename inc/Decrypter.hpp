#ifndef DECRYPTER_HPP
#define DECRYPTER_HPP

#include <string>
#include <fstream>

using namespace std;

class Decrypter {

private:

    int beginMsg;
    int sizeMsg;
    int shiftAlphabet;
    string keyword;

    

public:

    Decrypter();
    Decrypter(string beginMsg, string sizeMsg, string , string filename); // PGM

    void set_beginMsg(int beginMsg);
    int get_beginMsg();

    void set_sizeMsg(int sizeMsg);
    int get_sizeMsg();

    void set_shiftAlphabet(int shiftAlphabet);
    int get_shiftAlphabet();

    void set_keyword(string keyword);
    string get_keyword();

    void decryptPGM();
    void decryptPPM();


};


#endif