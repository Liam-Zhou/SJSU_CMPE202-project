/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

/**
 * Add New Card Screen
 */
public class AddCard extends Screen
{
	private IApp app;
	private String cardid = "";
	private String code = "";
	
    public AddCard(AppController app)
    {
    	this.app = app;
    }
    
    
    public void setCardId(String id) {
    	cardid = id;
    }
    
    public String getCardId() {
    	return cardid;
    }
    public void setCode(String c) {
    	code = c;
    }
    
    public String getCode() {
    	return code;
	}
	/** previous page- jump to setting page */
    @Override 
    public void prev() {
    	app.execute("E");
	}
	
	 /** clear- make SubComponent back to initial states  */
	public void clear() {
		ITouchEventHandler chain = super.getchain();
    	((CardIDShow)chain).clear();
    	((CardCodeShow)((CardIDShow)chain).nextHandler).clear();
    	KeyPad kp =(KeyPad)((Spacer)((CardCodeShow)((CardIDShow)chain).nextHandler).nextHandler).nextHandler;
    	kp.clear();
	}

    /** next- jump to mycard page if validation pass */
    @Override	
    public void next() {
        // add code here
    	System.err.println("code cardid"+code+cardid);
		clear();
		
		if(!cardid.equals("[000000000]")){
    	if(!cardid.equals("") && !code.equals("")) {
    		((AppController) app).setCardId(cardid);
        	((AppController) app).setBalance((float) 20.00);
        	//((CardCodeShow)chain.nextHandler)
        	//System.err.println("(CardIDShow)chain"+((CardIDShow)chain).display());
        	//((CardIDShow)chain).display();
        	app.execute("A");
        	
		}
		}
    	cardid = "";code = "";
	}


	/**  change name formate to obey the requirement 
	 * @return     name
	*/
    @Override  
    public String name() {
    	return " Add Card";
    }
    
}
