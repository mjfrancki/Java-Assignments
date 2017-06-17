import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import java.net.URLConnection;
import java.util.regex.Matcher;


public class WebStats {

  String urlRegex = "(http|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
  String tagRegex = "<[^!/][^>]*>";
  
    public Pattern urlPattern = Pattern.compile(urlRegex);
    public Pattern tagPattern = Pattern.compile(tagRegex);
    
    
       public static void main(String[] args) {
		   
		//String url = "http://scs.ryerson.ca/jpanar/";
		 
		 //System.out.print(getHTML(url));
		 
		 
		 //for( String tag: getURLs(url) ){
		//	 System.out.println(tag);
	   // }
		 
		// pageInfoPrinter(url);
		
		crawler(20,3,"http://scs.ryerson.ca/jpanar/");
		
		}
       

public static int crawler(int pages, int pathLength, String initialPage){
Map<String, Integer> TotaltagCountMap = new HashMap<String, Integer>();
String startUrl = initialPage;
int maxPages = pages;
int maxPathLength = pathLength;

int pageCount =0 ;

ArrayList<String> urls = new ArrayList<String>();
ArrayList<String> alreadyVisited = new ArrayList<String>();
ArrayList<String> newLinks = new ArrayList<String>();
urls.add(initialPage);

for(int i = 0;i < maxPathLength ;i++){	
		System.out.println("----------- Path " + (i+1) + "----------");
		for(String url : urls){
			
			if (pageCount >= maxPages){
			System.out.println("***************Max Number of pages reached*****************");
			
			System.out.println("******************Tottal tag count*************************");

			
			mapPrinter(TotaltagCountMap);
			
			return 0; 
			}
			
		try{	
			if(!alreadyVisited.contains(url)){
			
			pageInfoPrinter(url);
			TotaltagCountMap = addMaps(TotaltagCountMap, tagCounter(getTags(url)));
			}
			
	
				
			
			for(String link : getURLs(url) ){
					newLinks.add(link);
			}
		
		
		    alreadyVisited.add(url);
		
	   }
	   catch(NoSuchElementException | NullPointerException e){
		  System.out.println("**************something went wrong with this link!***************");
		 
		 //urls.remove(url);
		 // e.printStackTrace();
		   }
		   
		   pageCount++ ;
	   }
		
		for(String link: newLinks){
			urls.add(link);
		}
		
	}


return 0;
}  


     
       
       
public static String getHTML(String url){
	
	

String content = null;
URLConnection connection = null;
try {
  connection =  new URL( url ).openConnection();
  Scanner scanner = new Scanner(connection.getInputStream());
  scanner.useDelimiter("\\Z");
  content = scanner.next();
}catch ( Exception ex ) {
    //ex.printStackTrace();
}
return content;

}

public static ArrayList<String> getTags(String url){


String tagRegex = "<[^!/][^>]*>";
Pattern tagPattern = Pattern.compile(tagRegex);

ArrayList<String> tags = new ArrayList<String>();

String html = getHTML(url) ;
Matcher tagMatcher = tagPattern.matcher(html);

while(tagMatcher.find()){
	String tag = tagMatcher.group();
	//System.out.println(tag);
	tags.add(tag.toUpperCase());

}
return tagsFormated(tags);
}

public static ArrayList<String> tagsFormated(ArrayList<String> tags){

ArrayList<String> tagsFormated = new ArrayList<String>();

for(String value : tags){
	if (value.contains (" ") && ( (value.substring(1,value.indexOf(" "))).length() < 10) ){
		tagsFormated.add(value.substring(1,value.indexOf(" "))) ;
	}
else if((value.substring(1,value.length()-1).length() < 10) ) {
	tagsFormated.add(value.substring(1,value.length()-1)) ;
}
}


return tagsFormated;

}

public static Map<String, Integer> tagCounter(ArrayList<String> tags){
	
	
	ArrayList<String> tagsNoRepeat = new ArrayList<String>();
	Map<String, Integer> tagCountMap = new HashMap<String, Integer>();
	
	for (String value : tags) {
	   
    if( !tagsNoRepeat.contains(value) )
	   
	   tagsNoRepeat.add(value);
	   
    }
    
    for (String value :  tagsNoRepeat) {
	   
	 
	 tagCountMap.put(value, Collections.frequency(tags, value));
	   
    }
	
	return tagCountMap;


}

public static Map<String, Integer> addMaps(Map<String, Integer> mapA, Map<String, Integer> mapB){
Map<String, Integer> mapSum = mapA;



for(Map.Entry<String, Integer> entry : mapB.entrySet() ){
	
	if(!mapSum.containsKey( entry.getKey() ) ){
		//mapSum.add( entry.getKey() );
		mapSum.put( entry.getKey(), entry.getValue());
		}
	if(mapSum.containsKey( entry.getKey()) ){
		
		mapSum.put( entry.getKey(), entry.getValue()+ mapSum.get( entry.getKey() ) );
		}  
	
}

return mapSum;

}

public static ArrayList<String> getATags(String url){
	
String tagRegex = "(?i)<a([^>]+)>(.+?)</a>";
Pattern tagPattern = Pattern.compile(tagRegex);

ArrayList<String> tags = new ArrayList<String>();

String html = getHTML(url) ;
Matcher tagMatcher = tagPattern.matcher(html);

while(tagMatcher.find()){
	String tag = tagMatcher.group();
	//System.out.println(tag);
	tags.add(tag);

}
return tags;
}
	
public static ArrayList<String> getURLs(String url){
	ArrayList<String> links = new ArrayList<String>();
	String urlRegex = "(http|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?";
	Pattern urlPattern = Pattern.compile(urlRegex);
	Matcher urlMatcher;
	
	for(String aTag : getATags(url)){
		
		 urlMatcher = urlPattern.matcher(aTag);
		
		if(urlMatcher.find())
		links.add(urlMatcher.group());
		}
	return links;
	}



public static void pageInfoPrinter(String url){
System.out.println(url);

mapPrinter(tagCounter( getTags(url)  ) );

}

public static void mapPrinter(Map<String, Integer> map){
	
	for(Object objname : map.keySet()) {
		System.out.println(objname +" : "+map.get(objname));
   
 }
	
}



}
