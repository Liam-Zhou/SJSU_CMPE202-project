/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** Settings Screen */
public class Settings extends Screen
{
	private IApp app;
    public Settings(AppController app)
    {
       this.app = app;
    }

    /**
     * handle touch event
     * @param x Touch X
     * @param y Touch Y
     */
    @Override
    public void touch(int x, int y) {
    	if ((x==1&&y==1) || (x==2&&y==1) || (x==3&&y==1))
        {
            System.err.println( "Add Card option Touched at (" + x + ", " + y + ")" ) ;
            app.execute("Add Card");
            //app.touch(1,2);
        }else
        {
        	System.err.println( "setting page Touched at (" + x + ", " + y + ")" ) ;
        }
        
    }
    
    /** display the portrait content
	 * @return the content value
	 */
    @Override
	public String display() {
		// TODO Auto-generated method stub
		String value = "    Add Card\n" ;
		value += "  Delete Card\n";
		value += "    Billing\n";
		value += "    Passcode\n\n";
		value += "  About|Terms\n";
		value += "      Help\n";
		return value;
    }
    /** get name of the screen
     * @return name 
     */
    @Override
    public String name() {
        return " Settings";
    }
   
}
