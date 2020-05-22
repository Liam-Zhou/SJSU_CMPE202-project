
public class ZipScreen extends Screen {

    private Frame fr;
    private String CGLine = "[C]                                  [G]\n";
    private String DHLine = "[D]                                  [H]\n";

    public ZipScreen(Frame f){
        String mess = this.center("Enter your Zip Code");
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
        SelectGasScreen sgs = new SelectGasScreen(fr);
        fr.setCurrentScreen(sgs);
    }

}