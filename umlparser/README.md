 # week1 journal:
     
  | Day | what I'm doing | 
  | :-----:| :----: | 
  | Saturday | I started the project by searching materials and trying to choose the suitable tools.I read documents about ANTLR, Javaparser and try yuml to generate some diagram. |
  | Sunday | I built a little demo to learn how to use ANTLR and yuml,I configured the environment of ANTLR and run the test demo successfully,as for yuml,I read the yuml syntax document and download the yuml extension for VScode which can show the diagram in real time.|
  | Monday | I built a demo to test javaparser and learned to use Maven to manage project and dependencies,then I realized the javaparser is more suitable because of its convenience and its detailed official documents.Therefore, I choose javaparser and yuml as my tools of umlparser project.Then,I design the flow of the application and file structure.|
  | Tuesday | today is a long day,I read the javaparser official documents and trying to understand the important methods,then choose the right method to get classes' detailed information like: visibility,name of variable,type of variable,is single or not,etc.To better understand the concept in official dicument,I tested many methods and types like:FieldDeclaration,Modifier,SimpleName,PrimitiveType,ReferenceType,ArrayTypeClassOrInterfaceType CompilationUnit,and methods:getAccessSpecifier(),getVariable(),getElementType(),getCommonType() etc.Then start parsing test1.|
  | Wednesday | I finished test1 today,I choose json data structure to store the information about classes,the example are below,in the structure:the primiStat is yuml syntax describing the basic attribute of class,relation shows the association relationship with other classes.Then I generate yuml statement and make a http request to get a uml diagram and it work.|
   | Thursday | I encountered a bug:the returned picture from yuml website are shown "301 Moved Permanently" error,then I searched online materials and fixed that problem by using https request instead of http request.Then I design the test2 parser,how to get class inheritance,realization and dependency relationship and search javaparser offical doc and try possible method.|
   | Friday | I learned how to parse method statement,get data of parent classes and implemented interfaces,then transfer the method statement to yuml syntax.use the type:MethodDeclaration, the methods:getAccessSpecifier(),getNameAsString(),getTypeAsString() etc  |
   | Saturday | I finished test2, successfully generate uml diagram for test2,which add new realtionships(inheritance,realization,dependency) parsing func compared to test1. |
   

