package starbucks;

/** Pin state of the sixth digit */
public class SixPinDigits implements IPinState {

	IPinStateMachine machine ;
	public SixPinDigits(IPinStateMachine m) {
		this.machine = m;
	}

	/** Backspace Event */
	@Override
	public void backspace() {
		// TODO Auto-generated method stub
		machine.setStateFivePinDigits(null) ;
	}

	/**
     * Number Event
     * @param digit Digit/Key Pressed
     */
	@Override
	public void number(String digit) {
		// TODO Auto-generated method stub
		
	}

	/** Valid Pin Event */
	@Override
	public void validPin() {
		// TODO Auto-generated method stub
		return;
	}

	/** Invalid Pin Event */
	@Override
	public void invalidPin() {
		// TODO Auto-generated method stub
		machine.setStateNoPinDigits() ;
	}

}
