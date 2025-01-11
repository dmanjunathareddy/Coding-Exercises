import java.util.stream.Collectors;

public class SpecialCipher {

	public static String specialCipher(String input, int rotation) {
		String caesarCiphered = input.chars().mapToObj(c -> {
			if (Character.isLetter(c)) {
				char base = Character.isUpperCase(c) ? 'A' : 'a';
				return (char) ((c - base + rotation) % 26 + base);
			} else {
				return (char) c;
			}
		}).map(String::valueOf).collect(Collectors.joining());

		StringBuilder rleEncoded = new StringBuilder();
		int count = 1;
		char[] chars = caesarCiphered.toCharArray();

		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == chars[i - 1]) {
				count++;
			} else {
				rleEncoded.append(chars[i - 1]);
				if (count > 1)
					rleEncoded.append(count);
				count = 1;
			}
		}

		rleEncoded.append(chars[chars.length - 1]);
		if (count > 1)
			rleEncoded.append(count);

		return rleEncoded.toString();
	}

	public static void main(String[] args) {
		String input = "AABCCC";
		int rotation = 3;
		String result = specialCipher(input, rotation);
		System.out.println(result);
	}
}
