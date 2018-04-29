package trabalho1_ia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InteligenciaArtificial {

	//Executa o A*
	public static ResultadosTeste aEstrela() {
		Long tempo = 0L;
		Long numeroPassos = 0L;
		Tabuleiro tabuleiro = new Tabuleiro();
		
		//Aqui fica a lógica do A*
		// link de um pseudocodigo, parece muito bom, da pra usar de base no desenvolvimento
		//https://en.wikipedia.org/wiki/A*_search_algorith
		
		ResultadosTeste resultados = new ResultadosTeste(TipoAlgoritmo.A_ESTRELA, tempo, numeroPassos, tabuleiro);
		return resultados;
	}
	
	//Executa o SMA*
	public static ResultadosTeste smaEstrela() {
		Long tempo = 0L;
		Long numeroPassos = 0L;
		Tabuleiro tabuleiro = new Tabuleiro();
		
		//Aqui fica a lógica do SMA*
		// link de um pseudocodigo parece muito bom, da pra usar de base também
		// https://en.wikipedia.org/wiki/SMA*
		
		ResultadosTeste resultados = new ResultadosTeste(TipoAlgoritmo.SMA_ESTRELA, tempo, numeroPassos, tabuleiro);
		return resultados;
	}
	
	//aplica a heuristica pra selecionar o melhor movimento
	private static ArrayList<Tabuleiro> getMelhorMovimento(Tabuleiro tabuleiro) {
		//Retorna todos os movimentos validos a partir da posicao atual
		ArrayList<Tabuleiro> melhoresMovimentos = tabuleiro.getMovimentosValidos();
		
		//Itera sobre os movimentos validos, calculando o n�mero de
		//movimentos sucessores de cada um
		for(Tabuleiro tab : melhoresMovimentos) {
			tab.getMovimentosValidos();
		}		
		
		//Ordena a lista de movimentos validos. Para isso eh usado o criterio do compareTo
		//que coloca primeiro aqueles que tem menor quantidade de movimentos sucessores
		//conforme determinado pela heuristica de Warnsdorff
		Collections.sort(melhoresMovimentos);
		
		return melhoresMovimentos;
	}
}
