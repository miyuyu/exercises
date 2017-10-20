import java.util.*;
import java.lang.String;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.beans.IntrospectionException;

import javax.sql.rowset.FilteredRowSet;
import javax.swing.JFrame;
import javax.swing.text.DateFormatter;

import org.omg.CORBA.PUBLIC_MEMBER;
public class Test {
	/**
	 * 
	 * @param index
	 * @param obj
	 */
	public static void print(int index, Object obj) {
		System.out.print(String.format("{%d}, %s", index, obj.toString()));
	}
	
	public static void demoOperation() {
		print(1, 5 / 2);
		print(1, 5 + 2);
		print(1, 5 * 2);
		print(1, 5 - 2);
		print(1, 5 << 2);
		print(1, 5 >> 2);
		print(1, 5 & 2);
	}
	
	public static void demoControlFlow() {
		int score = 60;
		if(score > 80) {
			print(1, "A");
		}
		else {
			print(2, "B");
		}
		
		String grade = "B";
		switch(grade) {
			case "A":
				print(4, "score >80");
				break;
			case "B":
				print(5, "(60, 80");
				break;
			default:
				print(6, "0.60");
		}
		
		String str = "hello";
		for(char c : str.toCharArray()) {
			print(9, c);
		}
		
	}
	
	public static void demoList() {
		List<String> strListA = new ArrayList<String>();
		for(int i = 0; i < 4; i++) {
			strListA.add(String.valueOf(i));
		}
		List<String> strListB = new ArrayList<String>();
		for(int i = 0; i < 4; i++) {
			strListA.add(String.valueOf(i*i));
		}
		strListA.addAll(strListB);
		print(2,  strListA);
		strListA.remove(0);
		strListA.remove(String.valueOf(1));
		print(3, strListA.get(1));
		
		Collections.sort(strListA, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		
		print(4, strListA);
		Collections.reverse(strListA);
	}
	
	public static void demoSet() {
		Set<String> strSet = new HashSet<String>();
		for(int i = 0; i <3; i++) {
			strSet.add(String.valueOf(i));
			strSet.add(String.valueOf(i));
			strSet.add(String.valueOf(i));
		}
		print(1, strSet);
		print(2, strSet.contains(4));
		strSet.addAll(Arrays.asList(new String[]{"A","B","C"}));
		print(3, strSet);
		for(String value: strSet) {
			print(5, value);
		}
		print(6, strSet.isEmpty());
		print(7, strSet.size());
	}
	
	public static void demoKeyValue() {
		Map<String, String> map = new HashMap<>();
		for(int i = 0; i < 4; i++) {
			map.put(String.valueOf(i), String.valueOf(i*i));
		}
		print(1, map);
		
		for(Map.Entry<String, String> entry : map.entrySet()) {
			print(2, entry.getKey() + ":" +entry.getValue());
		}
		
		print(3, map.keySet());
		print(4, map.values());
		print(5, map.containsKey("2"));
		print(6, map.get("1"));
		map.replace("1", "A");
		print(7, map);
	}
	
	public static void demoCommon() {
		Random random = new Random();
		random.setSeed(1);
		for(int i = 0; i < 4; i++) {
			print(1, random.nextInt(100));;
		}
		
		List<Integer> array = Arrays.asList(new Integer[] {1, 2, 3, 4, 5});
		print(2, array);
		Collections.shuffle(array);
		print(3, array);
		
		Date date = new Date();
		print(4, date);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		print(5, df.format(date));
		
		print(6, DateFormat.getDateInstance(DateFormat.FULL).format(date));
		
		print(7, UUID.randomUUID());
	}
	public static void main(String[] args) {
		//demoKeyValue();
		demoCommon();
	}

}
