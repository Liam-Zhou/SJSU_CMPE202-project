
public class ScanDebitScreen extends Screen {

    private Frame fr;
    private String CGLine = "[C]                                  [G]\n";
    private String DHLine = "[D]                                  [H]\n";

    public ScanDebitScreen(Frame f){
        String mess = this.center("Scan Debit Card");
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
        PinScreen ps = new PinScreen(fr);
        fr.setCurrentScreen(ps);
    }
}