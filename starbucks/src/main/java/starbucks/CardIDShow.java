package starbucks;

import java.util.ArrayList;

/**
 * CardCodeShow is a subcomponent of addcard screen to input and display card ID
 */
public class CardIDShow implements ITouchEventHandler, IDisplayComponent, IKeyPadObserver,IFocusSubject ,IFocusObserver{

//	imitate Passcode
	ITouchEventHandler nextHandler ;
	private int count = 0;
	private String d1,d2,d3,d4,d5,d6,d7,d8,d9;
	private boolean onfocus = true;
	private IScreen addcard;
	private ArrayList<IFocusObserver> observers ;
	
	public CardIDShow(IScreen ac) {
		this.addcard = ac;
		observers = new ArrayList<IFocusObserver>() ;
	}
	
	
	/** handle the Card ID by number and key 
	 * @param numKeys  the total number of key right now
	 * @param key the value of the key
	*/
	@Override
	public void keyEventUpdate(int numKeys, String key) {
		// TODO Auto-generated method stub
		System.err.println("num key "+numKeys+' '+key);
		if(onfocus == true) {
			if(numKeys == 10 ){
				KeyPad kp =(KeyPad)((Spacer)((CardCodeShow)nextHandler).nextHandler).nextHandler;
            	kp.countPinDigits=count;
			}
			if(numKeys <10 && numKeys>=0){
				count = numKeys;

			if(key.equals("X")) {
				switch ( count )
				{
				case 0:d1="";break;
				case 1:d2="";break;
				case 2:d3="";break;
				case 3:d4="";break;
				case 4:d5="";break;
				case 5:d6="";break;
				case 6:d7="";break;
				case 7:d8="";break;
				case 8:d9="";break;
				default :break;
				}
				
			}else if(key.equals(" ")) {
				
			}else {
				switch ( count )
					{
					case 1:d1=key;break;
					case 2:d2=key;break;
					case 3:d3=key;break;
					case 4:d4=key;break;
					case 5:d5=key;break;
					case 6:d6=key;break;
					case 7:d7=key;break;
					case 8:d8=key;break;
					case 9:setD9(key);break;
					default :break;
					}
			}
			
			}
		}
		
	} 

	/** change back to default value */
	public void clear(){
		d1=d2=d3=d4=d5=d6=d7=d8=d9="";
		count = 0;
		onfocus = true;
	}

	/** handle the last digit inputting 
	 * @param key the 9th digit
	 * 
	*/
	void setD9(String key){
		d9 = key;
		String cardid = "["+d1+d2+d3+d4+d5+d6+d7+d8+d9+"]";
		((AddCard)addcard).setCardId(cardid);
	}

	/** display the cardid content the length and the digit value 
	 * @return  cardid content
	*/
	@Override
	public String display() {
		// TODO Auto-generated method stub
		return display_content("");
	}

	/** display the cardid content the length and the digit value 
	 * @param value the value of key
	 * @return  cardid content
	*/
	String display_content(String value){
		switch ( count )
        {
            case 0: value = "       []" ; break ;
            case 1: value = "      ["+d1+"]" ; break ;
            case 2: value = "      ["+d1+d2+"]" ; break ;
            case 3: value = "     ["+d1+d2+d3+"]" ; break ;
            case 4: value = "     ["+d1+d2+d3+d4+"]" ; break ;
            case 5: value = "    ["+d1+d2+d3+d4+d5+"]" ; break ;
            case 6: value = "    ["+d1+d2+d3+d4+d5+d6+"]" ; break ;
            case 7: value = "   ["+d1+d2+d3+d4+d5+d6+d7+"]" ; break ;
            case 8: value = "   ["+d1+d2+d3+d4+d5+d6+d7+d8+"]" ; break ;
			case 9: value = "  ["+d1+d2+d3+d4+d5+d6+d7+d8+d9+"]" ; break ;
			default :break;
		}
		return value  ;
	}

	/** addSubComponent not use
	 * @param c  the subcomponent
	*/
	@Override
	public void addSubComponent(IDisplayComponent c) {
		// TODO Auto-generated method stub
		
	}
	public void setFocus(boolean b){
		onfocus = b;
	}

	/** touch- handle the touch event in a chain 
	 * @param x  x coordinate
	 * @param y  y coordinate
	*/
	@Override
	public void touch(int x, int y) {
		// TODO Auto-generated method stub
		if ((x==1&&y==2) || (x==2&&y==2) || (x==3&&y==2))
        {
            System.err.println( "CardId showbar Touched at (" + x + ", " + y + ")" ) ;
            onfocus = true;
			notifyFocusObersers();
        }else
        {
                nextHandler.touch(x,y) ;
		}
		
		
	}

	@Override
	public void setNext(ITouchEventHandler next) {
		// TODO Auto-generated method stub
		nextHandler = next ;
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

}
