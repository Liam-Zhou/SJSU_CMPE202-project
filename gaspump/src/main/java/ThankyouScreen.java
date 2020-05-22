
public class ThankyouScreen extends Screen {
    private Frame fr;
    private String CGLine = "[C]                                  [G]\n";
    private String DHLine = "[D]                                  [H]\n";

    public ThankyouScreen(Frame f){
        String mess = this.center("Thanks for Your Business.");
        String mess2 = this.center("Please Visit Us Again.");
        this.setTopMess(mess+"\n"+mess2+"\n");
        fr = f;
    }
 

    public String getCGMessage() { 
        return CGLine;
    }
 
    public String getDHMessage() { 
        return DHLine;
    }
 
}