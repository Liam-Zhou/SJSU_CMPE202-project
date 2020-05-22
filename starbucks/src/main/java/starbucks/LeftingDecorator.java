
package starbucks ;

/** LeftingDecorator extends  ScreenDecorator */
public class LeftingDecorator extends  ScreenDecorator
{
    private String addedString;
    public LeftingDecorator(Screen screen) {
        super(screen);
        // TODO Auto-generated constructor stub
    }
    /**
     * Return Display Component Contents
     * @return Display Component Contents
     */
    public String display() {
        // TODO Auto-generated method stub
        addedString = super.display();
        String out ="";
        String screen = addedString + "\n" ;
                int cnt1 = countLines( screen ) ;
                int pad1 = (10 - cnt1) / 2;
                out += padLines( pad1 ) ;
                out += screen  ;          
                int cnt2 = countLines( out ) ;
                int pad2 = 10 - cnt2 ;
                String padlines = padLines( pad2 ) ;
                out += padlines ;
        return out;
    }
      /**
     * Helper:  Count lines in a String 
     * @param  str Lines to Count
     * @return     Number of Lines Counted
     */
    private int countLines(String str){


        if (str == null || str.isEmpty()) {
                return 0;
            }

        int lines = 0;
        int pos = 0;
        while ((pos = str.indexOf("\n", pos) + 1) != 0) {
                lines++;
        }

        return lines ;
    }

     /** 
     * Helper:  Pad lines for a Screen 
     * @param  num Lines to Padd
     * @return     Padded Lines
     */
    private String padLines(int num) {
        String lines = "" ;
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < num; i++) {
            System.err.print(".") ;
            buf.append("\n");
        }
        lines = buf.toString();
        System.err.println("") ;
        return lines ;
    }
}