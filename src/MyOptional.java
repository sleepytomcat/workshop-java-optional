import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyOptional<T> {
	public static <U> MyOptional<U> of(U value) {
		return new MyOptional<U>(value);
	}

	@Override
	public String toString() {
		return getClass().getName()
				+ '@'
				+ Integer.toHexString(hashCode())
				+ " holds "
				+ Objects.toString(value);
	}

	public T get() {
		return value;
	}

	public static <U> MyOptional<U> empty() {
		return new MyOptional<U>();
	}

	public boolean isPresent() {
		return value != null;
	}

	public T orElse(T defaultValue) {
		if (value != null)
			return value;
		else
			return defaultValue;
	}

	public void ifPresent(Consumer<T> consumer) {
		if (value != null)
			consumer.accept(value);
	}

	public MyOptional<T> filter (Predicate<T> filter) {
		if (value == null)
			return MyOptional.empty();
		else if (!filter.test(value))
			return MyOptional.empty();
		else
			return MyOptional.of(value);
	}

	public <U> MyOptional<U> map(Function<T, U> mapper) {
		if (value == null)
			return MyOptional.empty();
		else
			return MyOptional.of(mapper.apply(value));
	}

	private MyOptional(T value) {
		this.value = value;
	}

	private MyOptional() {
		value = null;
	}

	private T value;
}
