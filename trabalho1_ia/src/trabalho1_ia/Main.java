package trabalho1_ia;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {	
		/*ResultadosTeste resultadosAEstrela = InteligenciaArtificial.aEstrela();
		System.out.println(resultadosAEstrela.toString());*/
		
		Tabuleiro tab = new Tabuleiro(3, 7);
		System.out.println(tab.toString());
		
		ArrayList<Tabuleiro> movimentosValidos = tab.getMovimentosValidos();
		
		int i = 0;		
		for(Tabuleiro movimentoValido : movimentosValidos) {
			System.out.println("movimento valido "+i+" : ");
			System.out.println(movimentoValido.toString());
			System.out.println("Movimentos subsequentes do candidato " + i + ": ");
			for(Tabuleiro movimentoSubsequente : movimentoValido.getMovimentosValidos()) {
				System.out.println(movimentoSubsequente.toString());
			}
			i++;
		}		

		
		/*ResultadosTeste resultadosSmaEstrela = InteligenciaArtificial.smaEstrela();
		System.out.println(resultadosSmaEstrela.toString());*/
		
	}
}
