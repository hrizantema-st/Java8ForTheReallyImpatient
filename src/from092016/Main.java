package from092016;

import java.util.HashMap;
import java.util.Map;

public class Main {

	
	public static void maxDistance(final String arg) {
		Map<Character, Pair<Integer, Integer>> map = new HashMap<>();
		for(int i = 0; i < arg.length(); i++) {
			if (map.containsKey(arg.charAt(i))) {
				Pair<Integer, Integer> p = map.get(arg.charAt(i));
				p.setRight(i);
				map.put(arg.charAt(i), p);
			}
			else {
				map.put(arg.charAt(i), new Pair<>(i, i));
			}
		}
		Character key = ' ';
		Integer min = 0;
		for (Map.Entry<Character, Pair<Integer, Integer>> entry : map.entrySet())
		{
		   Integer sub = entry.getValue().getRight() - entry.getValue().getLeft();
		   if(sub > min) {
			   min = sub;
			   key = entry.getKey();
		   }
		}
		System.out.println("[" + map.get(key).getLeft() + ", " + map.get(key).getRight() + "]");
	}
	
	public static void main(String[] args) {
		maxDistance("this is just a simple example");

	}

}
