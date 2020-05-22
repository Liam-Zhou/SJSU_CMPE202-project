import java.util.ArrayList;

/**
 *  Main App Class for Displaying Screen.
 */
public class App {
    private Frame f; 

    public App() {
        f = new Frame(); 
    } 

    public String display() {
       return f.display();
    }

    public void key(String keypad) { 
        switch(keypad){
            case "a" :
            case "A" : f.selectA(); break;
             
            case "b" :
            case "B" : f.selectB(); break;

            case "c" :
            case "C" : f.selectC(); break;

            case "d" :
            case "D" : f.selectD(); break;

            case "e" :
            case "E" : f.selectE(); break;

            case "f" :
            case "F" : f.selectF(); break;

            case "g" :
            case "G" : f.selectG(); break;

            case "h" :
            case "H" : f.selectH(); break;
            
            default : f.selectNum();
        }
    }  
}

