package trabalho1_ia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class InteligenciaArtificial {
	
	private static BestFirstComparator bestFirstComparator = new BestFirstComparator();
	private static AEstrelaComparator aEstrelaComparator = new AEstrelaComparator();
	

	//Executa o A*
	public static ResultadosTeste aEstrela() {
		Long numeroPassos = 0L;
		
		
		long tempoInicial = System.nanoTime();
		
		//Aqui fica a logica do A*
		// link de um pseudocodigo, parece muito bom, da pra usar de base no desenvolvimento
		//https://en.wikipedia.org/wiki/A*_search_algorithm
		
		
		Tabuleiro tabuleiroAtual = new Tabuleiro(1, 1);
		tabuleiroAtual.setJaVisitouTabuleiro(true);
		
		ArrayList<Tabuleiro> memoria = new ArrayList<Tabuleiro>();
		memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.A_ESTRELA));
		//Collections.sort(memoria, aEstrelaComparator);//o(n log n)
		
		while(!tabuleiroAtual.isResposta()) {
			System.out.println(tabuleiroAtual.toString());
			System.out.println("qtd de passos do cavalo: "+tabuleiroAtual.getTempoUltimoMovimentoCavalo());
			tabuleiroAtual = getProximoMovimento(memoria);
			tabuleiroAtual.setJaVisitouTabuleiro(true);
			
			memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.A_ESTRELA));//o(n)
			//Collections.sort(memoria, aEstrelaComparator);//o(n log n)
			
			while(tabuleiroAtual.achouBecoSemSaida() && !tabuleiroAtual.isResposta()) {
				tabuleiroAtual = getProximoMovimento(memoria);
				tabuleiroAtual.setJaVisitouTabuleiro(true);
				memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.A_ESTRELA));//o(n)
				//Collections.sort(memoria, aEstrelaComparator);//o(n log n)
			}
			numeroPassos++;
		}
		
		long tempoFinal = System.nanoTime();
		
		ResultadosTeste resultados = new ResultadosTeste(TipoAlgoritmo.A_ESTRELA, tempoFinal - tempoInicial, numeroPassos, tabuleiroAtual);
		return resultados;
	}
	
	public static Tabuleiro getProximoMovimento(ArrayList<Tabuleiro> movimentosPossiveis){
		int heuristicaAtual = 0;
		int heuristicaMelhorTabuleiro = 0;
		Tabuleiro melhorTabuleiro = null;
		for(Tabuleiro tab : movimentosPossiveis) {
			heuristicaAtual = 2*tab.getQtdMovimentosValidos() + tab.getTempoUltimoMovimentoCavalo();
			
			if(heuristicaAtual > heuristicaMelhorTabuleiro && !tab.jaVisitouTabuleiro()) {
				melhorTabuleiro = tab;
				heuristicaMelhorTabuleiro = heuristicaAtual;
			}
		}
		return melhorTabuleiro;
	}
	
	//Executa o SMA*
	public static ResultadosTeste smaEstrela(long tamanhoMemoria) {
		Long numeroPassos = 0L;
		Tabuleiro tabuleiroAtual = new Tabuleiro(1,1);
		
		long tempoInicial = System.nanoTime();		
		
		//Aqui fica a logica do SMA*
		// link de um pseudocodigo parece muito bom, da pra usar de base tambem
		// https://en.wikipedia.org/wiki/SMA*
		
		ArrayList<Tabuleiro> memoria = new ArrayList<Tabuleiro>();
		memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.SMA_ESTRELA));
		Collections.sort(memoria, aEstrelaComparator);//o(n log n)
		
		while(!tabuleiroAtual.isResposta()) {	
			tabuleiroAtual = memoria.remove(0);//o(1)
			memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.SMA_ESTRELA));//o(n)
			Collections.sort(memoria, aEstrelaComparator);//o(n log n)
			
			//Parte do SMA* que checa o tamanho da memoria e elimina os caminhos menos promissores
			if(memoria.size() > tamanhoMemoria) {				
				ArrayList<Tabuleiro> listaRemovida = 
						new ArrayList<Tabuleiro>(
								memoria.subList((int)memoria.size()/2, memoria.size()));
				memoria.removeAll(listaRemovida);
			}			
			
			while(tabuleiroAtual.achouBecoSemSaida() && !tabuleiroAtual.isResposta()) {
				tabuleiroAtual = memoria.remove(0); //o(1)
				memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.SMA_ESTRELA));//o(n)
				Collections.sort(memoria, aEstrelaComparator);//o(n log n)
			}
			numeroPassos++;
		}
		
		long tempoFinal = System.nanoTime();
		
		ResultadosTeste resultados = new ResultadosTeste(TipoAlgoritmo.SMA_ESTRELA, 
				tempoFinal - tempoInicial, numeroPassos, tabuleiroAtual);
		return resultados;
	}
	
	public static ResultadosTeste bestFirstSearch() {
		
		Tabuleiro tabuleiro = new Tabuleiro(3,1);
		tabuleiro.setMovimentosValidos(tabuleiro.calculaMovimentosValidos());
		 
		ArrayList<Tabuleiro> subcaminhosNaoVisitados = new ArrayList<Tabuleiro>();
		Stack<Tabuleiro> pilha = new Stack<Tabuleiro>();
		
		long tempoInicial = System.nanoTime();
		long numeroPassos = 0;

		while(!tabuleiro.isResposta()) {
			numeroPassos++;
			tabuleiro.setJaVisitouTabuleiro(true);
			
			if(tabuleiro.achouBecoSemSaida()) {
				//No encontrado eh beco sem saida
				//Volta pro no antecessor
				tabuleiro = pilha.pop();
			} else {
				//No encontrado nao eh beco sem saida
				//Agora deve verificar se esse no tem subcaminhos que ainda nao
				//foram percorridos
				boolean jaTestouTodosSubcaminhos = true;
				subcaminhosNaoVisitados = new ArrayList<Tabuleiro>();

				for(Tabuleiro movimento : tabuleiro.getMovimentosValidos()) {
					if(!movimento.jaVisitouTabuleiro()) {
						//Achou um caminho que nao foi percorrido ainda
						//Coloca esse caminho na lista de subcaminhos nao percorridos
						subcaminhosNaoVisitados.add(movimento);
						movimento.calculaMovimentosValidos();
						jaTestouTodosSubcaminhos = false;
					} 
				}
				
				if(jaTestouTodosSubcaminhos) {
					//se ja testou todos subcaminhos, volta pro tabuleiro anterior
					tabuleiro = pilha.pop();
				} else {
					//Se ha subcaminhos nao percorridos, pega o melhor
					//Ordena a lista de subcaminhos nao visitados pelo criterio da
					//heuristica, ou seja, o que tem menor numero de subcaminhos futuros
					Collections.sort(subcaminhosNaoVisitados, bestFirstComparator);
					//Guarda o tabuleiro atual na pilha
					pilha.push(tabuleiro);
					//Pega o melhor subcaminho
					tabuleiro = subcaminhosNaoVisitados.get(0);
					//
					tabuleiro.setMovimentosValidos(tabuleiro.calculaMovimentosValidos());
				}
			}
		}

		long tempoFinal = System.nanoTime();
		return new ResultadosTeste(TipoAlgoritmo.BEST_FIRST, tempoFinal - tempoInicial, numeroPassos, tabuleiro);
	}
	
	//Retorna a lista de todos os movimentos validos a partir da posicao atual do cavalo,
	//ordenados pela qualidade do movimento de acordo com a heuristica de Warnsdorff
	public static ArrayList<Tabuleiro> getMelhoresMovimentos(Tabuleiro tabuleiro, TipoAlgoritmo tipoAlgoritmo) {
		//Retorna todos os movimentos validos a partir da posicao atual
		ArrayList<Tabuleiro> melhoresMovimentos = tabuleiro.calculaMovimentosValidos();
		
		//Itera sobre os movimentos validos, calculando o número de
		//movimentos sucessores de cada um
		for(Tabuleiro tab : melhoresMovimentos) {
			tab.getMovimentosValidos();
		}		
		
		//Ordena a lista de movimentos validos. Para isso eh usado o criterio do compareTo
		//que coloca primeiro aqueles que tem menor quantidade de movimentos sucessores
		//conforme determinado pela heuristica de Warnsdorff
		if(tipoAlgoritmo.equals(TipoAlgoritmo.A_ESTRELA) || tipoAlgoritmo.equals(TipoAlgoritmo.SMA_ESTRELA)) {
			Collections.sort(melhoresMovimentos, aEstrelaComparator);
		} else {
			Collections.sort(melhoresMovimentos, bestFirstComparator);
		}
		
		
		return melhoresMovimentos;
	}

	
	private static class AEstrelaComparator implements Comparator<Tabuleiro> {

		@Override
		public int compare(Tabuleiro t1, Tabuleiro t2) {
			double heuristicaT1 = (t1.getQtdMovimentosValidos() + (t1.getTempoUltimoMovimentoCavalo()));
			double heuristicaT2 = (t2.getQtdMovimentosValidos() + (t2.getTempoUltimoMovimentoCavalo()))*0.5
			if(heuristicaT1 > heuristicaT2) {
				//Se T1 tem mais valor que T2, deve vir primeiro na lista
				return -1;
			} else if(heuristicaT1 < heuristicaT2) {
				return 1;
			}
			
			return 0;
		}
		
	}	
	

	private static class BestFirstComparator implements Comparator<Tabuleiro> {

		@Override
		public int compare(Tabuleiro t1, Tabuleiro t2) {
			if(t1.getQtdMovimentosValidos() > t2.getQtdMovimentosValidos()) {
				return 1;
			} 
			if(t1.getQtdMovimentosValidos() < t2.getQtdMovimentosValidos()) {
				return -1;
			}
			return 0;
		}
		
	}
	

	
	
}
