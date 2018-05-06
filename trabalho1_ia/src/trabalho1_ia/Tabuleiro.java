package trabalho1_ia;

import java.util.ArrayList;

public class Tabuleiro  {
	private byte[][] tabuleiro = new byte[8][8];
	private int linhaCavalo, colunaCavalo;
	private int nLinhas , nColunas;
	private int qtdMovimentosValidos;
	private byte tempoUltimoMovimentoCavalo = 0;
	private boolean jaVisitouTabuleiro = false;
	private ArrayList<Tabuleiro> movimentosValidos;

	public boolean jaVisitouTabuleiro() {
		return jaVisitouTabuleiro;
	}

	public void setJaVisitouTabuleiro(boolean jaVisitouTabuleiro) {
		this.jaVisitouTabuleiro = jaVisitouTabuleiro;
	}

	//Cria um tabuleiro vazio sem cavalo
	public Tabuleiro() {
		nLinhas = tabuleiro.length;
		nColunas = tabuleiro[0].length;

		for(int i=0; i < nLinhas; i++) {
			for(int j=0; j < nColunas; j++) {
				tabuleiro[i][j] = 0;
			}
		}
		qtdMovimentosValidos = 0;
		tempoUltimoMovimentoCavalo = 0;
	}
	
	//Cria um tabuleiro vazio e coloca o cavalo na posicao (linhaCavalo, colunaCavalo)
	//Como o cavalo fez um movimento, incrementa tempoUltimoMovimentoCavalo
	public Tabuleiro(int linhaCavalo, int colunaCavalo) {
		this();
		this.linhaCavalo = linhaCavalo;
		this.colunaCavalo = colunaCavalo;
		this.tempoUltimoMovimentoCavalo = (byte)(this.tempoUltimoMovimentoCavalo+1);
		this.tabuleiro[linhaCavalo][colunaCavalo] = tempoUltimoMovimentoCavalo;
	}
	
	//Copia um tabuleiro e coloca o cavalo na posicao (linhaCavalo, colunaCavalo)
	//Como o cavalo fez um movimento, incrementa tempoUltimoMovimentoCavalo
	public Tabuleiro(Tabuleiro tabuleiro, int linhaCavalo, int colunaCavalo) {
		nLinhas = this.tabuleiro.length;
		nColunas = this.tabuleiro[0].length;
		
		for(int i=0; i < nLinhas; i++) {
			for(int j=0; j < nColunas; j++) {
				this.tabuleiro[i][j] = tabuleiro.getTabuleiro()[i][j];
			}
		}		
		
		qtdMovimentosValidos = 0;	
		this.tempoUltimoMovimentoCavalo = (byte)(tabuleiro.getTempoUltimoMovimentoCavalo()+1);
		this.tabuleiro[linhaCavalo][colunaCavalo] = this.tempoUltimoMovimentoCavalo;
		this.linhaCavalo = linhaCavalo;
		this.colunaCavalo = colunaCavalo;
	}
	
	public ArrayList<Tabuleiro> getMovimentosValidos() {
		return movimentosValidos;
	}
	
	public void setMovimentosValidos(ArrayList<Tabuleiro> movimentosValidos) {
		this.movimentosValidos = movimentosValidos;
	}
	
	public byte[][] getTabuleiro() {
		return tabuleiro;
	}
	
	public byte getTempoUltimoMovimentoCavalo() {
		return tempoUltimoMovimentoCavalo;
	}
	
	public int getQtdMovimentosValidos() {
		return qtdMovimentosValidos;
	}
	
	public String toString() {
		StringBuilder outputString = new StringBuilder();
		for(int i=0; i < nLinhas; i++) {
			for(int j=0; j < nColunas; j++) {
				outputString.append("["+tabuleiro[i][j]+"]");
			}
			outputString.append(System.lineSeparator());
		}		
		return outputString.toString();
	}
	
