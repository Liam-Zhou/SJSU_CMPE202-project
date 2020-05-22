/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;


/** Key Pad Subject Interface */
public interface IFocusSubject
{
    /**
     * Add Observer to Subscribers List
     * @param obj Observer Object
     */
    void attachFocusObserver( IFocusObserver obj ) ;

    /**
     * Remove Observer from Subscription
     * @param obj Observer Object
     */
    void removeFocusObserver( IFocusObserver obj ) ;

    /**
     * Trigger Events to Observers
     */
    void notifyFocusObersers() ;
}
