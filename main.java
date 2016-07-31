package kata;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class main {

	public static void main(String[] args) {	
		printNumber();

	}
	
	public static void printNumber(){
		int begin=1;
		int end=100;
		
		HashMap<Integer, String> toReplace = new HashMap<Integer, String>();
		toReplace.put(3, "Foo");
		toReplace.put(5, "Bar");
		toReplace.put(7, "Qix");
		
		while(begin<=end)
		{
			StringBuffer result = new StringBuffer();
			
			Iterator<Entry<Integer, String>> iter = toReplace.entrySet().iterator();
			
			/*
			 * divisible by 3,5,7 or not 
			 */
			while (iter.hasNext()) {
	
				Map.Entry<Integer, String> entry = iter.next();
				if(begin%entry.getKey()==0)
					result.append(entry.getValue());		
			}
			
			/*
			 * contain 3,5,7 or not
			 */
			if(begin<=9){
				if(toReplace.containsKey(begin))
					result.append(toReplace.get(begin));				
			}else if((9<begin)&&(begin<100)){
				if(toReplace.containsKey(begin/10))
					result.append(toReplace.get(begin/10));
							
				if(toReplace.containsKey(begin%10))
					result.append(toReplace.get(begin%10));				
			}else{				
				if(toReplace.containsKey(begin/100))
					result.append(toReplace.get(begin/100));
								
				int rest = begin%100;				
				if(toReplace.containsKey(rest/10))
					result.append(toReplace.get(rest/10));
							
				if(toReplace.containsKey(rest%10))
					result.append(toReplace.get(rest%10));			
			}
			
			if(result.length()==0)
				result.append(begin);
			System.out.println(result.toString());
			begin++;
		}		
		
	}

}
