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
	
	vector<int> imgVector;

	if(imgIn.is_open()) {

		char character;

		while(imgIn.get(character)) {
			
			imgOut << character;
			imgVector.push_back(character);
		}

	}else {

		cout << "erro" << endl;
	}

	cout << "tamanho do vector: " << imgVector.size() << endl;

	imgIn.close();
	imgOut.close();


	return 0;
}
