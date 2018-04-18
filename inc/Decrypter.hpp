#ifndef DECRYPTER_HPP
#define DECRYPTER_HPP

#include <string>

using namespace std;

private:
    int beginMsg;
    int sizeMsg;
    int shiftAlphabet;
    string keyword;

    

public:

    Decrypter();
    Decrypter(int beginMsg, int sizeMsg, int shiftAlphabet); // PGM
    Decrypter(int beginMsg, int sizeMsg, string keyword); // PPM

    void set_beginMsg(int beginMsg);
    int get_beginMsg();

    void set_sizeMsg(int sizeMsg);
    int get_sizeMsg();

    void set_shiftAlphabet(int shiftAlphabet);
    int get_shiftAlphabet();


#endif