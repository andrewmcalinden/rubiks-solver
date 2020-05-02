public class Edge {
    private String fc;
    private String sc;

    public Edge(String fc, String sc) {
        this.fc = fc;
        this.sc = sc;
    }

    public String getFc() {
        return fc;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String s) {
        sc = s;
    }

    public void setFc(String s) {
        fc = s;
    }

    public void switchScFc() {
        String orig = sc;
        sc = fc;
        fc = orig;
    }

    public boolean has(String s) {
        return (sc.equals(s) || fc.equals(s));
    }

    public boolean equals(Corner corner) {
        return (fc.equals(corner.getFc()) && sc.equals(corner.getSc()));
    }

    public String toString() {
        return "" + fc + sc;
    }

}