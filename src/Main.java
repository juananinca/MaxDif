public class Main {

    public static final int N = 17;

    public static int[] A = new int[N];
    public static int millorDiferenci = Integer.MIN_VALUE;
    public static int millorMinim = -1;
    public static int millorMax = -1;

    public static void main(String[] args) {
        A[0] = 100;
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
        A[15] = 11;
        A[16] = -6;

        System.out.println(solucio(0, A.length -1).toString());
    }

    public static Pista solucio(int i0, int i1) {
        if (i1 - i0 == 1 || i0 == i1) {
            if (A[i1] - A[i0] > millorDiferenci) {
                millorDiferenci = A[i1] - A[i0];
                millorMinim = i0;
                millorMax = i1;
            }
            if (A[i0] < A[i1]) {
                return new Pista(i0, i1, i0, i1);
            } else {
                return new Pista(i0, i1, i1, i0);
            }
        } else {
            Pista pistaEsquerra = solucio(i0, ((i1-i0)/2)+i0);
            Pista pistaDreta = solucio(((i1-i0)/2)+i0+1, i1);

            if (A[pistaDreta.maxAbsolut] > A[pistaDreta.maxRelatiu]) {
                pistaDreta.maxRelatiu = pistaDreta.maxAbsolut;
            }

            if (A[pistaEsquerra.minAbsolut] < A[pistaEsquerra.minRelatiu]) {
                pistaEsquerra.minRelatiu = pistaEsquerra.minAbsolut;
            }

            if (A[pistaDreta.maxRelatiu] - A[pistaEsquerra.minRelatiu] > millorDiferenci) {
                millorDiferenci = A[pistaDreta.maxRelatiu] - A[pistaEsquerra.minRelatiu];
                millorMinim = pistaEsquerra.minRelatiu;
                millorMax = pistaDreta.maxRelatiu;
            }
            if (A[pistaDreta.maxRelatiu] - A[pistaEsquerra.maxRelatiu] > millorDiferenci) {
                millorDiferenci = A[pistaDreta.maxRelatiu] - A[pistaEsquerra.maxRelatiu];
                millorMinim = pistaEsquerra.maxRelatiu;
                millorMax = pistaDreta.maxRelatiu;
            }
            if (A[pistaDreta.minRelatiu] - A[pistaEsquerra.minRelatiu] > millorDiferenci) {
                millorDiferenci = A[pistaDreta.minRelatiu] - A[pistaEsquerra.minRelatiu];
                millorMinim = pistaEsquerra.minRelatiu;
                millorMax = pistaDreta.minRelatiu;
            }
            if (A[pistaDreta.minRelatiu] - A[pistaEsquerra.maxRelatiu] > millorDiferenci) {
                millorDiferenci = A[pistaDreta.minRelatiu] - A[pistaEsquerra.maxRelatiu];
                millorMinim = pistaEsquerra.maxRelatiu;
                millorMax = pistaDreta.minRelatiu;
            }

            int minAbsolutValue = Integer.MAX_VALUE;
            int minAbsolutIndex = -1;
            int maxAbsolutValue = Integer.MIN_VALUE;
            int maxAbsolutIndex = -1;

            // Minim absolut
            if (A[pistaEsquerra.minAbsolut] < minAbsolutValue) {
                minAbsolutValue = A[pistaEsquerra.minAbsolut];
                minAbsolutIndex = pistaEsquerra.minAbsolut;
            }
            if (A[pistaEsquerra.maxAbsolut] < minAbsolutValue) {
                minAbsolutValue = A[pistaEsquerra.maxAbsolut];
                minAbsolutIndex = pistaEsquerra.maxAbsolut;
            }
            if (A[pistaDreta.minAbsolut] < minAbsolutValue) {
                minAbsolutValue = A[pistaDreta.minAbsolut];
                minAbsolutIndex = pistaDreta.minAbsolut;
            }
            if (A[pistaDreta.maxAbsolut] < minAbsolutValue) {
                minAbsolutValue = A[pistaDreta.maxAbsolut];
                minAbsolutIndex = pistaDreta.minAbsolut;
            }

            // Maxim absolut
            if (A[pistaEsquerra.minAbsolut] > maxAbsolutValue) {
                maxAbsolutValue = A[pistaEsquerra.minAbsolut];
                maxAbsolutIndex = pistaEsquerra.minAbsolut;
            }
            if (A[pistaEsquerra.maxAbsolut] > maxAbsolutValue) {
                maxAbsolutValue = A[pistaEsquerra.maxAbsolut];
                maxAbsolutIndex = pistaEsquerra.maxAbsolut;
            }
            if (A[pistaDreta.minAbsolut] > maxAbsolutValue) {
                maxAbsolutValue = A[pistaDreta.minAbsolut];
                maxAbsolutIndex = pistaDreta.minAbsolut;
            }
            if (A[pistaDreta.maxAbsolut] > maxAbsolutValue) {
                maxAbsolutValue = A[pistaDreta.maxAbsolut];
                maxAbsolutIndex = pistaDreta.maxAbsolut;
            }
            return new Pista(millorMinim, millorMax, minAbsolutIndex, maxAbsolutIndex);
        }
    }
}
