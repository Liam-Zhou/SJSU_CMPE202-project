
package starbucks ;

/** CenterDecorator extends  ScreenDecorator */
public class CenterDecorator extends  ScreenDecorator
{
    private String addedString;
    public CenterDecorator(Screen screen) {
        super(screen);
        // TODO Auto-generated constructor stub
    }
    /**
     * Return Display Component Contents
     * @return Display Component Contents
     */
    public String display() {
        // TODO Auto-generated method stub
        addedString = super.display();
        //String out ="";
        return addedString;
    }
}