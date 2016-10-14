package algorithm.sequence;

public class Sequence {

    public static void main(String[] args) {
        final int ROUNDS = 10;
        final int RED = 1;
        final int BLACK = -1;
        final int ZERO = 0;

        int zeroes = 0, blacks = 0, reds = 0, maxZeroSequence = 0, maxRedSequence = 0, maxBlackSequence = 0;

        int[] container = new int[ROUNDS];
        for (int i = 0; i < ROUNDS; i++) {
            container[i] = (int) (Math.random() * 37);

            if (container[i] != 0) {
                container[i] = (container[i] % 2) * 2 - 1;
            }
        }

        int count = 0;
        boolean isBlack = false, isRed = false, isZero = false, isSequence = false;
        for (int i : container) {
            System.out.print(i + ", ");
            if (!isSequence) {
                switch (i) {
                    case -1:
                        isBlack = true;
                        isRed = false;
                        isZero = false;
                        isSequence = true;
                        break;
                    case 1:
                        isBlack = false;
                        isRed = true;
                        isZero = false;
                        isSequence = true;
                        break;
                    default:
                        isBlack = false;
                        isRed = false;
                        isZero = true;
                        isSequence = true;

                }
            }

            if (isBlack && (i == BLACK)) {
                count++;
                blacks++;
                if (maxBlackSequence < count) {
                    maxBlackSequence = count;
                }
                continue;
            }

            if (isRed && (i == RED)) {
                count++;
                reds++;
                if (maxRedSequence < count) {
                    maxRedSequence = count;
                }
                continue;
            }

            if (isZero && (i == ZERO)) {
                count++;
                zeroes++;
                if (maxZeroSequence < count) {
                    maxZeroSequence = count;
                }
                continue;
            }

            count = 0;
            isSequence = false;
        }

        String text = "-----------------------------------\n";

        text += "Reds:\t\t\t" + reds + "\n";
        text += "Maximum sequence: \t" + maxRedSequence + "\n\n";

        text += "Blacks:\t\t\t" + blacks + "\n";
        text += "Maximum sequence: \t" + maxBlackSequence + "\n\n";

        text += "Zeroes:\t\t\t" + zeroes + "\n";
        text += "Maximum sequence: \t" + maxZeroSequence + "\n\n";

        System.out.println(text);
    }
}
