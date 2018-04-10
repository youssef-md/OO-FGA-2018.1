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
	
	//ofstream de teste da leitura da config
	ofstream configLine;
	configLine.open("configLine.txt");


	vector<char> imgVector;

	vector<int> imgConfig;

	char charOfConfig;
	if(imgIn.is_open()) { //copiando a imagem para o vector

		char character;
		int counter = 0;
		while(imgIn.get(character)) {

			if(counter >= 3 && counter <= 10) {
				if(character == '#'){

					while(imgIn.get(charOfConfig)){
						if(charOfConfig != '\n')
							configLine << charOfConfig;
						else
							break;		
					}
			
				}else {
					imgVector.push_back(character);	
				}
			}
			else {
				imgVector.push_back(character);	
			}
			counter ++;
		}

	}else {

		cout << "erro" << endl;
	}

	long int sizeVector = imgVector.size();
	cout << "tamanho do vector: " << sizeVector << endl;

	for(int i = 0; i < sizeVector; i++) { //copiando o vector na saida 

		imgOut << imgVector[i];
	}

/*
	int sizeConfigLine = imgConfig.size();
	for(int i = 0; i < sizeConfigLine; i++) { //copiando o vector na saida 

		configLine << imgConfig[i];
	}
*/
	imgIn.close();
	imgOut.close();
	configLine.close();

	return 0;
}
