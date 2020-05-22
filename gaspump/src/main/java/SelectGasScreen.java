
public class SelectGasScreen extends Screen {
    private Frame fr;
    private String CGLine = "[C]                                  [G]\n";
    private String DHLine = "[D]                                  [H]\n";

    public SelectGasScreen(Frame f){
        String mess = this.center("Select Grade & Pump Gas");
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
        PrinterScreen ps = new PrinterScreen(fr);
        fr.setCurrentScreen(ps);
    }

}