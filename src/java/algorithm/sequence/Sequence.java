package algorithm.sequence;

public class Sequence {

    public static void main(String[] args) {

        //Define constants
        final int ROUNDS = 100;
        final int RED = 1;
        final int BLACK = -1;
        final int ZERO = 0;

        //init variables
        int zeroes = 0, blacks = 0, reds = 0, maxZeroSequence = 0, maxRedSequence = 0, maxBlackSequence = 0;

        //Fill sequence
        int[] container = new int[ROUNDS];
        for (int i = 0; i < ROUNDS; i++) {
            container[i] = (int) (Math.random() * 37);

            if (container[i] != 0) {
                container[i] = (container[i] % 2) * 2 - 1; //Convert value (red 1, black -1, zero 0)
            }
        }

        //Init counter
        int count = 0;

        //Count sequences
        for (int i = 0; i < container.length; i++) {

            //Count red sequence
            if (container[i] == RED) {
                while (container[i] == RED) {
                    reds++;
                    count++;
                    if (++i == container.length) break;
                }
                if (count > maxRedSequence) {
                    maxRedSequence = count;
                }

            //Count black sequence
            } else if (container[i] == BLACK) {
                while (container[i] == BLACK) {
                    blacks++;
                    count++;
                    if (++i == container.length) break;
                }
                if (count > maxBlackSequence) {
                    maxBlackSequence = count;
                }

            //count zero sequence
            } else if (container[i] == ZERO) {
                while (container[i] == ZERO) {
                    zeroes++;
                    count++;
                    if (++i == container.length) break;
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
