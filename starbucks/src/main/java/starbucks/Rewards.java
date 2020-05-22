/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/** Rewards Screen */
public class Rewards extends Screen
{

    public Rewards()
    {

    }
    /** display the portrait content
	 * @return the content value
	 */
    @Override
	public String display() {
		// TODO Auto-generated method stub
    	String value = "";
    	value += "\nMake Every\n";
    	value += "Visit Count\n";
		
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

	// @Override
    // public String name() {
    //     return " Rewards";
    // }
}
