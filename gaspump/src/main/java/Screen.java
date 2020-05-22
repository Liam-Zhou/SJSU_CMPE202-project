
import java.util.* ;

public class Screen implements IScreen
{
    private String topMess = "";
    
    public Screen()
    {
        // no constructor elements
    }

    public void setTopMess(String mess)
    {
        this.topMess = mess;
    }

    public String center(String st){
        int num = st.length();
			String spaces = "";
			int pad = (40 - num) / 2 ;
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < pad; i++) {
				buf.append(" ");
			}
			spaces = buf.toString();
			st = spaces+st;
        return st;
    }
   
      
    @Override
    public String message() {
        // TODO Auto-generated method stub
        return this.topMess;
    }

    @Override
    public String getCGMessage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDHMessage() {
        // TODO Auto-generated method stub
        return null;
    }
 

    @Override
    public String getAEMessage() {
        // TODO Auto-generated method stub
        return "[A]                                  [E]\n";
    }

    @Override
    public String getBFMessage() {
        // TODO Auto-generated method stub
        return "[B]                                  [F]\n";
    }

    @Override
    public void doA() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doB() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doC() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doD() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doE() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doF() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doG() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doH() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doNum() {
        // TODO Auto-generated method stub

    }

    @Override
    public void key(String keypad) {
        // TODO Auto-generated method stub

    }


}
