#include <iostream>
#include <fstream>
#include <vector>
#include <omp.h>
using namespace std;

int main()
{
	//Create a dynamic array to hold the values
	vector<int> numbers;
	int i;
	//Create an input file stream
	ifstream in("D:\\testout.txt", ios::in);

	/*
	As long as we haven't reached the end of the file, keep reading entries.
	*/

	int number;  //Variable to hold each number as it is read

	//Read number using the extraction (>>) operator
	while (in >> number) {
		//Add the number to the end of the array
		numbers.push_back(number);
	}

	//Close the file stream
	in.close();

	/*
	Now, the vector<int> object "numbers" contains both the array of numbers,
	and its length (the number count from the file).
	*/
#pragma omp parallel
	{
#pragma omp for
		for (int i = 0; i<numbers.size(); i++)
			numbers[i] = numbers[i] << 2;
	}
	ofstream mf;
	mf.open("D:\\example.txt", ios::out);
	for (i = 0; i < numbers.size(); i++)
		mf << numbers[i] << "\n";
	mf.close();
	cin.get(); //Keep program open until "enter" is pressed
	return 0;
}