# week2 journal:
     
  | Day | what I'm doing | 
  | :-----:| :----: | 
  | Sunday,Monday | I started test3,I added the features to ignore setter and getter function,and change the visibility of attribute to functions' visibility.these are pretty straight forward and not need to use javaparser methods. |
  | Tuesday | I finished test3 and generated the diagram of test3 successfully,and went over test1,2 to make sure they are not be affected.then I started test4,after fixing some bugs about handleing exception,the diagram is generated successfully,but dependencies relationship are repeated,I will fix this bug tomorrow.| 
  | Wednesday | I finished test4 by fixing the bug about duplicate dependencies relationship,then the diagram for test4 is generated successfully,then I started test5.As for test5,the feature I need to add is extract constructor function,ignore private function, improve dependencies relationship handling| 
  | Thursday | I finished test5, fixing some bugs about parsing dependencies realtionship.then I start to learn using command to run project| 
  | Friday | I stuck in the command line problem,I learned to use command to run my project but didn't work,I changed the files structure because I was misunderstood the requirments:I create tests folder to store test1-5 and put my solution code in src(default package). will spend more time on the command line problem| 
  | Saturday | still stuck in the command line problem,but made some progress,I learned to use maven to export my project as jar file,then use command line by writting this command: "java -jar umlparser.jar "source folder" "output file name" ".but still don't know how to use "umlparser "source folder" "output file name"" to run projrct,I will spend more on the command line problem| 
  
  
  # week3 journal:
     
  | Day | what I'm doing | 
  | :-----:| :----: | 
  | Sunday,Monday | I became more familiar with command line problem,and because of better understanding,I generated a idea ,which is convert jar file to execuable file,I tried a lot of tools to convert jar file,like Jbuilder,exe4j,launch4j.but all these tools can only generate exe file which can only used in Windows. |
  | Tuesday | Finially,I successfully resolve the problem,I searched many online materials to about how to convert jar file to   Linux executable file.Then I created a ch file to convert jar file,then use the command "cat umlparser.sh umlparser.jar > umlparser.run && chmod +x umlparser.run" to create a exec file.and pass the arguments to it,then generate the diagram succesfully.Then I can spend time on parsing starbucks project. | 
  | Wednesday | today I finished parsing starbucks project,which make me real excited.Although the result is good,the whole process is painful.First,I faced a bug of handling exception,so I spent lot of time to find the reason.Then,I faced the problem of hitting the get request limit,so I changed to send post request,then the yuml websit return a picture code,then I use this code to send a get request to fetch the picture.Finally,all the class diagrams are generated.real awesome!!! next step I decided to make my code more readable,I write all my code into two files which will produce bad smells.I will spend time on dealing with that. | 
  | Thursday,Friday,Saturday | these days I tried to reduce code smell, to optimize code and so on. | 
  
  # week4 journal:
  
  | Days | what I'm doing | 
  | :-----:| :----: | 
  | Sunday to Wednesday | I rechecked my starbuck project class diagram,I realized that some class didn't show and some relationship are redundant and unnecessary,so I decided to reduce some unnecessary code|
  | Thursday Friday |  time spent on this project was fewer than past 3 weeks,because I almost finished umlparser last week.I still did some work like arrange the code,reduce code , fix some little bugs,add some friendly prompt in command line,test the project,check the requirement and diagram again to see if there is difference or not.I found out some attribute of yuml,as long as the class is shown before, next time even I didn't include the attribute it will still show them,because it has been used.Therefore,it reduce the length of string sent to yuml website which will help show more class of starbuck project.|
  | Saturday | I wrote the instruction about how to run the project and take the snpashot about the process:below is the process: 1,enter into umlparser folder by using command line: cd (your local path)/cmpe202-liam-zhou/umlparser.2,use command: umlparser (path of test folder) (name of picture).For example: umlparser ./tests/test1 test1Pic,then the test1Pic.png will be generated in the umlparser folder(current path).|
  
 - example:
 ![Image text](https://github.com/nguyensjsu/cmpe202-liam-zhou/blob/master/umlparser/example.png) 
      
  ### the diagram I generate for starbucks project:
  
 ![Image text](https://github.com/nguyensjsu/cmpe202-liam-zhou/blob/master/umlparser/tests/starbucks.png)
  ### the diagram I generate for test1-5:
 
 ![Image text](https://github.com/nguyensjsu/cmpe202-liam-zhou/blob/master/umlparser/tests/umlDiagram.png)

 

  ### I choose json as the data structure of my project to store every java file information:<br/>
   
   | key | type | 
   | :-----:| :----: | 
   | classname | jsonObject1 | 
   
   data structure of jsonObject1:
   | key | type | 
   | :-----:| :----: | 
   | primiStat | String | 
   | className | String | 
   | relation | jsonObject2 |
   | parentClasses | ArrayList <String> | 
   | parentInterfaces | ArrayList <String> |
   | dependencies | ArrayList <String> |
     
   data structure of jsonObject2:
   | key | type | 
   | :-----:| :----: | 
   | classname | jsonObject3 | 
   
   data structure of jsonObject3:
   | key | type | 
   | :-----:| :----: | 
   | isSingle | boolean | 
   | isChecked | boolean | 
   
   example:<br/>
   {"A":<br/>
     &nbsp;{"primiStat":"[A|-x:int;-y:int(*);]",<br/>
     &nbsp; "className":"A",<br/>
     &nbsp; "relation":{"B":{"isSingle":false,"isChecked":true},<br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"C":{"isSingle":true,"isChecked":true},<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"D":{"isSingle":false,"isChecked":true}},<br/>
           "parentClasses":["P"],<br/>
           "parentInterfaces":["A1","A2"],<br/>
           "dependencies":["A2"]}<br/>
         }<br/>
  } <br/>
 

