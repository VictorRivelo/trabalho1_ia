package trabalho1_ia;

import java.util.ArrayList;

public class Tabuleiro {
	byte[][] tabuleiro = new byte[8][8];
	int linhaCavalo, colunaCavalo;
	int nLinhas , nColunas;
	int [][] Last;
	
	public Tabuleiro() {
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				tabuleiro[i][j] = 0;
			}
		}
	 nLinhas = tabuleiro.length;
	 nColunas = tabuleiro[0].length;
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
		int projetoMovimentoLinha, projetoMovimentoColuna;
		
		//Aqui fica o calculo de todos os movimentos válidos do cavalo
		
		//movimentos para cima
		//anda pra cima - direita
		projetoMovimentoLinha = linha+2;
		projetoMovimentoColuna = coluna+1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna))
		//movimentosValidos.add(??)
		
		//anda pra cima - esquerda
		projetoMovimentoLinha = linha+2;
		projetoMovimentoColuna = coluna-1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna))
		//movimentosValidos.add(??)
		
		//anda pra cima - direita
		projetoMovimentoLinha = linha+2;
		projetoMovimentoColuna = coluna+1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna))
		//movimentosValidos.add(??)

		//movimentos para direita
		//anda pra direita - cima 
		projetoMovimentoLinha = linha+1;
		projetoMovimentoColuna = coluna+2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna))
		//movimentosValidos.add(??) 	
			
		//anda pra diretia - baixo
		projetoMovimentoLinha = linha-1;
		projetoMovimentoColuna = coluna+2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna))
		//movimentosValidos.add(??) 	
		
		//movimentos para esquerda
		//anda pra esquerda - cima 
		projetoMovimentoLinha = linha+1;
		projetoMovimentoColuna = coluna-2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna))
		//movimentosValidos.add(??) 	
			
		//anda pra esquerda - baixo
		projetoMovimentoLinha = linha-1;
		projetoMovimentoColuna = coluna-2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna))
		//movimentosValidos.add(??) 
			
		//movimentos para baixo
		//anda pra baixo - esquerda
		projetoMovimentoLinha = linha-2;
		projetoMovimentoColuna = coluna-1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna))
		//movimentosValidos.add(??) 

		//anda pra baixo - direita
		projetoMovimentoLinha = linha-2;
		projetoMovimentoColuna = coluna+1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna))
		//movimentosValidos.add(??) 
		
		return movimentosValidos;
	}
	
	public boolean Valido (int linha, int coluna) {
		if(linha<nLinhas && coluna<nColunas && linha>0 && coluna>0 && tabuleiro[linha][coluna] == 0) {
		//o movimento é valido
		return true;
		}
	return false;
	}
	
}
