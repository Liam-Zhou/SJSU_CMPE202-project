/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Payments Screen */
public class Payments extends Screen
{

    public Payments()
    {

    }
    /** display the portrait content
	 * @return the content value
	 */
    @Override
	public String display() {
		// TODO Auto-generated method stub
    	String value = "";
    	value += "\nFind Store\n";
    	value += "Enable Payments\n";
		
		return value;
	}
    /**
     * handle touch event
     * @param x Touch X
     * @param y Touch Y
     */
	@Override
    public void touch(int x, int y) {
    }
    /** get name of the screen
     * @return name 
     */
	@Override
    public String name() {
        return " Payments";
    }

}
