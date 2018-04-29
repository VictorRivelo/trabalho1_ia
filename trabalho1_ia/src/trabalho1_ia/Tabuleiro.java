package trabalho1_ia;

import java.util.ArrayList;

public class Tabuleiro implements Comparable<Tabuleiro> {
	byte[][] tabuleiro = new byte[8][8];
	int linhaCavalo, colunaCavalo;
	int nLinhas , nColunas;
	int [][] Last;
	int qtdMovimentosValidos;
	
	public Tabuleiro() {
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				tabuleiro[i][j] = 0;
			}
		}
	 nLinhas = tabuleiro.length;
	 nColunas = tabuleiro[0].length;
	}
	
	public int getQtdMovimentosValidos() {
		return qtdMovimentosValidos;
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
	
	public ArrayList<Tabuleiro> getMovimentosValidos(){
		ArrayList<Tabuleiro> movimentosValidos = new ArrayList<Tabuleiro>();
		int projetoMovimentoLinha, projetoMovimentoColuna;
		Tabuleiro T = this, tabuleiro;
		//Aqui fica o calculo de todos os movimentos válidos do cavalo
		
		//movimentos para cima
		//anda pra cima - direita
		projetoMovimentoLinha = Last.length+2;
		projetoMovimentoColuna = Last[0].length+1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//anda pra cima - esquerda
		projetoMovimentoLinha = Last.length+2;
		projetoMovimentoColuna = Last[0].length-1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//anda pra cima - direita
		projetoMovimentoLinha = Last.length+2;
		projetoMovimentoColuna = Last[0].length+1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//movimentos para direita	
		//anda pra diretia - cima 
		projetoMovimentoLinha = Last.length;
		projetoMovimentoColuna = Last[0].length+2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//anda pra diretia - baixo
		projetoMovimentoLinha = Last.length-1;
		projetoMovimentoColuna = Last[0].length+2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//movimentos para esquerda
		//anda pra esquerda - cima 
		projetoMovimentoLinha = Last.length+1;
		projetoMovimentoColuna = Last[0].length-2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}	
		
		//anda pra esquerda - baixo
		projetoMovimentoLinha = Last.length-1;
		projetoMovimentoColuna = Last[0].length-2;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//movimentos para baixo
		//anda pra baixo - esquerda
		projetoMovimentoLinha = Last.length-2;
		projetoMovimentoColuna = Last[0].length-1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		}
		
		//anda pra baixo - direita
		projetoMovimentoLinha = Last.length-2;
		projetoMovimentoColuna = Last[0].length+1;
		if (Valido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			tabuleiro = Cria (T, projetoMovimentoColuna, projetoMovimentoColuna);
			movimentosValidos.add(tabuleiro);	
		} 
		
		this.qtdMovimentosValidos = movimentosValidos.size();
		return movimentosValidos;
	}
	
	public boolean Valido (int linha, int coluna) {
		if(linha<nLinhas && coluna<nColunas && linha>0 && coluna>0 && tabuleiro[linha][coluna] == 0) {
		//o movimento é valido
		return true;
		}
	return false;
	}
	
	public Tabuleiro Cria (Tabuleiro T, int Linha , int Coluna) {
		try{
			Tabuleiro tabuleiro = (Tabuleiro) this.clone();
			//falta colocar o valor na celula [linha][coluna]
			tabuleiro.linhaCavalo = Linha;
			tabuleiro.colunaCavalo = Coluna;
			Last = new int [linhaCavalo][colunaCavalo]; 
			return tabuleiro;
		}catch(Exception e){
			System.err.println("CloneNotSupportedException:" + e.getMessage());
		}
	}

	//Compara dois tabuleiros pelo numero de movimentos sucessores
	//Se o atual tiver mais movimentos do que o comparado, ele eh considerado maior
	//e vem depois na ordenacao. Se tiver menos, eh considerado menor 
	//e vem antes na ordenacao.
	@Override
	public int compareTo(Tabuleiro t2) {
		if(this.qtdMovimentosValidos > t2.qtdMovimentosValidos) {
			return 1;
		} else if(this.qtdMovimentosValidos < t2.qtdMovimentosValidos) {
			return -1;
		}
		return 0;
	}

}
