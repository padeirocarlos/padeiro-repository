package padeiro.exemplo.angular.utils;

public class StringUtils {

	public static String DOLLAR_SIMBLE = "%";

	public static String lowerCaseAndConact(String string) {

		if (string != null && !string.isEmpty()) {

			string = DOLLAR_SIMBLE + string + DOLLAR_SIMBLE;

			return string.toLowerCase();
		}
		return new String();
	}
}
