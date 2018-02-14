public class Main {

    public static final int N = 16;

    public static int[] A = new int[N];
    public static int millorDiferenci = Integer.MIN_VALUE;
    public static int millorMinim = -1;
    public static int millorMax = -1;

    public static void main(String[] args) {
        A[0] = -2;
        A[1] = 0;
        A[2] = 5;
        A[3] = -4;
        A[4] = -10;
        A[5] = 2;
        A[6] = 6;
        A[7] = 1;
        A[8] = 3;
        A[9] = 4;
        A[10] = 8;
        A[11] = -3;
        A[12] = -6;
        A[13] = -8;
        A[14] = 1;
        A[15] = 0;

        System.out.println(solucio(0, A.length -1).toString());
    }

    public static Pista solucio(int i0, int i1) {
        if (i1 - i0 == 1 || i0 == i1) {
            return new Pista(i0, i1);
        } else {
            Pista pistaEsquerra = solucio(i0, ((i1-i0)/2)+i0);
            Pista pistaDreta = solucio(((i1-i0)/2)+i0+1, i1);

            if (A[pistaDreta.max] - A[pistaEsquerra.min] > millorDiferenci) {
                millorDiferenci = A[pistaDreta.max] - A[pistaEsquerra.min];
                millorMinim = pistaEsquerra.min;
                millorMax = pistaDreta.max;
            }
            if (A[pistaDreta.max] - A[pistaEsquerra.max] > millorDiferenci) {
                millorDiferenci = A[pistaDreta.max] - A[pistaEsquerra.max];
                millorMinim = pistaEsquerra.max;
                millorMax = pistaDreta.max;
            }
            if (A[pistaDreta.min] - A[pistaEsquerra.min] > millorDiferenci) {
                millorDiferenci = A[pistaDreta.min] - A[pistaEsquerra.min];
                millorMinim = pistaEsquerra.min;
                millorMax = pistaDreta.min;
            }
            if (A[pistaDreta.min] - A[pistaEsquerra.max] > millorDiferenci) {
                millorDiferenci = A[pistaDreta.min] - A[pistaEsquerra.max];
                millorMinim = pistaEsquerra.max;
                millorMax = pistaDreta.min;
            }

            int minAbsolutValue = Integer.MAX_VALUE;
            int minAbsolutIndex = -1;
            int maxAbsolutValue = Integer.MIN_VALUE;
            int maxAbsolutIndex = -1;

            // Minim absolut
            if (A[pistaEsquerra.min] < minAbsolutValue) {
                minAbsolutValue = A[pistaEsquerra.min];
                minAbsolutIndex = pistaEsquerra.min;
            }
            if (A[pistaEsquerra.max] < minAbsolutValue) {
                minAbsolutValue = A[pistaEsquerra.max];
                minAbsolutIndex = pistaEsquerra.max;
            }
            if (A[pistaDreta.min] < minAbsolutValue) {
                minAbsolutValue = A[pistaDreta.min];
                minAbsolutIndex = pistaDreta.min;
            }
            if (A[pistaDreta.max] < minAbsolutValue) {
                minAbsolutValue = A[pistaDreta.max];
                minAbsolutIndex = pistaDreta.min;
            }

            // Maxim absolut
            if (A[pistaEsquerra.min] > maxAbsolutValue) {
                maxAbsolutValue = A[pistaEsquerra.min];
                maxAbsolutIndex = pistaEsquerra.min;
            }
            if (A[pistaEsquerra.max] > maxAbsolutValue) {
                maxAbsolutValue = A[pistaEsquerra.max];
                maxAbsolutIndex = pistaEsquerra.max;
            }
            if (A[pistaDreta.min] > maxAbsolutValue) {
                maxAbsolutValue = A[pistaDreta.min];
                maxAbsolutIndex = pistaDreta.min;
            }
            if (A[pistaDreta.max] > maxAbsolutValue) {
                maxAbsolutValue = A[pistaDreta.max];
                maxAbsolutIndex = pistaDreta.max;
            }
            return new Pista(minAbsolutIndex, maxAbsolutIndex);
        }
    }
}
