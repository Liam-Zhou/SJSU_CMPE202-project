 
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File; 
import java.io.FileOutputStream;
import java.io.IOException; 
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList; 
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject; 



public class test_parser {
	public static void main(String[] args) throws Exception {
		
//		System.out.println(new File(".").getAbsolutePath());//check current path
		List<String> classNameList = new ArrayList(); 
		JSONObject classes1 = new JSONObject(); 
		String yuml = ""; 
		//File f1 = new File("./tests/test1");
		
		File f1 = new File(args[0]);
		
		//File f1 = new File("../starbucks/src/main/java/starbucks");
		
		for(File file : f1.listFiles()){
            if(file.isDirectory()){
            	
            }
            if(file.isFile() && file.getName().endsWith("java")){
            	String fileName = file.getName();
            	String[] strArr = fileName.split("\\.");
            	String className = strArr[0];
            	
            	if(className.equals("Jparser")||className.equals("test_parser")) {
            		
            	}else {
            		classNameList.add(className);
                	//if(Jparser.parser(file) != null) {
                		classes1.put(className, Jparser.parser(file));
                	//}
            	}
            	
            }
        }
		//System.out.println("classes1 up "+classes1);
		for(int i = 0; i < classNameList.size(); i++) {
			String className = classNameList.get(i);
			//System.out.println("className "+className);
			JSONObject currentClass = (JSONObject) classes1.get(className);
			//search association relationship
			//System.out.println("currentClass "+currentClass);
			JSONObject currentRelation = (JSONObject) currentClass.get("relation");//class association relationship
			for(int k = 0; k < classNameList.size(); k++) {//most for test1 : attribute and class association relation
				String classNameinRelation = classNameList.get(k);
				
				if(currentRelation.containsKey(classNameinRelation)) {
					JSONObject classInrelation = (JSONObject) currentRelation.get(classNameinRelation);
					if(!(boolean) classInrelation.get("isChecked")) {
					classInrelation.replace("isChecked", true);
					JSONObject relationClass = (JSONObject) classes1.get(classNameinRelation);//relation class
					JSONObject relationClasscurrentRelation = (JSONObject) relationClass.get("relation");//find previous class in this relation class

					JSONObject classInRelationClassRelation = (JSONObject) relationClasscurrentRelation.get(className);
					//System.out.println("classInRelationClassRelation"+classInRelationClassRelation);
					if(classInRelationClassRelation == null) {
						yuml += currentClass.get("primiStat");
						yuml += "1-";
						boolean isSingle2 = (boolean) classInrelation.get("isSingle");
						if(isSingle2) {
							yuml += "1";
						}else {
							yuml += "*";
						}
						yuml += relationClass.get("primiStat")+",";
					}else {
						
					
					if(!(boolean) classInRelationClassRelation.get("isChecked")) {
						classInRelationClassRelation.replace("isChecked", true);
						yuml += currentClass.get("primiStat");
						boolean isSingle = (boolean) classInRelationClassRelation.get("isSingle");
							if(isSingle) {
								yuml += "1-";
							}else {
								yuml += "*-";
							}
						boolean isSingle2 = (boolean) classInrelation.get("isSingle");
							if(isSingle2) {
								yuml += "1";
							}else {
								yuml += "*";
							}
							yuml += relationClass.get("primiStat")+",";
							
					}else {
						continue;
					}
					}
					}
					
				}
			}
			//search parent interfaces
			ArrayList <String> interfaces = (ArrayList<String>) currentClass.get("parentInterfaces");
			for (int j = 0;j < interfaces.size();j ++) {
				String interfaceName = interfaces.get(j);
				//System.out.println("interfaceClassinterfaceClassinterfaceClassinterfaceClassinterfaceClassinterfaceClass\n  "+interfaceName);
				
				JSONObject interfaceClass = (JSONObject) classes1.get(interfaceName);
				String interfacePrimiStat = (String) interfaceClass.get("primiStat");
				interfacePrimiStat = interfacePrimiStat.substring(1,interfacePrimiStat.length());
				yuml += currentClass.get("primiStat") + "-.-^" + "[<<interface>>;"+interfacePrimiStat+",";
			}
			//search parent classes
			ArrayList <String> parentClasses = (ArrayList<String>) currentClass.get("parentClasses");
			for (int j = 0;j < parentClasses.size();j ++) {
				String parentClassName = parentClasses.get(j);
				JSONObject parentClass = (JSONObject) classes1.get(parentClassName);
				yuml += currentClass.get("primiStat") + "-^" +parentClass.get("primiStat")+",";
			}
			//search dependencies relationship
			ArrayList <String> dependencies = (ArrayList<String>) currentClass.get("dependencies");
			for (int j = 0;j < dependencies.size();j ++) {
				String dependencyName = dependencies.get(j);
				yuml += currentClass.get("primiStat") + "uses -.->" + "["+dependencyName+"],";
			}
			
		}
		//System.out.println("classNameList "+ classNameList); 
		//System.out.println("classes1 "+ classes1);
		
		
		if(yuml.split("\\,").length > 80) {
			String syuml = "";
			for(int i = 0;i < 82;i++) {//10 && 82
				syuml +=  yuml.split("\\,")[i]+",";
			}
			yuml = syuml;
		}
         
		//System.out.println("yuml "+ yuml);
		String picName = args[1];
		//String picName = "Starbucks";
		downloadPicture(yuml,picName);
		
	}
	 
	
	 private static void downloadPicture(String yuml,String picName){
		  
	        URL url = null;

	        try {
	        	//sent post request to get picture code
	        	CloseableHttpClient client = HttpClients.createDefault();
	        	HttpPost post = new HttpPost("https://yuml.me/diagram/scruffy/class/");
	        	post.setHeader("Content-Type","application/json;charset=utf-8");
	        	
	        	JSONObject obj = new JSONObject(); 
	        	obj.put("dsl_text", yuml);
	        	StringEntity entity = new StringEntity(obj.toString(),"utf-8");
	            entity.setContentEncoding("UTF-8");
	            entity.setContentType("application/json");
	            post.setEntity(entity);
	            System.out.println("getting the picture code from yuml....");
	            HttpResponse response = client.execute(post);
	            String str = EntityUtils.toString(response.getEntity());
	            String picCode = str.split("\\.")[0];
	            
	            
	            System.out.println("successfully get the picture code!!!  "+picCode);
	            
	            //sent get request
	            String urlList = "https://yuml.me/diagram/scruffy/class/"+picCode+".png";
	            url = new URL(urlList);
	            DataInputStream dataInputStream = new DataInputStream(url.openStream());

	            String imageName =  "./"+picName+".png";

	            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
	            ByteArrayOutputStream output = new ByteArrayOutputStream();

	            byte[] buffer = new byte[1024];
	            int length;
	            System.out.println("downloading the picture....");
	            while ((length = dataInputStream.read(buffer)) > 0) {
	            	 output.write(buffer, 0, length);
		         }
	            
		         byte[] context=output.toByteArray();
		         fileOutputStream.write(output.toByteArray());
		         dataInputStream.close();
		         fileOutputStream.close();
		         System.out.println("download successfully!!! \n"+"picture in here: ./"+picName+".png");
		     } catch (MalformedURLException e) {
		         e.printStackTrace();
		     } catch (IOException e) {
		         e.printStackTrace();
		     }
		 }
	 }


	

