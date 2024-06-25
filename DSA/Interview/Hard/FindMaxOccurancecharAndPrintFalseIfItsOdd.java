import java.util.HashMap;
import java.util.Map;

public class FindMaxOccurancecharAndPrintFalseIfItsOdd {

	public static void main(String args[]) {
		String str = "aaavvvvbbb";
		char maxChar = findMaxOccurancechar(str);
		System.out.println("char with max occurance: " + maxChar);
		boolean isEvenMax = checkEvenOddMaxOccurance(str);
		System.out.println(isEvenMax);
	}

	private static char findMaxOccurancechar(String str) {
		Map<Character, Integer> charSequence = new HashMap<>();
		for (char c : str.toCharArray()) {
			charSequence.put(c, charSequence.getOrDefault(c, 0) + 1);
		}
		int maxCount = 0;
		char maxChar = '\0';
		for (Map.Entry<Character, Integer> entry : charSequence.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxChar = entry.getKey();
			}
		}
		return maxChar;
	}

	private static boolean checkEvenOddMaxOccurance(String str) {
		Map<Character, Integer> charCount = new HashMap<>();
		for (char c : str.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		int maxOccurrence = 0;
		for (int count : charCount.values()) {
			if (count > maxOccurrence) {
				maxOccurrence = count;
			}
		}

		return maxOccurrence % 2 == 0;
	}
}
