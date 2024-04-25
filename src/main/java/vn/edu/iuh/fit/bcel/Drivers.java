package vn.edu.iuh.fit.bcel;

import java.io.File;
import java.util.List;

public class Drivers {
	public static void main(String[] args) throws Exception {
		LCOM4Calculation calculation = new LCOM4Calculation();
		String url = "classes/ConnectDB.class";
		File file = new File(url);
		List<Group> lst = calculation.loadGroups(file);
		lst.forEach(System.out::println);
		int lcom4 = calculation.loadGroups(file).size();
		System.out.printf("LCOM4 of class %s is %d\n", file.getName(), lcom4);
	}
}
