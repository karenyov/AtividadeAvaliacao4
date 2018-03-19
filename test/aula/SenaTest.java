package aula;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Karen 19 de mar de 2018
 */
public class SenaTest {

	private Sena sena;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		sena = new Sena();
	}

	/**
	 * a) getSena(6) retorna um array com 6 elementos. Use o m�todo hasSize da
	 * classe IsCollectionWithSize;
	 * 
	 * @throws Exception
	 */
	@Test
	public void exercA() throws Exception {
		assertThat(sena.getSena(6), hasSize(6));
	}

	/**
	 * b) getSena(10) retorna um array onde cada elemento possui valor no
	 * intervalo [1,60]. Para fazer esse teste ser� necess�rio combinar os
	 * m�todos everyItem (classe CoreMatchers), allOf, greaterThanOrEqualTo e
	 * lessThanOrEqualTo da classe Matchers;
	 * 
	 * @throws Exception
	 */
	@Test
	public void exercB() throws Exception {
		assertThat(sena.getSena(10), everyItem(not(allOf(greaterThanOrEqualTo(1), greaterThanOrEqualTo(60)))));
	}

	/**
	 * c) getSena(10) retorna um array onde todos os elementos est�o ordenados.
	 * Ser� necess�rio criar um m�todo para comparar os elementos usando uma
	 * implementa��o da classe abstrata TypeSafeMatcher (
	 * https://junit.org/junit4/javadoc/4.12/org/hamcrest/TypeSafeMatcher.html),
	 * que por usa vez herda a classe abstrata BaseMatcher
	 * (https://junit.org/junit4/javadoc/4.12/org/hamcrest/BaseMatcher.html) e
	 * esta implementa a interface Matcher;
	 */
	@Test
	public void exercC() throws Exception {
		assertThat(sena.getSena(10), ordenado());
	}

	private TypeSafeMatcher<List<Integer>> ordenado() {
		return new TypeSafeMatcher<List<Integer>>() {

			@Override
			protected boolean matchesSafely(List<Integer> lista) {
				for (int i = 0; i < lista.size() - 1; i++) {
					if (lista.get(i) <= lista.get(i + 1))
						return true;
				}
				return false;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("describe the error has you like more");
			}
		};
	}

	/**
	 * d) getSena(10) retorna um array sem elementos duplicados. Ser� necess�rio
	 * criar um m�todo para comparar os elementos usando uma implementa��o da
	 * classe abstrata TypeSafeMatcher;
	 * 
	 * @throws Exception
	 */
	@Test
	public void exercD() throws Exception {
		assertThat(sena.getSena(10), duplicado());
	}
	
	private TypeSafeMatcher<List<Integer>> duplicado() {
		return new TypeSafeMatcher<List<Integer>>() {

			@Override
			protected boolean matchesSafely(List<Integer> lista) {
				for (int i = 0; i < lista.size() - 1; i++) {
					if (lista.get(i) == lista.get(i + 1))
						return true;
				}
				return false;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("describe the error has you like more");
			}
		};
	}

	/**
	 * e) getSena(null) neste caso o indicado seria usar o atributo
	 * expected=Exception.class na anota��o @Test. Por�m aqui ser� obrigat�rio
	 * usar uma @Rule para ExpectedException;
	 * 
	 * @throws Exception
	 */
	@Test
	public void exercE() throws Exception {
		thrown.expect(Exception.class);
		sena.getSena(null);
	}

	/**
	 * f) getSena(5) use uma @Rule para testar se a mensagem da exce��o possui o
	 * texto "M�nimo 6";
	 * 
	 * @throws Exception
	 */
	@Test
	public void exercF() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("M�nimo 6");
		sena.getSena(5);
	}

	/**
	 * g) getSena(12) use uma @Rule para testar se a mensagem da exce��o possui
	 * o texto "M�ximo 12";
	 * 
	 * @throws Exception
	 */
	@Test
	public void exercG() throws Exception {
		thrown.expect(Exception.class);
		thrown.expectMessage("M�ximo 12");
		sena.getSena(13);
	}
}
