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
		Tabuleiro tabuleiroAtual = new Tabuleiro(1, 1);
		
		long tempoInicial = System.nanoTime();
		
		//Aqui fica a logica do A*
		// link de um pseudocodigo, parece muito bom, da pra usar de base no desenvolvimento
		//https://en.wikipedia.org/wiki/A*_search_algorithm
				
		ArrayList<Tabuleiro> memoria = new ArrayList<Tabuleiro>();
		memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.A_ESTRELA));
		Collections.sort(memoria, aEstrelaComparator);//o(n log n)
		
		while(!tabuleiroAtual.isResposta()) {
			tabuleiroAtual = memoria.remove(0);//o(1)
			memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.A_ESTRELA));//o(n)
			Collections.sort(memoria, aEstrelaComparator);//o(n log n)
			
			while(tabuleiroAtual.achouBecoSemSaida() && !tabuleiroAtual.isResposta()) {
				tabuleiroAtual = memoria.remove(0); //o(1)
				memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.A_ESTRELA));//o(n)
				Collections.sort(memoria, aEstrelaComparator);//o(n log n)
			}
			numeroPassos++;
		}
		
		long tempoFinal = System.nanoTime();
		
		ResultadosTeste resultados = new ResultadosTeste(TipoAlgoritmo.A_ESTRELA, tempoFinal - tempoInicial, numeroPassos, tabuleiroAtual);
		return resultados;
	}
	
	
	//Executa o SMA*
	public static ResultadosTeste smaEstrela(long tamanhoMemoria) {
		Long numeroPassos = 0L;
		Tabuleiro tabuleiroAtual = new Tabuleiro(1,1);
		
		long tempoInicial = System.nanoTime();		
		
		//Aqui fica a lÃ³gica do SMA*
		// link de um pseudocodigo parece muito bom, da pra usar de base tambÃ©m
		// https://en.wikipedia.org/wiki/SMA*
		
		ArrayList<Tabuleiro> memoria = new ArrayList<Tabuleiro>();
		memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.SMA_ESTRELA));
		Collections.sort(memoria, aEstrelaComparator);//o(n log n)
		
		while(!tabuleiroAtual.isResposta()) {
			tabuleiroAtual = memoria.remove(0);//o(1)
			memoria.addAll(getMelhoresMovimentos(tabuleiroAtual, TipoAlgoritmo.SMA_ESTRELA));//o(n)
			Collections.sort(memoria, aEstrelaComparator);//o(n log n)
			
			//Parte do SMA* que chega o tamanho da memoria e elimina os caminhos menos promissores
			if(memoria.size() > tamanhoMemoria) {				
				ArrayList<Tabuleiro> listaRemovida = 
						new ArrayList<Tabuleiro>(
								memoria.subList((int)memoria.size(), memoria.size()));
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
		
		Tabuleiro tabuleiro = new Tabuleiro(1,1);
		Stack<Tabuleiro> pilha = new Stack<Tabuleiro>();
		
		long tempoInicial = System.nanoTime();
		long numeroPassos = 0;

		while(!tabuleiro.isResposta()) {
			numeroPassos++;
			tabuleiro.setJaVisitouTabuleiro(true);
			
			if(tabuleiro.achouBecoSemSaida()) {
				System.out.println("achou beco sem saida");
				System.out.println(tabuleiro.toString());
				System.out.println("ultimo movimento do cavalo: " + tabuleiro.getTempoUltimoMovimentoCavalo());
				System.out.println("fazendo backtracking");
				tabuleiro = pilha.pop();
			}
			
			//Ordena a lista de movimentos validos pela heuristica do best first
			Collections.sort(tabuleiro.getMovimentosValidos(), bestFirstComparator);

			//Verifica se o cavalo ja tentou todos os caminhos partindo da posicao atual 
			//ocorre se ele ja fez backtracking por todos eles
			boolean jaTestouTodosCaminhos = true;
			for(Tabuleiro movimento : tabuleiro.getMovimentosValidos()) {
				if(!tabuleiro.jaVisitouTabuleiro()) {
					//Achou um caminho que nao foi percorrido ainda
					//Escolhe esse caminho pra percorrer
					jaTestouTodosCaminhos = false;
					System.out.println("empilhando");
					pilha.push(tabuleiro);
					tabuleiro = movimento;					
				}
			}
			//se ja testou todos subcaminhos, volta pro no anterior
			if(jaTestouTodosCaminhos) {
				tabuleiro = pilha.pop();
			} 
		}

		long tempoFinal = System.nanoTime();
		return new ResultadosTeste(TipoAlgoritmo.BEST_FIRST, tempoFinal - tempoInicial, numeroPassos, tabuleiro);
	}
	
	//Retorna a lista de todos os movimentos validos a partir da posicao atual do cavalo,
	//ordenados pela qualidade do movimento de acordo com a heuristica de Warnsdorff
	public static ArrayList<Tabuleiro> getMelhoresMovimentos(Tabuleiro tabuleiro, TipoAlgoritmo tipoAlgoritmo) {
		//Retorna todos os movimentos validos a partir da posicao atual
		ArrayList<Tabuleiro> melhoresMovimentos = tabuleiro.getMovimentosValidos();
		
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
			if(t1.getQtdMovimentosValidos() > t2.getQtdMovimentosValidos()) {
				return 1;
			} else if(t1.getQtdMovimentosValidos() < t2.getQtdMovimentosValidos()) {
				return -1;
			}
			
			if(t1.getTempoUltimoMovimentoCavalo() > t2.getTempoUltimoMovimentoCavalo()) {
				return 1;
			} else if (t1.getTempoUltimoMovimentoCavalo() < t2.getTempoUltimoMovimentoCavalo()) {
				return -1;
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
