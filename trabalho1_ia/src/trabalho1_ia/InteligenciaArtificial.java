package trabalho1_ia;

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
	
	//aplica a heurística pra selecionar o melhor movimento
	private static Tabuleiro getMelhorMovimento(List<Tabuleiro> movimentosValidos) {
		return movimentosValidos.get(0);
	}
}
