
public class ScanCreditScreen extends Screen {
    private Frame fr;
    private String CGLine = "[C]                                  [G]\n";
    private String DHLine = "[D]                                  [H]\n";

    public ScanCreditScreen(Frame f){
        String mess = this.center("Scan Credit Card");
        this.setTopMess(mess+"\n");
        fr = f;
    }
 
    public String getCGMessage() { 
        return CGLine;
    }
 
    public String getDHMessage() { 
        return DHLine;
    }
    public void doNum() {
        ZipScreen zs = new ZipScreen(fr);
        fr.setCurrentScreen(zs);
    }


}