	public ArrayList<Tabuleiro> calculaMovimentosValidos(){
		ArrayList<Tabuleiro> movimentosValidos = new ArrayList<Tabuleiro>();
		int projetoMovimentoLinha, projetoMovimentoColuna;
		Tabuleiro novoTab;
		//Aqui fica o calculo de todos os movimentos va¡lidos do cavalo
		
		//movimentos para cima
		//anda pra cima - direita
		projetoMovimentoLinha = linhaCavalo-2;
		projetoMovimentoColuna = colunaCavalo+1;
		if (movimentoEhValido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			novoTab = new Tabuleiro(this, projetoMovimentoLinha, projetoMovimentoColuna);
			movimentosValidos.add(novoTab);	
		}
		
		//anda pra cima - esquerda
		projetoMovimentoLinha = linhaCavalo-2;
		projetoMovimentoColuna = colunaCavalo-1;
		if (movimentoEhValido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			novoTab = new Tabuleiro(this, projetoMovimentoLinha, projetoMovimentoColuna);
			movimentosValidos.add(novoTab);	
		}
		
		//anda pra direita - cima
		projetoMovimentoLinha = linhaCavalo-1;
		projetoMovimentoColuna = colunaCavalo+2;
		if (movimentoEhValido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			novoTab = new Tabuleiro(this, projetoMovimentoLinha, projetoMovimentoColuna);
			movimentosValidos.add(novoTab);	
		}
		
		//anda pra esquerda - cima
		projetoMovimentoLinha = linhaCavalo-1;
		projetoMovimentoColuna = colunaCavalo-2;
		if (movimentoEhValido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			novoTab = new Tabuleiro(this, projetoMovimentoLinha, projetoMovimentoColuna);
			movimentosValidos.add(novoTab);	
		}		
		
		//Movimentos pra baixo		
		//anda pra baixo - direita
		projetoMovimentoLinha = linhaCavalo+2;
		projetoMovimentoColuna = colunaCavalo+1;
		if (movimentoEhValido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			novoTab = new Tabuleiro(this, projetoMovimentoLinha, projetoMovimentoColuna);
			movimentosValidos.add(novoTab);	
		}
		
		//anda pra baixo - esquerda
		projetoMovimentoLinha = linhaCavalo+2;
		projetoMovimentoColuna = colunaCavalo-1;
		if (movimentoEhValido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			novoTab = new Tabuleiro(this, projetoMovimentoLinha, projetoMovimentoColuna);
			movimentosValidos.add(novoTab);	
		}
		
		//anda pra direita - baixo
		projetoMovimentoLinha = linhaCavalo+1;
		projetoMovimentoColuna = colunaCavalo+2;
		if (movimentoEhValido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			novoTab = new Tabuleiro(this, projetoMovimentoLinha, projetoMovimentoColuna);
			movimentosValidos.add(novoTab);	
		}
		
		//anda pra esquerda - baixo
		projetoMovimentoLinha = linhaCavalo+1;
		projetoMovimentoColuna = colunaCavalo-2;
		if (movimentoEhValido(projetoMovimentoLinha,projetoMovimentoColuna)) {
			novoTab = new Tabuleiro(this, projetoMovimentoLinha, projetoMovimentoColuna);
			movimentosValidos.add(novoTab);	
		}		
		
		this.qtdMovimentosValidos = movimentosValidos.size();
		return movimentosValidos;
	}
	
	private boolean movimentoEhValido (int linha, int coluna) {
		if(linha<nLinhas && coluna<nColunas && linha >=0 && coluna >=0 && tabuleiro[linha][coluna] == 0) {
			//o movimento eh valido
			return true;
		}
		return false;
	}
	
	//caso true, backtracking testar o próximo da lista de movimentos
	public boolean achouBecoSemSaida() {
		if(this.qtdMovimentosValidos == 0){
			return true;
		}
		return false;
	}
	
	//caso true solucao encontrada
	public boolean isResposta () {
		if(achouBecoSemSaida() && (nLinhas*nColunas == (int)this.getTempoUltimoMovimentoCavalo())){
			return true;
		}
		return false;
	}
	


}
