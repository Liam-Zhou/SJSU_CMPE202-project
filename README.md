### The diagram is not clear enough,so I upload the astah file in umlDiagram file for better viewing.

## 1,Add Card 
   + design patterns:observer pattern,chain of responsibility,composite pattern
   + observer pattern(manage components input focus):
     | Interface | role | concrete class |
     | :-----:| :----: | :----: |
     | IFocusObserver | observer | CardIdShowCard,CodeShow |
     | IFocusSubject |  subject | KeyPad,CardIdShowCard,CardCodeShow |
   + observer pattern(manage keypad):
     | Interface | role | concrete class |
     | :-----:| :----: | :----: |
     | IKeyPadObserver | observer | CardIdShowCard,CodeShow |
     | IKeyPadSubject | subject | KeyPad |
   + chain of responsibility(subcomponent in addcard screen):
     | Interface | role | concrete class |
     | :-----:| :----: | :----: |
     | ITouchEventHandler | chain handler | KeyPad,CardIdShowCard (chain),CodeShow |
   + composite pattern(addcard screen):
     | Interface | role | concrete class |
     | :-----:| :----: | :----: |
     | IDisplayComponent | component | CardIdShowCard,CodeShow,KeyPad,Screen(composite role) |
     
     | class| role | child class|
     | :-----:| :----: |:----: |
     | Screen | composite | AddCard |
   + description:  
   Add Card screen page is using observer pattern(manage components input focus) and chain of responsibility(subcomponent),it consists of four subcomponents which are CardIdShow(chain),CardCodeShow,Spacer and KeyPad.the CardIDShow is similar to the Passcode in PinScreen,but it has 9 digits and it show every digit in the screen.CardCodeShow is for inputting card code which have 3 digits.Both CardIdShow and CardCodeShow have onfocus attribute,which indicate the one the keypad now typing in.I use observer pattern to manage the focus on CardIdShow or CardCodeShow,the keypad is the observer realizing IFocusObserver interface,Cardcodeshow and Cardidshow realize both IFocusObserver interface and IFocusSubject interface so that they can change each other's onfocus attribute.After inputing all the card id and card code, the next function is validating if the cardid and cardcode have 9 and 3 digits.if they do,they will be added to appcontroller as the attributes and navigate to my cards screen,or the cardid and cardcode must be reentered again.
  this is sequence diagram of adding card:
![Image text](https://github.com/nguyensjsu/cmpe202-liam-zhou/blob/master/starbucksUMLDiagram/Add%20Card%20Sequence%20Diagram.png)
  this is class diagram of adding card:
![Image text](https://github.com/nguyensjsu/cmpe202-liam-zhou/blob/master/starbucksUMLDiagram/AddCardClass.png)
## 2,Pin Authentication
   + design patterns:observer pattern,chain of responsibility,state pattern
   + observer pattern(manage keypad):
     | Interface | role | concrete class |
     | :-----:| :----: | :----: |
     | IKeyPadObserver | observer | PassCode,PinEntryMachine |
     | IKeyPadSubject | subject | KeyPad |
   + state pattern(manage pin state):
     | Interface | role | concrete class |
     | :-----:| :----: | :----: |
     | IPinState | state | NoPinDigits-SixPinDigits |
     | IPinStateMachine | context | PinEntryMachine |
   + chain of responsibility(subcomponent in Pinscreen):
     | Interface | role | concrete class |
     | :-----:| :----: | :----: |
     | ITouchEventHandler | chain handler | KeyPad,PassCode (chain) |
   + description:  
   Pin Authentication uses state pattern,observer pattern and chain of responsibility (PinScreen).KeyPad is subject of this observer pattern, it will update all the observers(PassCode and PinEntryMachine) when changing.when PinEntryMachine updated by keypad,it will call current state to do some reaction.then the state will call functions in PinEntryMachine to change digit stored in it.when digit is reaching 4 or 6,authenticating will happen.the difference between 4 pin and 6 pin authentication is that if we pass nothing in PinEntryMachine constructor,the defalut it "1234",if we pass 6 pin in constructor,the PinEntryMachine will stored it.Another difference is that the authenticating, display and pinstate setting will change when the length of pin are 6.
    this is Pin Authentication class diagram:
![Image text](https://github.com/nguyensjsu/cmpe202-liam-zhou/blob/master/starbucksUMLDiagram/pinAuthClass.png)
## 3,Screen Layout Management 
   + design patterns: decorator pattern
   + decorator pattern(manage keypad):
   
     | Interface | role | concrete class |
     | :-----:| :----: | :----: |
     | IDisplayComponent | component | Screen,ScreenDecorator |
 
     | class | role | child class |
     | :-----:| :----: | :----: |
     | ScreenDecorator | decorator | CenterDecorator,LeftingDecorator |
     
     
   + description: 
   the decorator pattern can be used in screen layout in displaying the screen content.CenterDecorator will make screen display into center,LeftingDecorator will make it to the left.
![Image text](https://github.com/nguyensjsu/cmpe202-liam-zhou/blob/master/starbucksUMLDiagram/ScreenLayoutClass.png)

