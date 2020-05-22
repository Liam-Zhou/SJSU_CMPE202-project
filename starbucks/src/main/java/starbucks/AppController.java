/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/**
 * Main App Controller Class
 */
public class AppController implements IApp {

    private IScreen mycards ;
    private IScreen store ;
    private IScreen rewards ;
    private IScreen payments ;
    private IScreen setting;
    private IScreen addcard;
    private IScreen mycardsoptions;
    private IScreen mycardsmoreoptions;
    
    private IMenuCommand displayMyCards ;
    private IMenuCommand displayPayments ;
    private IMenuCommand displayRewards ;
    private IMenuCommand doStore ;
    private IMenuCommand displaySettings ;
    private IMenuCommand displayAddCard ;
    private IMenuCommand displayMyCardsOptions ;
    private IMenuCommand displayMyCardsMoreOptions ;
    
    private IFrame frame ;
    
    
	private KeyPad kp ;
	private CardIDShow cid;
	private CardCodeShow cc;
    private Spacer sp;
    private boolean island = false;
    
    private float balance=(float) 0.00;
    private String cardId="[000000000]";

    public AppController() {
        mycards = new MyCards(this) ;
        store = new Store(this) ;
        rewards = new Rewards() ;
        payments = new Payments() ;
        setting = new Settings(this) ;
        addcard = new AddCard(this) ;
        mycardsoptions = new MyCardsOptions(this);
        mycardsmoreoptions = new MyCardsMoreOptions(this);
        
        startup();
        
        frame = new Frame( mycards ) ;

        // setup command pattern
        displayMyCards  = new MenuCommand() ;
        displayPayments = new MenuCommand() ;
        displayRewards  = new MenuCommand() ;
        doStore         = new MenuCommand() ;
        displaySettings = new MenuCommand() ;
        displayAddCard = new MenuCommand() ;
        displayMyCardsOptions = new MenuCommand() ;
        displayMyCardsMoreOptions = new MenuCommand() ;
        
        displayMyCards.setReceiver(
            new IMenuReceiver() {
                /** Command Action */
                public void doAction() {
                    frame.setCurrentScreen( mycards ) ;
                }
          }
          ) ;
          displayPayments.setReceiver(
            new IMenuReceiver() {
                /** Command Action */
                public void doAction() {
                    frame.setCurrentScreen( payments ) ;
                }
          }
          ) ;
          displayRewards.setReceiver(
            new IMenuReceiver() {
                /** Command Action */
                public void doAction() {
                    frame.setCurrentScreen( rewards ) ;
                }
          }
          ) ;
          doStore.setReceiver(
            new IMenuReceiver() {
                /** Command Action */
                public void doAction() {
                    frame.setCurrentScreen( store ) ;
                }
          }
          ) ;
          displaySettings.setReceiver(
                  new IMenuReceiver() {
                      /** Command Action */
                      public void doAction() {
                          frame.setCurrentScreen( setting ) ;
                      }
                }
          );
          displayAddCard.setReceiver(
                  new IMenuReceiver() {
                      /** Command Action */
                      public void doAction() {
                          frame.setCurrentScreen( addcard ) ;
                      }
                }
          );
          displayMyCardsOptions.setReceiver(
                  new IMenuReceiver() {
                      /** Command Action */
                      public void doAction() {
                          frame.setCurrentScreen( mycardsoptions ) ;
                      }
                }
          );
          displayMyCardsMoreOptions.setReceiver(
                  new IMenuReceiver() {
                      /** Command Action */
                      public void doAction() {
                          frame.setCurrentScreen( mycardsmoreoptions ) ;
                      }
                }
          );
        
        frame.setMenuItem ( "A", displayMyCards ) ;
        frame.setMenuItem ( "B", displayPayments ) ;
        frame.setMenuItem ( "C", displayRewards ) ;
        frame.setMenuItem ( "D", doStore ) ;
        frame.setMenuItem ( "E", displaySettings);
        frame.setMenuItem ( "AddCard", displayAddCard);
        frame.setMenuItem ( "MyCardsOptions", displayMyCardsOptions);
        frame.setMenuItem ( "MyCardsMoreOptions", displayMyCardsMoreOptions);
        
    }

    /** start the app */
    public void startup(){
        cid = new CardIDShow(addcard);
		cc = new CardCodeShow(addcard);
		sp = new Spacer() ;
		kp = new KeyPad();
		
		((AddCard)addcard).addSubComponent(cid);
		((AddCard)addcard).addSubComponent(cc);
		((AddCard)addcard).addSubComponent(sp);
		((AddCard)addcard).addSubComponent(kp);
		
		((IKeyPadSubject)kp).attach( cid ) ;
        ((IKeyPadSubject)kp).attach( cc ) ;

        //observer pattern: cardid and cardcode onfocus
        ((IFocusSubject)cid).attachFocusObserver(cc);
        ((IFocusSubject)cid).attachFocusObserver(kp);
        ((IFocusSubject)cc).attachFocusObserver(cid);
        ((IFocusSubject)cc).attachFocusObserver(kp);
    }
    

    public void setBalance(float ba) {
    	balance = ba;
    }
    
    public float getBalance() {
    	return balance;
    }
    
    public void setCardId(String id) {
    	cardId = id;
    }
    
    public String getCardId() {
    	return cardId;
    }
    /**
      * Switch to Landscape Mode
      */
    public void landscape() {
        System.err.println("change to landscape");
            island = true;
            frame.landscape() ;
        
    }

    /**
     * Switch to Portait Mode
     */
    public void portrait() {
        frame.portrait() ;
    }

    /**
     * Send In Touch Events
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y) {
        System.err.println("app controller touched at (" + x + ", " + y + ")" );
        frame.touch(x, y) ;
    }

    /**
     * Display Current Screen
     */
    public void display() {
        frame.display() ;
    }

    /**
     * Execute Menu Bar Command
     * @param c Menu Bar Option (A, B, C, D or E)
     */
    public void execute( String c ) {

        ((AddCard) addcard).clear();
        if(!island){
            ((MyCards) mycards).clear();
        }
        frame.cmd( c ) ;
    }

    /**
     * Navigate to Previous Screen
     */
    public void prev() {
        frame.previousScreen() ;
    }

    /**
     * Navigate to Next Screen
     */
    public void next() {
        frame.nextScreen() ;
    }

    /**
     * Get Current Screen Name
     * @return Screen Name
     */
    public String screen() {
        return frame.screen() ;
    }

    /**
     * Get Current Screen Contents
     * @return Current Screen Contents
     */
    public String screenContents() {
        return frame.contents() ;
    }

}
