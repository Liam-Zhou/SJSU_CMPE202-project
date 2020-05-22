package starbucks;

/** Pin state of the fifth digit */
public class FivePinDigits implements IPinState {

	IPinStateMachine machine ;
	
	public FivePinDigits( IPinStateMachine m) {
		this.machine = m;
	}
	
	/** Backspace Event */
	@Override
	public void backspace() {
		// TODO Auto-generated method stub
		machine.setStateFourPinDigits( null ) ;
	}

	/**
     * Number Event
     * @param digit Digit/Key Pressed
     */
	@Override
	public void number(String digit) {
		// TODO Auto-generated method stub
		machine.setStateSixPinDigits( digit ) ;
	}

	/** Valid Pin Event */
	@Override
	public void validPin() {
		// TODO Auto-generated method stub
		
	}

	/** Invalid Pin Event */
	@Override
	public void invalidPin() {
		// TODO Auto-generated method stub
		
	}

}
