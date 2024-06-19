import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayListNamesWithCount {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("Aparna");
		names.add("Manju");
		names.add("Aparna");
		names.add("Aparna");
		names.add("Interview");
		Map<String, Long> namesCount = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		namesCount.forEach((name, count) -> System.out.println(name + ":" + count));
	}
}
