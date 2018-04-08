#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;
int main() {


	string filename;
	getline(cin, filename);
 
	ifstream imgIn;
	imgIn.open(filename);


	ofstream imgOut;
	string filename_copy =  "copy_of_" + filename;
	imgOut.open(filename_copy);
	

	vector<char> imgVector;

	if(imgIn.is_open()) { //copiando a imagem para o vector

		char character;
		while(imgIn.get(character)) {

			imgVector.push_back(character);
		}

	}else {

		cout << "erro" << endl;
	}

	long int sizeVector = imgVector.size();
	cout << "tamanho do vector: " << sizeVector << endl;

	for(int i = 0; i < sizeVector; i++) {

		imgOut << imgVector[i];
	}

	imgIn.close();
	imgOut.close();


	return 0;
}
