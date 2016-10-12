package p4p7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BuildOrder {
	
	public static String findOrder (String[] projects, String[][] dependencies){
		HashMap<String, LinkedList<String>> graph = new HashMap<String, LinkedList<String>>();
		HashMap<String,Integer> incoming = new HashMap<String,Integer>();
		
		for(String s[]: dependencies){
			Integer i = incoming.get(s[0]);
			if(i==null)incoming.put(s[0], 1);
			else incoming.put(s[0],i+1);
			LinkedList ll = graph.get(s[1]);
			if(ll==null)graph.put(s[1],new LinkedList<String>());
			graph.get(s[1]).add(s[0]);
		}
		StringBuilder sb = new StringBuilder(projects.length);

		HashSet<String> tempMark = new HashSet<String>();
		HashSet<String> permMark = new HashSet<String>();
		while(!(permMark.size()>=projects.length)){
			for(String p:projects){
				try {
					visit(p, graph, tempMark, permMark,sb);
				} catch (Exception e) {
					return null;
				}
			}
		}
		return sb.reverse().toString();
		
		
	}
	
	public static void visit(String p,HashMap<String, LinkedList<String>> graph, HashSet<String> tempMark, HashSet<String> permMark, StringBuilder sb) throws Exception{
		if(tempMark.contains(p)) throw new Exception();
		if(!permMark.contains(p)){
			tempMark.add(p);
			if(graph.containsKey(p)){
				for(String n:graph.get(p)){
					visit(n, graph, tempMark, permMark, sb);
				}
			}
			permMark.add(p);
			tempMark.remove(p);
			sb.append(p);
		}
	}
	
	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		String[][] dependencies = {
				{"a", "b"},
				{"b", "c"},
				{"a", "c"},
				{"d", "e"},
				{"b", "d"},
				{"e", "f"},
				{"a", "f"},
				{"h", "i"},
				{"h", "j"},
				{"i", "j"},
				{"g", "j"},
				{"f", "a"}
				};
		String buildOrder = findOrder(projects, dependencies);
		if (buildOrder == null) {
			System.out.println("Circular Dependency.");
		} else {
			for (String s : buildOrder.split("")) {
				System.out.println(s);
			}
		}
}

}
