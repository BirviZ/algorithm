package algorithm.sequence;

public class Sequence_without_array {

    private static int getNumber() {
        int num = (int) (Math.random() * 37);

            if (num != 0) {
                num = (num % 2) * 2 - 1;
            }

        return num;
    }

    public static void main(String[] args) {

        //Define constants
        final int ROUNDS = Integer.MAX_VALUE;
        final int RED = 1;
        final int BLACK = -1;
        final int ZERO = 0;

        //init variables
        int zeroes = 0, blacks = 0, reds = 0, maxZeroSequence = 0, maxRedSequence = 0, maxBlackSequence = 0;

        int container = getNumber();
        
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

        //Result output
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
