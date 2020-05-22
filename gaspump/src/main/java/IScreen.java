
public interface IScreen
{

    void key(String keypad) ; 		// send key entry to screen 
    String message() ;      	// get screen message
    String getAEMessage() ; 
    String getBFMessage() ;  
    String getCGMessage() ;   
    String getDHMessage() ; 
    
    void doA();
    void doB();
    void doC();
    void doD();
    void doE();
    void doF();
    void doG();
    void doH();
    void doNum();
 
}
