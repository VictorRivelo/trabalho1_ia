package trabalho1_ia;

import java.util.ArrayList;

public class Tabuleiro {
	byte[][] tabuleiro = new byte[8][8];
	int linhaCavalo, colunaCavalo;
	
	public Tabuleiro() {
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				tabuleiro[i][j] = 0;
			}
		}
	 linhaCavalo = tabuleiro.length;
	 colunaCavalo = tabuleiro[0].length;
	}
	
	public String toString() {
		StringBuilder outputString = new StringBuilder();
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				outputString.append("["+tabuleiro[i][j]+"]");
			}
			outputString.append(System.lineSeparator());
		}		
		return outputString.toString();
	}
	
	public ArrayList<Tabuleiro> getMovimentosValidos(int linha, int coluna) {
		ArrayList<Tabuleiro> movimentosValidos = new ArrayList<Tabuleiro>();
		
		//Aqui fica o calculo de todos os movimentos válidos do cavalo
		
		return movimentosValidos;
	}
	
}
