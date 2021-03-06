import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class JavaOptionalsWorkshop {
	public static void main(String[] args) {
		println("[hold value]");
		MyOptional<String> holdString = MyOptional.of("Hello, world!");
		println(holdString);

		println("[get() some value]");
		MyOptional<Integer> maybeNumber = MyOptional.of(123);
		println(maybeNumber.get());

		println("[empty()]");
		MyOptional<String> empty = MyOptional.empty();
		println(empty);

		println("[get() null]");
		MyOptional<String> noString = MyOptional.empty();
		println(noString.get());

		println("[isPresent()]");
		MyOptional<Integer> someNumberPresent = MyOptional.of(123);
		println(someNumberPresent.isPresent());

		println("[isPresent(), when null]");
		MyOptional<Integer> someNumberNotPresent = MyOptional.empty();
		println(someNumberNotPresent.isPresent());

		println("[.orElse()]");
		MyOptional<Integer> someNumberWithDefault = MyOptional.of(100);
		println(someNumberWithDefault.orElse(0));

		println("[.orElse(), when null]");
		MyOptional<Integer> noNumberWithDefault = MyOptional.empty();
		println(noNumberWithDefault.orElse(0));

		println("[do something ifPresent()]");
		MyOptional<Integer> doIfPresent = MyOptional.of(1024);
		doIfPresent.ifPresent(value -> println(value));

		println("[do something ifPresent(), when null]");
		MyOptional<Integer> doIfPresentWhenEmpty = MyOptional.empty();
		doIfPresentWhenEmpty.ifPresent(value -> println(value));

		println("[filter]");
		MyOptional<Integer> positiveNumber = MyOptional.of(100);
		int greaterThanZero = positiveNumber
				.filter(value -> (value > 0))
				.orElse(0);
		println(greaterThanZero);

		println("[filter, value present but filtered out]");
		MyOptional<Integer> negativeNumber = MyOptional.of(-10);
		int negativeNumberFiltered = negativeNumber
				.filter(value -> (value > 0))
				.orElse(0);
		println(negativeNumberFiltered);

		println("[filter, when null]");
		MyOptional<Integer> emptyNumber = MyOptional.empty();
		int noNumber = emptyNumber
				.filter(value -> (value > 0))
				.orElse(0);
		println(noNumber);

		println("[filter-chain]");
		MyOptional<Integer> primeNumber = MyOptional.of(97);
		int chainFiltered = primeNumber
				.filter(value -> (value > 0))
				.filter(value -> (value < 100))
				.filter(value -> (value % 2 != 0))
				.orElse(1);
		println(chainFiltered);

		println("[map]");
		MyOptional<String> maybeSomeNumber = MyOptional.of("1023");
		int number = maybeSomeNumber
				.map(value -> Integer.decode(value))
				.orElse(0);
		println(number);

		println("[map, when null]");
		MyOptional<String> couldBeNumberButNo = MyOptional.empty();
		int noNumberAtAll = couldBeNumberButNo
				.map(value -> Integer.decode(value))
				.orElse(0);
		println(noNumberAtAll);

		println("[map-chain]");
		MyOptional<String> someNumber = MyOptional.of("1023");
		String evenOrOdd = someNumber
				.map(string -> Integer.decode(string)) // to Integer
				.map(numeric -> numeric % 2 == 0) // to Boolean
				.map(isEven -> isEven? "EVEN" : "ODD") // to  String, "EVEN" or "ODD"
				.orElse("NO VALUE");
		println(evenOrOdd);
	}

	private static void println(Object valueToPrint) {
		System.out.println(valueToPrint);
	}
}
