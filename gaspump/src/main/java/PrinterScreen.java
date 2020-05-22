
public class PrinterScreen extends Screen {
    private Frame fr;
    private String CGLine = "[C] Yes                         Help [G]\n";
    private String DHLine = "[D] No                          Done [H]\n";

    public PrinterScreen(Frame f){
        String mess = this.center("Print Receipt?");
        this.setTopMess(mess+"\n");
        fr = f;
    }

    public void setCurrent(){
        fr.setCurrentScreen(this);
    }

    public String getCGMessage() { 
        return CGLine;
    }
 
    public String getDHMessage() { 
        return DHLine;
    } 
    

    public void doC() {
        ThankyouScreen ts = new ThankyouScreen(fr);
        fr.setCurrentScreen(ts);
    }
    public void doD() {
        ThankyouScreen ts = new ThankyouScreen(fr);
        fr.setCurrentScreen(ts);
    }

}