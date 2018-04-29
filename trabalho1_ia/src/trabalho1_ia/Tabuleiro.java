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
	
	public ArrayList<Tabuleiro> getMovimentosValidos(int linha, int coluna) throws CloneNotSupportedException {
		ArrayList<Tabuleiro> movimentosValidos = new ArrayList<Tabuleiro>();
		int projetoMovimentoLinha, projetoMovimentoColuna;
		Tabuleiro T = this, tabuleiro;
		//Aqui fica o calculo de todos os movimentos válidos do cavalo
		
		//movimentos para cima
		//anda pra cima - direita
		projetoMovimentoLinha = linha+2;
		projetoMovimentoColuna = coluna+1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//anda pra cima - esquerda
		projetoMovimentoLinha = linha+2;
		projetoMovimentoColuna = coluna-1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//anda pra cima - direita
		projetoMovimentoLinha = linha+2;
		projetoMovimentoColuna = coluna+1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//movimentos para direita	
		//anda pra diretia - cima 
		projetoMovimentoLinha = linha+1;
		projetoMovimentoColuna = coluna+2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//anda pra diretia - baixo
		projetoMovimentoLinha = linha-1;
		projetoMovimentoColuna = coluna+2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//movimentos para esquerda
		//anda pra esquerda - cima 
		projetoMovimentoLinha = linha+1;
		projetoMovimentoColuna = coluna-2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}	
		
		//anda pra esquerda - baixo
		projetoMovimentoLinha = linha-1;
		projetoMovimentoColuna = coluna-2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//movimentos para baixo
		//anda pra baixo - esquerda
		projetoMovimentoLinha = linha-2;
		projetoMovimentoColuna = coluna-1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//anda pra baixo - direita
		projetoMovimentoLinha = linha-2;
		projetoMovimentoColuna = coluna+1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		} 
		
		return movimentosValidos;
	}
	
	public boolean Valido (int linha, int coluna) {
		if(linha<nLinhas && coluna<nColunas && linha>0 && coluna>0 && tabuleiro[linha][coluna] == 0) {
		//o movimento é valido
		return true;
		}
	return false;
	}
	
	public Tabuleiro Cria (Tabuleiro T, int Linha , int Coluna) throws CloneNotSupportedException {
		Tabuleiro tabuleiro = (Tabuleiro) this.clone();
		//falta colocar o valor na celula [linha][coluna]
		//salvar o last, posicao do cavalo
		tabuleiro.linhaCavalo = Linha;
		tabuleiro.colunaCavalo = Coluna;
		return tabuleiro;
	} 
	
}
