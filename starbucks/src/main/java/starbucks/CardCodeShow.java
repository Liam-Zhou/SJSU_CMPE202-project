package starbucks;

import java.util.ArrayList;

/**
 * CardCodeShow is a subcomponent of addcard screen to input and display
 * cardcode
 */
public class CardCodeShow implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver,IFocusObserver,IFocusSubject{

	ITouchEventHandler nextHandler ;
	private int count = 0;
	private String d1,d2,d3;
	private boolean onfocus = false;
	private IScreen addcard;
	private ArrayList<IFocusObserver> observers ;
	
	
	public CardCodeShow(IScreen ac) {
		this.addcard = ac;
		observers = new ArrayList<IFocusObserver>() ;
	}

	/** change back to default value */
	public void clear(){
		d1=d2=d3="";
		count=0;
		onfocus = false;
	}

	/** handle the Card code by number and key 
	 * @param numKeys  the total number of key 
	 * @param key the value of the key
	*/
	@Override
	public void keyEventUpdate(int numKeys, String key) {
		// TODO Auto-generated method stub
		if(onfocus == true) {
			if(numKeys == 4 ){
				KeyPad kp =(KeyPad)((Spacer)nextHandler).nextHandler ;
            	kp.countPinDigits=count;
			}
			if(numKeys < 4 && numKeys>=0){
				count = numKeys;
				handle(key);
			}
		
		}
	}
	/** set the key 
	 * @param key the value of the key
	*/
	void handle(String key){
		if(key.equals("X")) {
			switch ( count )
			{
			case 0:d1="";break;
			case 1:d2="";break;
			case 2:d3="";break;
			default :break;
		}
		}else if(key.equals(" ")) {
			
		}else {
		switch ( count )
		{
		case 1:d1=key;break;
		case 2:d2=key;break;
		case 3:setD3(key);break;
		default :break;
		}
		}

	}

	/** handle the last digit inputting 
	 * @param key the third digit
	 * 
	*/
	void setD3(String key){
		d3 = key;
		String code = "["+d1+d2+d3+"]";
		((AddCard)addcard).setCode(code);
	}

	public void setFocus(boolean b){
		onfocus = b;
		
	}

	/** display the cardcode content the length and the digit value 
	 * @return  cardcode content
	*/
	@Override
	public String display() {
		// TODO Auto-generated method stub
				String value = "" ;
		        switch ( count )
		        {
		            case 0: value = "       []" ; break ;
		            case 1: value = "      ["+d1+"]" ; break ;
		            case 2: value = "      ["+d1+d2+"]" ; break ;
					case 3: value = "     ["+d1+d2+d3+"]" ; break ;
					default :break;
		        }
		        return value;
	}

	
	/** touch- handle the touch event in a chain 
	 * @param x  x coordinate
	 * @param y  y coordinate
	*/
	@Override
	public void touch(int x, int y) {
		// TODO Auto-generated method stub
		if (x==2&&y==3)
        {
            System.err.println( "CardCode bar Touched at (" + x + ", " + y + ")" ) ;
            onfocus = true;
            notifyFocusObersers();
        }else
        {
        	if ( nextHandler != null )
                nextHandler.touch(x,y) ;
        }
	}

	@Override
	public void setNext(ITouchEventHandler next) {
		// TODO Auto-generated method stub
		nextHandler = next ;
	}

	/** addSubComponent not use
	 * @param c  the subcomponent
	*/
	@Override
	public void addSubComponent(IDisplayComponent c) {
		// TODO Auto-generated method stub

	}

	/**
     * focus Event to Notify Observers 
     * @param onfocus onfocus or not
     * @param countDigits  the digit count right now
     */
	@Override
	public void focusEventUpdate(boolean onfocus, int countDigits) {
		// TODO Auto-generated method stub
		setFocus(onfocus);
	}

	/**
     * Add Observer to Subscribers List
     * @param obj Observer Object
     */
	@Override
	public void attachFocusObserver(IFocusObserver obj) {
		// TODO Auto-generated method stub
		observers.add( obj ) ;
	}

	/**
     * Remove Observer from Subscription
     * @param obj Observer Object
     */
	@Override
	public void removeFocusObserver(IFocusObserver obj) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(obj) ;
        if ( i >= 0 )
            observers.remove(i) ;
	}

	/**
     * Trigger Events to Observers
     */
	@Override
	public void notifyFocusObersers() {
		// TODO Auto-generated method stub
		for (int i=0; i<observers.size(); i++)
        {
            IFocusObserver observer = observers.get(i) ;
            observer.focusEventUpdate(false,count);
        }
	}
	

}
