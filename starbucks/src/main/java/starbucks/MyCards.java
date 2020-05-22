/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */
package starbucks ;

/** My Cards Screen */
public class MyCards extends Screen
{
	private boolean ispay = false;
	private boolean flag = false;
	private IApp app;
	private boolean landscape = false;
    public MyCards(AppController app)
    {
    	this.app = app;
	}
	
	/** clear screen to defalut */
	public void clear() {
		ispay = false;
	}
	
	/** set screen to landscape */
	public void setLandscape() {
		if(flag){
			ispay = true;
		}
		this.landscape = true;
	}

	// public void setPortrait(){
	// 	if(!flag){
	// 		ispay = false;
	// 	}
	// 	this.landscape = false;
	// }

	/**
     * handle touch event
     * @param x Touch X
     * @param y Touch Y
     */
    @Override
    public void touch(int x, int y) {
		System.err.println("my card touched at (" + x + ", " + y + ")" );
		if(!landscape){
			
    	if(x==3&&y==3) {
    		if(ispay) {
    			this.ispay=false;
    		}else {
    			this.ispay=true;
    		}
    		
    	}
    	if((x==2&&y==2)||(x==3&&y==2)) {
    		if(this.ispay) {
    			
    			float balance = ((AppController) app).getBalance();
    			balance = (float) (balance - 1.50);
    			if(balance<0) {
    				balance = (float) (balance + 1.50);
    			}
    			((AppController) app).setBalance(balance);
    		}
    	}
    	if(x==2&&y==4) {
    		if(!this.ispay) {
    			app.execute("MyCardsOptions");
    		}
    	}
	}else{
		if(x==3&&y==3) { 
				flag = true; 
		}
	}
	
    }

	/** display the portrait content
	 * @return the content value
	 */
    @Override
	public String display() {
		// TODO Auto-generated method stub
    	float balance = ((AppController) app).getBalance();
    	String cardId = ((AppController) app).getCardId();
    	String value;
    	if(!ispay) {
    		String b = String.format("%1.2f", balance);
    		value = "     $"+b ;
    	}else {
    		value = "  "+cardId+"\n\n\n";
    		value += "    Scan Now";
    	}
		
		return value;
	}

	/** display the landscape content
	 * @return the content value
	 */
	public String ldisplay() {
		// TODO Auto-generated method stub
    	float balance = ((AppController) app).getBalance();
    	String cardId = ((AppController) app).getCardId();
    	String value;
    	if(!ispay) {
			String b = String.format("%1.2f", balance);
			value = "$"+b ;
			int num = value.length();
			String spaces = "";
			int pad = (33 - num) / 2 ;
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < pad; i++) {
				buf.append(" ");
			}
			spaces = buf.toString();
			value = spaces+value;
			
    	}else {
    		value = "           "+cardId+"\n\n\n";
    		value += "            Scan Now";
    	}
		
		return value;
	}
	
	/** get name of the screen
	 * @return name 
	 */
    @Override
    public String name() {
    	return " My Cards";
    }
   
}