#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROUNDS 10
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
		printf("%d ", container[i]);
	}

    /*    int[] container = new int[ROUNDS];
        for (int i = 0; i < ROUNDS; i++) {
            container[i] = (int) (Math.random() * 37);

            if (container[i] != 0) {
                container[i] = (container[i] % 2) * 2 - 1; //Convert value (red 1, black -1, zero 0)
            }
        } */
	return 0;
}