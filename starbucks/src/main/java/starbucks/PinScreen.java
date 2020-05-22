/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

import java.util.ArrayList;

/** Pin Screen */
public class PinScreen extends Screen
{
	//private ArrayList<IDisplayComponent> components = new ArrayList<IDisplayComponent>() ;
    private String value = "" ;

    public PinScreen()
    {
    }
    /** display the portrait content
	 * @return the content value
	 */
    @Override
    public String display() {
        // TODO Auto-generated method stub
        for (IDisplayComponent c : super.getComponents() )
        {
            System.err.println( "Screen: " + c.getClass().getName() ) ;
            value = value + c.display() + "\n" ;
        }
        return value ; 
    }
    /**
     * set value equals empty
     */
    public void clear(){
        this.value = "";
    }
    
    /**
     * set value equals Invalid Pin
     */
    void setInvalid(){
   	    this.value = "  Invalid Pin\n\n";
    }
    
    
  
}
