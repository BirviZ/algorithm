#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROUNDS 100
#define RED 1
#define BLACK -1
#define ZERO 0

int main() {

	//define variables
	int zeroes, blacks, reds, maxZeroSequence, maxRedSequence, maxBlackSequence;
	zeroes = blacks = reds = maxZeroSequence = maxRedSequence = maxBlackSequence = 0;

	//Fill sequence
	time_t t;
	srand(time(&t));
	int container[ROUNDS];
	for (int i = 0; i < ROUNDS; i++) {
		container[i] = rand() % 37;
		if (container[i] != 0) {
			container[i] = (container[i] % 2) * 2 - 1;
		}
	}

    //Init counter
    int count = 0;

    //Count sequences
    for (int i = 0; i < ROUNDS; i++) {

        //Count red sequence
        if (container[i] == RED) {
            while (container[i] == RED) {
                reds++;
                count++;
                if (++i == ROUNDS) break;
            }
            if (count > maxRedSequence) {
                maxRedSequence = count;
            }

        //Count black sequence
        } else if (container[i] == BLACK) {
            while (container[i] == BLACK) {
                blacks++;
                count++;
                if (++i == ROUNDS) break;
            }
            if (count > maxBlackSequence) {
                maxBlackSequence = count;
            }

        //count zero sequence
        } else if (container[i] == ZERO) {
            while (container[i] == ZERO) {
                zeroes++;
                count++;
                if (++i == ROUNDS) break;
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