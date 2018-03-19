package aula;

import java.util.List;
import org.hamcrest.Description;

/**
 * @author Karen 19 de mar de 2018
 */
public abstract class TypeSafeMatcher<T> extends BaseMatcher<T> {

	private List<Integer> lista;

	@Override
	public void describeTo(Description desc) {
		desc.appendText("Compara os elementos da lista");
	}
	
	protected boolean comparar(List<Integer> listaRecebida) {
		
		return listaRecebida == lista;
	 }

}
