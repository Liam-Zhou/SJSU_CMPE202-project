/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** My Card Options Screen */
public class MyCardsOptions extends Screen
{
   
	private IApp app;
    public MyCardsOptions(AppController app)
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
    	if((x==1&&y==7) ||(x==2&&y==7)||(x==3&&y==7)){
    		app.execute("MyCardsMoreOptions");
    	}
    }
    
    /** display the portrait content
	 * @return the content value
	 */
    @Override
	public String display() {
		// TODO Auto-generated method stub
		String value = "Reload\n" ;
		value += "Refresh\n";
		value += "More Options\n";
		value += "Cancel";
		return value;
	}

	/** get name of the screen 
	 * @return name 
	*/
    @Override
    public String name() {
    	return " My Cards";
    }

   
}
