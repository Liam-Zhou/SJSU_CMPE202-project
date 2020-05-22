package starbucks;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class mytest {
	IApp app ;


    @Before
    public void setUp()
    {
        app = (IApp) Device.getNewInstance() ;
    }

    @Test
    public void SettingsTest1() {
        assertEquals("", app.screen().trim());
       // System.err.println("app.screenContents()"+app.screenContents());
        // app.touch(1,5) ;
        // app.touch(2,5) ;
        // app.touch(3,5) ;
        // app.touch(2,5) ;
        //System.err.println("zlll llapp.screenContents()"+app.screenContents());
        app.touch(1,5) ;
        //System.err.println("app.screenContents()"+app.screenContents());
        app.touch(2,5) ;
        app.touch(3,5) ;
        app.touch(1,6) ;
        app.execute("E") ;
        //assertEquals("Settings", app.screen().trim());
        
        app.touch(1,1) ; // Add New Card
        assertEquals("Add Card", app.screen().trim());
        // Card Id digits
        app.touch(1,5); 
        app.touch(2,5);
        app.touch(3,5);
        app.touch(1,6);
        app.touch(2,6);
        app.touch(3,6);
        app.touch(1,7);
        app.touch(2,7);
        // app.touch(3,7);//9
        app.touch(2,3); // focus on card code
        // Card Code digits
        app.touch(3,7);//9
        app.touch(3,7);
        app.touch(3,7);
        app.touch(1,2); // focus on card id
        app.touch(3,7);//9
        System.err.println("zlll llapp.screenContents()"+app.screenContents());
        app.next() ;  
        app.touch(3,3); 
        app.touch(2,2);  // Pay $1.50
        app.touch(3,3);
        
        app.execute("E") ; // Settings Page
        assertEquals("Settings", app.screen().trim());
        app.touch(1,1) ; // Add New Card
        assertEquals("Add Card", app.screen().trim());
        // Card Id digits
        app.touch(1,5); 
        //System.err.println("zlll llapp.screenContents()"+app.screenContents());
        
        app.touch(2,5);
        app.touch(3,5);
        app.touch(1,6);
        app.touch(2,6);
        app.touch(3,6);
        app.touch(1,7);
        app.touch(2,7);
        app.touch(3,7);
        //System.err.println("zlll llapp.screenContents()"+app.screenContents());
        
        app.touch(2,3); 
        
        // Card Code digits
        app.touch(3,7);
        //System.err.println("app.screenContents()"+app.screenContents());
        app.touch(3,7);
        System.err.println("zyl1"+app.screenContents());
        app.touch(3,7);
        System.err.println("zyl2)"+app.screenContents());
        app.next() ;  
        System.err.println("zyl3)"+app.screenContents());
        
       app.execute("E") ; // Settings Page
       assertEquals("Settings", app.screen().trim());
       app.touch(1,1) ; // Add New Card
       assertEquals("Add Card", app.screen().trim());
       app.prev() ;
       assertEquals("Settings", app.screen().trim());
       app.touch(2,1) ; // Add New Card
       assertEquals("Add Card", app.screen().trim());
       app.prev() ;
       assertEquals("Settings", app.screen().trim());
       app.touch(3,1) ; // Add New Card
       assertEquals("Add Card", app.screen().trim());
       app.prev() ;
       assertEquals("Settings", app.screen().trim());   
    }

    
    @After
    public void tearDown()
    {
    }
}
