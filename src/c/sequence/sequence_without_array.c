#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <limits.h>

#define ROUNDS INT_MAX
#define RED 1
#define BLACK -1
#define ZERO 0

char getNumber() {
    
    char number;
    number = rand() % 37;
        if (number != 0) {
            number = (number % 2) * 2 - 1;
        }
    return number;
}

int main() {

    time_t t;
    srand(time(&t));

	//define variables
	int zeroes, blacks, reds, maxZeroSequence, maxRedSequence, maxBlackSequence;
	zeroes = blacks = reds = maxZeroSequence = maxRedSequence = maxBlackSequence = 0;

	//Fill sequence
	
	char container = getNumber();
	
    //Init counter
    int count = 0;

    //Count sequences
    for (int i = 0; i < ROUNDS; i++) {

        //Count red sequence
        if (container == RED) {
            while (container == RED) {
                reds++;
                count++;
                if (++i == ROUNDS) break;
                container = getNumber();
            }
            if (count > maxRedSequence) {
                maxRedSequence = count;
            }

        //Count black sequence
        } else if (container == BLACK) {
            while (container == BLACK) {
                blacks++;
                count++;
                if (++i == ROUNDS) break;
                container = getNumber();
            }
            if (count > maxBlackSequence) {
                maxBlackSequence = count;
            }

        //count zero sequence
        } else if (container == ZERO) {
            while (container == ZERO) {
                zeroes++;
                count++;
                if (++i == ROUNDS) break;
                container = getNumber();
            }
            if (count > maxZeroSequence) {
                maxZeroSequence = count;
            }
        }
        count = 0;
        i--;
    }

    printf("Reds:\t\t\t%d\nMaximum sequence:\t%d\n\nBlacks:\t\t\t%d\nMaximum sequence:\t%d\n\nZeroes:\t\t\t%d\nMaximum sequence:\t%d\n", reds, maxRedSequence, blacks, maxBlackSequence, zeroes, maxZeroSequence);

	return 0;
}
