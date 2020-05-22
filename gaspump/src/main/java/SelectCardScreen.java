
public class SelectCardScreen extends Screen  {
    private Frame fr;
    private String CGLine = "[C] Credit                           [G]\n";
    private String DHLine = "[D] Debit                            [H]\n";

    public SelectCardScreen(Frame f){
        String mess = this.center("Credit or Debit?");
        this.setTopMess(mess+"\n");
        fr = f;
    }
  
    public String getCGMessage() { 
        return CGLine;
    }
 
    public String getDHMessage() { 
        return DHLine;
    }
 
    public void doC() {
        ScanCreditScreen scs = new ScanCreditScreen(fr);
        fr.setCurrentScreen(scs);
    }
    public void doD() {
        ScanDebitScreen sds = new ScanDebitScreen(fr);
        fr.setCurrentScreen(sds);
    }


}