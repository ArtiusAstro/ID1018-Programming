import java.util.Arrays;
import java.util.Scanner;

public class LeastInt {
    public static void main(String[] argo){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input size of set: ");
        int[] data = new int[sc.nextInt()];
        for (int i=0;i<data.length;i++)
            data[i]=(int)(Math.random()*20);
        System.out.println(Arrays.toString(data));
        System.out.println("min: "+min(data));
    }
        // The min method returns the least element in a sequential
        // collection . If the collection is empty an
        // IllegalArgumentException is thrown .
    public static int min(int[] elements)
            throws IllegalArgumentException {
        if (elements.length == 0)
            throw new IllegalArgumentException(" empty collection ");
        // Is used in trace printing 2:
        int nofIters = 1;
        int[] sequence = elements;
        int nofPairs = sequence.length / 2;
        int nofUnpairedElements = sequence.length % 2;
        int nofPossibleElements = nofPairs + nofUnpairedElements;
        int[] partialSeq = new int[nofPossibleElements];
        int i = 0;
        int j = 0;
        while (sequence.length > 1) {
            // extract a partial sequence of possible elements
            i = 0;
            j = 0;
            //int[] partialSeq = new int[nofPossibleElements]; // GOOD_CODE but runtime bad
            while (j < nofPairs) {
                partialSeq[j++] = (sequence[i] < sequence[i + 1]) ?
                        sequence[i] : sequence[i + 1];
                i += 2;
            }
            if (nofUnpairedElements == 1)
                partialSeq[j] = sequence[sequence.length - 1];
            // now turn to the partial sequence
            // sequence = partialSeq; // BAD_CODE
            sequence = Arrays.copyOfRange(partialSeq,0,nofPossibleElements); // added to fix code
            nofPairs = nofPossibleElements / 2;
            nofUnpairedElements = nofPossibleElements % 2;
            nofPossibleElements = nofPairs + nofUnpairedElements;
            // Trace printing 1 - to follow the sequence
            System.out.print("seq: ");
            System.out.println(java.util.Arrays.toString(sequence));

            // Trace printing 2 - to terminate the loop preemptively
            // ( to be able to see what happens initially )
            if (nofIters++ == 10)
                System.exit(0);
        }
        // sequence [0] is the only remaining possible element
        // - it is the least element
        return sequence[0];
    }
}
