/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/**
 * Key Pad Observer Interface
 */
public interface IFocusObserver
{
    /**
     * focus Event to Notify Observers 
     * @param onfocus onfocus or not
     * @param countDigits  the digit count right now
     */
    void focusEventUpdate(boolean onfocus,int countDigits) ;
}
