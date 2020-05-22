package starbucks ;

/** ScreenDecorator use decorator pattern */
public class ScreenDecorator implements  IScreen, IDisplayComponent
{

    private Screen screen ;
    public ScreenDecorator(Screen screen)
    {
        this.screen = screen;
    }

    /**
     * Add A Child Component
     * @param c Child Component
     */
    @Override
    public void addSubComponent(IDisplayComponent c) {
        // TODO Auto-generated method stub
        screen.addSubComponent(c);
    }

    /**
     * Send touch events to screen
     * @param x Touch X
     * @param y Touch Y
     */
    @Override
    public void touch(int x, int y) {
        // TODO Auto-generated method stub
        screen.touch(x, y);
    }

    /**
     * Return Display Component Contents
     * @return Display Component Contents
     */
    @Override
    public String display() {
        // TODO Auto-generated method stub
        return screen.display();
    }

    /**
     * Return Display Component Contents
     * @return Display Component Contents
     */
    @Override
    public String ldisplay() {
        // TODO Auto-generated method stub
        return screen.ldisplay();
    }

    /**
     * Returns name of screen
     * @return Screen Name
     */
    @Override
    public String name() {
        // TODO Auto-generated method stub
        return screen.name();
    }

    /**
     * Navigate to next screen
     */
    @Override
    public void next() {
        // TODO Auto-generated method stub
        screen.next();
    }

    /**
     * Navigate to previous screen
     */
    @Override
    public void prev() {
        // TODO Auto-generated method stub
        screen.prev();
    }

    /**
     * Set next screen with action name
     * @param s Screen
     * @param n Action
     */
    @Override
    public void setNext(IScreen s, String n) {
        // TODO Auto-generated method stub
        screen.setNext(s, n);
    }

    /**
     * Set previous screen with action name
     * @param s Screen
     * @param n Action
     */
    @Override
    public void setPrev(IScreen s, String n) {
        // TODO Auto-generated method stub
        screen.setPrev(s, n);
    }
    
}