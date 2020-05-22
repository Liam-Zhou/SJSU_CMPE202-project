import java.util.ArrayList;
import java.util.Random;
 

public class Frame { 
    private IScreen currentScreen; 

    Frame(){
        currentScreen = new SelectCardScreen(this);
    };
 
    public String display(){
        String output = "";
        
        output += "========================================\n" ;
        output += "\n"                                         ;
        output += "\n"                                         ;
        output += currentScreen.message();
        output += "\n"                                         ;
        output += "\n"                                         ;
        output += currentScreen.getAEMessage();
        output += "\n"                                         ;
        output += currentScreen.getBFMessage();
        output += "\n"                                         ;
        output += currentScreen.getCGMessage();
        output += "\n"                                         ;
        output += currentScreen.getDHMessage();
        output += "\n"                                         ;
        output += "\n"                                         ;
        output += randomAd();
        output += "\n"                                         ;
        output += "\n"                                         ;
        output += "========================================\n" ;
        return output;
    }

    public void setCurrentScreen(IScreen cs){
        this.currentScreen = cs;
    }
 

    public String randomAd(){
        final long l = System.currentTimeMillis();
        int i = (int)( l % 8 );
        String ad = "";
        switch(i){
            case 0 : ad = "Join our Rewards Program.";break;
            case 1 : ad = "Hungry? Visit our Snack Bar.";break;
            case 2 : ad = "Save with a Car Wash.";break;
            case 3 : ad = "Star Wars Movie Preview.";break;
            case 4 : ad = "New on HBO Now.";break;
            case 5 : ad = "New iPhone 13 at AT&T.";break;
            case 6 : ad = "Macy's Summer Clearance.";break;
            case 7 : ad = "Get Your Smog Check Now.";break;
        }
        ad = center(ad)+"\n";
        return ad;
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
  
    private ICommand cmdA = new ICommand(){
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            currentScreen.doA();
        }
    };
    private ICommand cmdB = new ICommand(){
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            currentScreen.doB();
        }
    };
    private ICommand cmdC = new ICommand(){
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            currentScreen.doC();
        }
    };
    private ICommand cmdD = new ICommand(){
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            currentScreen.doD();
        }
    };
    private ICommand cmdE = new ICommand(){
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            currentScreen.doE();
        }
    };
    private ICommand cmdF = new ICommand(){
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            currentScreen.doF();
        }
    };
    private ICommand cmdG = new ICommand(){
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            currentScreen.doG();
        }
    };
    private ICommand cmdH = new ICommand(){
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            currentScreen.doH();
        }
    };
    private ICommand cmdNum = new ICommand(){
        @Override
        public void execute() {
            // TODO Auto-generated method stub
            currentScreen.doNum();
        }
 
    };

    public void selectA(){cmdA.execute();};
    public void selectB(){cmdB.execute();};
    public void selectC(){cmdC.execute();};
    public void selectD(){cmdD.execute();};
    public void selectE(){cmdE.execute();};
    public void selectF(){cmdF.execute();};
    public void selectG(){cmdG.execute();};
    public void selectH(){cmdH.execute();};
    public void selectNum(){cmdNum.execute();};

}