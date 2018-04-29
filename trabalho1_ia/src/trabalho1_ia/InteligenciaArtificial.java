package trabalho1_ia;

import java.util.List;

public class InteligenciaArtificial {

	
	public static ResultadosTeste aEstrela() {
		Long tempo = 0L;
		Long numeroPassos = 0L;
		Tabuleiro tabuleiro = new Tabuleiro();
		
		//Aqui fica a lógica do A*
		
		ResultadosTeste resultados = new ResultadosTeste(TipoAlgoritmo.A_ESTRELA, tempo, numeroPassos, tabuleiro);
		return resultados;
	}
	
	public static ResultadosTeste smaEstrela() {
		Long tempo = 0L;
		Long numeroPassos = 0L;
		Tabuleiro tabuleiro = new Tabuleiro();
		
		//Aqui fica a lógica do SMA*
		
		ResultadosTeste resultados = new ResultadosTeste(TipoAlgoritmo.SMA_ESTRELA, tempo, numeroPassos, tabuleiro);
		return resultados;
	}
	
	//Aqui aplica a heurística pra achar o melhor movimento
	private static Tabuleiro getMelhorMovimento(List<Tabuleiro> movimentosValidos) {
		return movimentosValidos.get(0);
	}
}
