package Model;

public class GlobalModel {
	public static int globalTypeUser = - 1;
	public static String globalIDUser = "";
	
	public GlobalModel() {
	}
	
	public static void setglobalTypeUser(int type, String id) {
		globalTypeUser = type;
		globalIDUser = id;
	}
}
