package genericLib;

import java.util.Random;

public class JavaUtility {
	public static int getRandomnumber() {
		Random ran = new Random();
		int num = ran.nextInt();
		return num;
	}

}
