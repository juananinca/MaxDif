public class Pista {
    int minRelatiu;
    int minAbsolut;
    int maxRelatiu;
    int maxAbsolut;

    public Pista(int minRelatiu, int maxRelatiu, int minAbsolut,  int maxAbsolut) {
        this.minRelatiu = minRelatiu;
        this.minAbsolut = minAbsolut;
        this.maxRelatiu = maxRelatiu;
        this.maxAbsolut = maxAbsolut;
    }

    public String toString() {
        return "minRelatiu: " + this.minRelatiu + ", maxRelatiu: " + this.maxRelatiu + ".";
    }
}
