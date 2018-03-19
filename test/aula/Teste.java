package aula;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author Karen 19 de mar de 2018
 */

public class Teste {
	@Test
	public void isTest() {
		assertThat(0, is(0));
	}

	@Test
	public void notTest() {
		assertThat(2, not(1));
	}

	@Test
	public void greaterThanTest() {
		assertThat(5, greaterThan(2));
	}

	@Test
	public void eitherTest() {
		assertThat((int) (Math.random() * 3), either(is(0)).or(is(1)).or(is(2)));
	}

	@Test
	public void containsStringTest() {
		assertThat("A casa é bela", containsString("é"));
	}

	@Test
	public void anyOfTest1() {
		assertThat("A casa é bela", anyOf(containsString("é"), containsString("ã")));
	}

	@Test
	public void anyOfTest2() {
		assertThat((int) (Math.random() * 3), anyOf(equalTo(0), equalTo(1), equalTo(2)));
	}

	@Test
	public void allOfTest() {
		assertThat("A casa é bela", not(allOf(containsString("é"), containsString("ã"))));
	}

	@Test
	public void instanceOfTest() {
		assertThat(12.5, instanceOf(java.lang.Number.class));

	}

	@Test
	public void hasSizeTest() {
		java.util.List<Integer> lista = java.util.Arrays.asList(5, 2, 4);
		assertThat(lista, hasSize(3));
	}

	@Test
	public void isInTest() {
		java.util.List<Integer> lista = java.util.Arrays.asList(5, 2, 4);
		assertThat(2, isIn(lista));
	}

	@Test
	public void everyItemTest() {
		java.util.List<Integer> lista = java.util.Arrays.asList(5, 2, 4);
		assertThat(lista, everyItem(greaterThan(1)));
	}

	@Test
	public void segundoCaracterTest() {
		assertThat("abcde", segundoCaracter('b'));
	}

	@Test
	public void anyCaracterTest() {
		assertThat("abcde", anyCaracter('e', 4));
	}

	/* matcher para testar o 2o caracter da string */
	private TypeSafeMatcher<String> segundoCaracter(char comparacao) {
		return new TypeSafeMatcher<String>() {
			protected boolean matchesSafely(String str) {
				if (str.length() < 2)
					return false;
				if (str.charAt(1) != comparacao)
					return false;
				return true;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("describe the error has you like more");
			}
		};
	}

	/* matcher para testar o nth caracter da string */
	private TypeSafeMatcher<String> anyCaracter(char comparacao, int index) {
		return new TypeSafeMatcher<String>() {
			protected boolean matchesSafely(String str) {
				if (str.length() < index + 1)
					return false;
				if (str.charAt(index) != comparacao)
					return false;
				return true;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("describe the error has you like more");
			}
		};
	}
}