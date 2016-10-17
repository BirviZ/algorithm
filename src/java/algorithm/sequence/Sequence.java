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

        for (int i = 0; i < container.length; i++) {
            if (container[i] == RED) {
                while (i < container.length || container[i] == RED) {
                    reds++;
                    count++;
                    i++;
                }
                if (count > maxRedSequence) {
                    maxRedSequence = count;
                    count = 0;
                }
            } else if (container[i] == BLACK) {
                while (i < container.length || container[i] == BLACK) {
                    blacks++;
                    count++;
                    i++;
                }
                if (count > maxBlackSequence) {
                    maxBlackSequence = count;
                    count = 0;
                }   
            } else {
                while (i < container.length || container[i] == ZERO) {
                    zeroes++;
                    count++;
                    i++;
                }
                if (count > maxZeroSequence) {
                    maxZeroSequence = count;
                    count = 0;
                }
            }
        }

        String text = "";

        for (int i = 0; i < container.length; i++) {
            text += container[i] + " ";
        }

        System.out.println(text);

        text = "";

        text = "-----------------------------------\n";

        text += "Reds:\t\t\t" + reds + "\n";
        text += "Maximum sequence: \t" + maxRedSequence + "\n\n";

        text += "Blacks:\t\t\t" + blacks + "\n";
        text += "Maximum sequence: \t" + maxBlackSequence + "\n\n";

        text += "Zeroes:\t\t\t" + zeroes + "\n";
        text += "Maximum sequence: \t" + maxZeroSequence + "\n\n";

        System.out.println(text);
    }
}
