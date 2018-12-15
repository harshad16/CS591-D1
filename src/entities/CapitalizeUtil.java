package src.entities;

public class CapitalizeUtil {
		public static String captilize(String s) {
			if(s != null && !s.equals("")) {
				char toUpper = Character.toUpperCase(s.charAt(0));
				return toUpper + s.substring(1);
			}
			return s;
		}
}
