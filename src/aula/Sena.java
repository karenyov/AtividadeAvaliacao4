package aula;

import java.util.Arrays;
import java.util.List;

/**
 * @author Karen 19 de mar de 2018
 */
public class Sena {

	public List<Integer> getSena(Integer n) throws Exception {
		if (n < 6)
			throw new Exception("M�nimo 6");
		if (n > 12)
			throw new Exception("M�ximo 12");

		Integer[] lista = new Integer[n];
		for (int i = 0; i < lista.length; i++) {
			lista[i] = (int) (Math.random() * 60 + 1);
		}
		Arrays.sort(lista);
		return Arrays.asList(lista);
	}

}
