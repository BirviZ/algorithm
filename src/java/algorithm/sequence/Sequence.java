package algorithm.sequence;

public class Sequence {

    public static void main(String[] args) {
        final int ROUNDS = 100;
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

        for (int i = 0; i < container.length; i++) {
            if (container[i] == RED) {
                while (container[i] == RED) {
                    reds++;
                    count++;
                    if (++i == container.length) break;
                }
                if (count > maxRedSequence) {
                    maxRedSequence = count;
                }
            } else if (container[i] == BLACK) {
                while (container[i] == BLACK) {
                    blacks++;
                    count++;
                    if (++i == container.length) break;
                }
                if (count > maxBlackSequence) {
                    maxBlackSequence = count;
                }   
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
