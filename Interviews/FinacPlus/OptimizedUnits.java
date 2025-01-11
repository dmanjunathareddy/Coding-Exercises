
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OptimizedUnits {

	public static void main(String[] args) {
		int[] availableUnits = { 1, 2, 5, 10, 20, 50 };
		int maxValue = 99;
		int numUnits = 6;

		List<int[]> combinations = generateCombinations(availableUnits, numUnits);

		Map.Entry<int[], Double> bestSet = combinations.stream()
				
				.map(unitSet -> new AbstractMap.SimpleEntry<>(unitSet, calculateAverageUnits(unitSet, maxValue)))
				.min(Comparator.comparingDouble(Map.Entry::getValue))
				.orElseThrow(() -> new RuntimeException("Combinations not found"));

		System.out.println("Optimized set: " + Arrays.toString(bestSet.getKey()));
		
		System.out.printf("Average Units Used:"+ bestSet.getValue());
	}

	private static List<int[]> generateCombinations(int[] availableUnits, int numUnits) {
		List<int[]> combinations = new ArrayList<>();
		generateCombinationsHelper(availableUnits, numUnits, 0, new int[numUnits], 0, combinations);
		return combinations;
	}

	private static void generateCombinationsHelper(int[] availableUnits, int numUnits, int start, int[] current,
			int depth, List<int[]> combinations) {
		if (depth == numUnits) {
			combinations.add(Arrays.copyOf(current, numUnits));
			return;
		}
		IntStream.range(start, availableUnits.length).forEach(i -> {
			current[depth] = availableUnits[i];
			generateCombinationsHelper(availableUnits, numUnits, i, current, depth + 1, combinations);
		});
	}

	private static double calculateAverageUnits(int[] unitSet, int maxValue) {
		return IntStream.rangeClosed(1, maxValue).map(value -> minUnits(value, unitSet)).average()
				.orElse(Double.MAX_VALUE);
	}

	private static int minUnits(int value, int[] unitSet) {
		int[] dp = new int[value + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int unit : unitSet) {
			for (int i = unit; i <= value; i++) {
				if (dp[i - unit] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - unit] + 1);
				}
			}
		}

		return dp[value];
	}
}