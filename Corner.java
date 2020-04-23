public class Corner {
    private String fc;
    private String vc;
    private String sc;

    public Corner(String fc, String vc, String sc) {
        this.fc = fc;
        this.vc = vc;
        this.sc = sc;
    }

    public String getFc() {
        return fc;
    }

    public String getVc() {
        return vc;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String s) {
        sc = s;
    }

    public void setVc(String s) {
        vc = s;
    }

    public void setFc(String s) {
        fc = s;
    }

    public void switchScVc(){
        String orig = sc;
        sc = vc;
        vc = orig;
    }

    public void switchScFc() {
        String orig = sc;
        sc = fc;
        fc = orig;
    }

    public void switchVcFc() {
        String orig = vc;
        vc = fc;
        fc = orig;
    }

    public String toString() {
        return "" + fc + vc + sc;
    }

}