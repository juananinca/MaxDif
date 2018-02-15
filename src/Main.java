public class Main {

    public static final int N = 17;

    public static int[] A = new int[N];
    public static int millorDiferenci = Integer.MIN_VALUE;
    public static int millorMinim = -1;
    public static int millorMax = -1;

    public static void main(String[] args) {
        A[0] = 11;
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

            // Actualitzam es relatius ara que feim s'unio de conjunts
            if (A[pistaDreta.maxAbsolut] > A[pistaDreta.maxRelatiu]) {
                pistaDreta.maxRelatiu = pistaDreta.maxAbsolut;
            }
            if (A[pistaEsquerra.minAbsolut] < A[pistaEsquerra.minRelatiu]) {
                pistaEsquerra.minRelatiu = pistaEsquerra.minAbsolut;
            }

            // Miram si sa maxima diferencia es amb es min esquerra o amb es max esquerra
            if (A[pistaDreta.maxRelatiu] - A[pistaEsquerra.minRelatiu] > millorDiferenci) {
                millorDiferenci = A[pistaDreta.maxRelatiu] - A[pistaEsquerra.minRelatiu];
                millorMinim = pistaEsquerra.minRelatiu;
                millorMax = pistaDreta.maxRelatiu;
            }

            // Actulitzam Minims i Maxims Absoluts
            int minAbsolutIndex = pistaEsquerra.minAbsolut;
            int maxAbsolutIndex = pistaEsquerra.maxAbsolut;

            if (A[pistaDreta.minAbsolut] < A[pistaEsquerra.minAbsolut]) {
                minAbsolutIndex = pistaDreta.minAbsolut;
            }
            if (A[pistaDreta.maxAbsolut] > A[pistaEsquerra.maxAbsolut]) {
                maxAbsolutIndex = pistaDreta.maxAbsolut;
            }

            return new Pista(millorMinim, millorMax, minAbsolutIndex, maxAbsolutIndex);
        }
    }
}
