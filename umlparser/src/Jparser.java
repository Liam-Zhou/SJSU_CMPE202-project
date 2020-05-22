
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.PrimitiveType;
 



public class Jparser {
	
	 static String changeVisibilityToMark(String vis) {
		switch(vis) {
    	case  "private" : vis = "-";break;
    	case  "public" : vis = "+";break;
    	default:vis = "";break;
    	}
		return vis;
		
	 }
	public static JSONObject parser(File inFile) {
        try{
        	JavaParser jp = new JavaParser();
        	JSONObject object = new JSONObject();
        	List<String> primiArr = new ArrayList();
        	//List<JSONObject> relationArr = new ArrayList();
        	JSONObject relationArr = new JSONObject();
        	
        	String fileName = inFile.getName();
        	String[] strArr = fileName.split("\\.");
        	String className = strArr[0];
        	
        	object.put("className",className);
        	
        	
            System.out.println("inFile: "+inFile.toString()+"\n");
            
            CompilationUnit unit = jp.parse(inFile).getResult().get(); 
            //System.out.println("unit "+unit);
            
            
            //get all the methods in class and dependencies
            ArrayList<String> dependenciesUses = new ArrayList<String>() ;
            List<MethodDeclaration> methods = unit.findAll(MethodDeclaration.class);
			ArrayList<String> methodStats = new ArrayList<String>();
			String visibilityOfGetter = "";//find visibility of the getter and setter attribute
            String variableName = "";//find the name of the variable of getter and setter
            
            //get constructor function  ConstructorDeclaration
            List<ConstructorDeclaration> constructorMethods = unit.findAll(ConstructorDeclaration.class);
            if(constructorMethods.size() != 0) {
            	ConstructorDeclaration cm = constructorMethods.get(0);
            	String visibility = cm.getAccessSpecifier().asString();
            	visibility = changeVisibilityToMark(visibility);//visibility
            	String methodName = cm.getNameAsString();
            	String paramName;
            	String typeOfParam;
            	String nameAndType = "";
            	if(cm.getParameters().size() != 0) {
            		
            		 paramName = cm.getParameters().get(0).getNameAsString();//name of param
                	 typeOfParam = cm.getParameters().get(0).getTypeAsString();//type of param
                	 nameAndType = paramName+":"+typeOfParam;
                	 if(typeOfParam.equals("int")||typeOfParam.equals("String")||typeOfParam.equals("String[]")) {
                		 
                	 }
                	 else {
                		 dependenciesUses.add(typeOfParam);
                 	 }
            	};
            	String methodYuml = visibility+methodName+"("+nameAndType+");";//yuml of method
            	methodStats.add(methodYuml);
            }
            //System.out.println("constructorMethods  "+ constructorMethods);
            
            
            
            for(int j = 0; j < methods.size(); j++) {
            	
            	//System.out.println("methods.size()  "+ methods.size());
            	MethodDeclaration m = methods.get(j);
            	boolean isSetterOrGetter = false;
            	String visibility = m.getAccessSpecifier().asString();
            	visibility = changeVisibilityToMark(visibility);//visibility
            	String methodName = m.getNameAsString();//name of method methodName.length() > 3
            	String returnType = m.getTypeAsString();
            	//System.out.println("returnType  "+ returnType);
            	//System.out.println("methodName  "+ methodName.length());
            	if(methodName.length() > 3) {
            		if(methodName.substring(0, 3).equals("set")) {
            			isSetterOrGetter = true;
            			if(m.getBody().toString().equals("Optional.empty")) {
            				isSetterOrGetter = false;
            			}else {
            				String statement = m.getBody().get().getChildNodes().get(0).toString();//get the content of func
                			
    	            		variableName = statement.split(" ")[0];
    	            		if(variableName.split("\\.").length == 1) {
    	            			isSetterOrGetter = false;
    	            			variableName = "";
    	            		}else {
    	            			variableName = variableName.split("\\.")[1];
    	            		}
            			}
            			
            		};
            		if(methodName.substring(0, 3).equals("get")) {
						isSetterOrGetter = true;
						if(m.getBody().toString().equals("Optional.empty")) {
            				isSetterOrGetter = false;
            			}else {
            				visibilityOfGetter = m.getAccessSpecifier().asString();
    	            		String statement = m.getBody().get().getChildNodes().get(0).toString();
    	            		variableName = statement.split(" ")[1];
    	            		variableName = variableName.substring(0, variableName.length() - 1);
    	            		if(variableName.split("\\.").length == 1) {
    	            			isSetterOrGetter = false;
    	            			variableName = "";
    	            		}else {
    	            			variableName = variableName.split("\\.")[1];
    	            		}
            			}
						
	            		//System.out.println("m  "+ variableName);
            		};
            	}
            	if(!isSetterOrGetter) {
            	//System.out.println("paramName  "+ m.getParameters());
            	String paramName;
            	String typeOfParam;
            	String nameAndType = "";
            	
            	if(methodName.equals("main")) {
            		Node statement = m.getBody().get().getChildNodes().get(0);
            		List<ClassOrInterfaceType> classList = statement.findAll(ClassOrInterfaceType.class);
            		//System.out.println("statement  "+statement.findAll(ClassOrInterfaceType.class));
            		if(classList.size() > 0) {
            			dependenciesUses.add(classList.get(0).asString());
            		}
            	}
            	if(m.getParameters().size() != 0) {
            		
            		 paramName = m.getParameters().get(0).getNameAsString();//name of param
                	 typeOfParam = m.getParameters().get(0).getTypeAsString();//type of param
                	 if(typeOfParam.equals("String[]")) {typeOfParam = "String()";
                	// System.out.println("typeOfParam  "+ typeOfParam);
                	 };
                	 nameAndType = paramName+":"+typeOfParam;
                	 
                	 if(typeOfParam.equals("int")||typeOfParam.equals("String")||typeOfParam.equals("String()")) {
                		 
                	 }
                	 else {
                		 dependenciesUses.add(typeOfParam);
                 	 }
            	};
            	
            	if(visibility.equals("+")) {
            		String methodYuml = visibility+methodName+"("+nameAndType+")"+":"+returnType+";";//yuml of method
                	methodStats.add(methodYuml);
            	}
            	
            	}
            	
            }
            
            //System.out.println("methodStats "+methodStats);
            

            
            // to get class attribute and class association
            List<FieldDeclaration> arr1 = unit.findAll(FieldDeclaration.class);
            //System.out.println("arr1 "+arr1);
            for (int i = 0; i < arr1.size(); i++) {
            	List<PrimitiveType> arr2 = arr1.get(i).findAll(PrimitiveType.class);
            	List<ClassOrInterfaceType> arr3 = arr1.get(i).findAll(ClassOrInterfaceType.class);
            	//System.out.println("arr3"+arr3);
            	String name = "";
            	if(arr3.size() != 0) {
            		 name = arr3.get(0).asString();//base class type
            	}
                //System.out.println("arr3 name "+name);
            	//System.out.println("arr2 "+arr2);
                if(arr2.size() != 0 || name.equals("String")) { 
                	String primi = "";
                	String varName = arr1.get(i).getVariable(0).toString();//variable Name
                	String visibility = arr1.get(i).getAccessSpecifier().asString(); 
                	//System.out.println("visibility now "+visibility);
                	if(varName.equals(variableName)) {
                		visibility = changeVisibilityToMark(visibilityOfGetter);//visibility
                	}else {
                		visibility = changeVisibilityToMark(visibility);//visibility
                	}
                	
                	//System.out.println("visibility now "+visibility);
                	if(!visibility.equals("")) {
                	
                	String type = arr1.get(i).getElementType().asString();//variable type
                	String commonType = arr1.get(i).getCommonType().asString();//variable type(include array)
                	boolean isSingle = true;
                	if(!type.equals(commonType)) {
                		isSingle = false;// multiplicities
                	} 
                	
                	primi = visibility + varName + ":" + type;
                	if(!isSingle) {
                			primi += "(*);";
                	}else {
                			primi += ";";
                	}
                	//System.out.println("primi now"+primi);
                	primiArr.add(primi); 
                	}
                	//System.out.println("primiArr now"+primiArr);
                }else {
                	JSONObject relationObj = new JSONObject(); 
                    boolean isSingle = true;
                	if(arr3.size()>1) {
                		isSingle = false;
                		name = arr3.get(1).asString();//base class type
                	}
                	
                	//relationObj.put("name", name);
                	relationObj.put("isSingle", isSingle);// multiplicities
                	relationObj.put("isChecked", false);// ischecked 
                	//relationArr.add(relationObj);
                	relationArr.put(name, relationObj);//base class type
                	//System.out.println("relationArr now "+relationArr);
                }
            }
            
            //test2 get class inheritance,realization and dependency(complicated) relationship
            ArrayList<String> parentClasses = new ArrayList<String>() ;
            ArrayList<String> parentInterfaces = new ArrayList<String>() ;
            
            
            //get inheritance and interfaces
            List<ClassOrInterfaceDeclaration> classesOrInterfaces = unit.findAll(ClassOrInterfaceDeclaration.class);
            //System.out.println("unit  "+classesOrInterfaces);
            for(int j = 0;j < classesOrInterfaces.size(); j++) {
            	if(classesOrInterfaces.get(j).getImplementedTypes().size() != 0) {
            		NodeList<ClassOrInterfaceType> parentInterface = classesOrInterfaces.get(j).getImplementedTypes();
            		for(int k = 0;k < parentInterface.size(); k++) {
            			parentInterfaces.add(parentInterface.get(k).asString());
            		}
            		//System.out.println("parentInterface  "+ parentInterfaces);
            	}
            	if(classesOrInterfaces.get(j).getExtendedTypes().size() != 0) {
            		NodeList<ClassOrInterfaceType> parentClass = classesOrInterfaces.get(j).getExtendedTypes();
            		for(int k = 0;k < parentClass.size(); k++) {
            			parentClasses.add(parentClass.get(k).asString());
            		}
            		//System.out.println("parentClasses  "+ parentClasses);
            	}
            	
            }
          //System.out.println("parentInterface  "+ parentInterfaces);
          //System.out.println("parentClasses  "+ parentClasses);
            
            //Duplicate dependencies relationship removal
            List<String> dependenciesAfterDupRemove = new ArrayList<String>();    
            for (int i=0; i<dependenciesUses.size(); i++) {    
                if(!dependenciesAfterDupRemove.contains(dependenciesUses.get(i))) {    
                	dependenciesAfterDupRemove.add(dependenciesUses.get(i));    
                }    
            }
            
            
            object.put("dependencies",dependenciesAfterDupRemove);
            object.put("parentClasses",parentClasses);
            object.put("parentInterfaces",parentInterfaces);
            object.put("relation",relationArr);
            String stat = "";
            stat = "[" + className;
            if(primiArr.size() == 0 && methodStats.size() == 0) {
            	stat += "]";
            }else {
            	stat += "|"; 
            	for(int i = 0; i < primiArr.size(); i++) {
            		stat += primiArr.get(i);
            	}//add all attribute
            	if(primiArr.size()!=0) {
            		stat = stat.substring(0, stat.length() - 1);
            	}
            	stat += "|"; 
            	for(int i = 0; i < methodStats.size(); i++) {
            		stat += methodStats.get(i);
            	}//add all methods
            	stat += "]";
            }
            //System.out.println("stat "+stat);
            object.put("primiStat",stat);
            //System.out.println("object now"+object+"\n");
           
            return object;
             
        } catch (Exception e) {
        }
		return null;
    }
 
} 