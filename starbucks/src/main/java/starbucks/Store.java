/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Store Screen */
public class Store extends Screen
{
    public Store(AppController app)
    {
	}
	/** display the portrait content
	 * @return the content value
	 */
    @Override
	public String display() {
		// TODO Auto-generated method stub
		String value = "         X\n" ;
		value += "   X\n";
		value += "       X\n";
		value += "      X\n";
		value += "  X\n";
		value += "           X\n";
		value += "  X\n";
		return value;
	}

    /** get name of the screen 
	 * @return name 
	*/
    @Override
    public String name() {
    	return " Find Store";
	}
	/**
     * handle touch event
     * @param x Touch X
     * @param y Touch Y
     */
	@Override
    public void touch(int x, int y) {
    	
    }

}
