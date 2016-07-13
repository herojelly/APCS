import java.util.ArrayList;

public interface Shorty {
	public static ArrayList<String> next(String s, Dijkstra d) {
		ArrayList<String> retval = new ArrayList<String>();
		retval.add(d.prev.get(d.nodes.indexOf(s)));
		while (d.prev.get(d.nodes.indexOf(retval.get(retval.size() - 1))) != null) {
			retval.add(d.prev.get(d.nodes.indexOf(retval.get(retval.size() - 1))));
		}
		retval.add(s);
		return retval;
	}

}
