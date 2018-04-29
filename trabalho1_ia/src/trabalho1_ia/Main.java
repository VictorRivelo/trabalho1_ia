package trabalho1_ia;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {	
		/*ResultadosTeste resultadosAEstrela = InteligenciaArtificial.aEstrela();
		System.out.println(resultadosAEstrela.toString());*/
		
		Tabuleiro tab = new Tabuleiro(3, 4);
		System.out.println(tab.toString());
		
		ArrayList<Tabuleiro> movimentosValidos = tab.getMovimentosValidos();
		
		for(Tabuleiro movimentoValido : movimentosValidos) {
			System.out.println(movimentoValido.toString());
		}
		
		System.out.println("qtd de movimentos validos: " + tab.getQtdMovimentosValidos());
		
		/*ResultadosTeste resultadosSmaEstrela = InteligenciaArtificial.smaEstrela();
		System.out.println(resultadosSmaEstrela.toString());*/
		
	}
}
