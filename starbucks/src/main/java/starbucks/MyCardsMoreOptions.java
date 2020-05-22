/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/** My Card More Options Screen */
public class MyCardsMoreOptions extends Screen
{
    public MyCardsMoreOptions(AppController appController)
    {
    }
	
	/** display the portrait content
	 * @return the content value
	 */
    @Override
	public String display() {
		// TODO Auto-generated method stub
		String value = "Refresh\n" ;
		value += "Reload\n";
		value += "Auto Reload\n";
		value += "Transactions";
		return value;
	}
	/**
     * handle touch event
     * @param x Touch X
     * @param y Touch Y
     */
	@Override
    public void touch(int x, int y) {
    	System.err.println("more option touched at (" + x + ", " + y + ")" );
    }
	
	/** get name of the screen 
	 * @return name 
	*/
    @Override
    public String name() {
    	return " My Cards";
    }

}
