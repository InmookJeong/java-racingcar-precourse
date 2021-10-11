package utils;

public class NumberUtil {

	/**
	 * 전달받은 값이 1~9 사이의 숫자인지 확인
	 * @param randomNo
	 * @return true/false
	 */
	public static boolean isMinToMaxNumeric(int randomNo, int min, int max) {
		if(randomNo >= min && randomNo <= max) {
			return true;
		}
		return false;
	}

	public static boolean isMoreThanMin(int inputNumber, int min) {
		if(inputNumber > min) {
			return true;
		}
		return false;
	}
}
