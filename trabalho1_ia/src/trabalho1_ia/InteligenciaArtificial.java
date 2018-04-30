package trabalho1_ia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class InteligenciaArtificial {

	//Executa o A*
	public static ResultadosTeste aEstrela() {
		Long numeroPassos = 0L;
		Tabuleiro tabuleiroAtual = new Tabuleiro(1, 1);
		
		long tempoInicial = System.nanoTime();
		
		//Aqui fica a logica do A*
		// link de um pseudocodigo, parece muito bom, da pra usar de base no desenvolvimento
		//https://en.wikipedia.org/wiki/A*_search_algorithm
				
		ArrayList<Tabuleiro> memoria = new ArrayList<Tabuleiro>();
		memoria.addAll(getMelhoresMovimentos(tabuleiroAtual));
		Collections.sort(memoria);//o(n log n)
		
		while(!tabuleiroAtual.Resultado()) {
			tabuleiroAtual = memoria.remove(0);//o(1)
			memoria.addAll(getMelhoresMovimentos(tabuleiroAtual));//o(n)
			Collections.sort(memoria);//o(n log n)
			
			while(tabuleiroAtual.becoSemSaida() && !tabuleiroAtual.Resultado()) {
				tabuleiroAtual = memoria.remove(0); //o(1)
				memoria.addAll(getMelhoresMovimentos(tabuleiroAtual));//o(n)
				Collections.sort(memoria);//o(n log n)
			}
			numeroPassos++;
		}
		
		long tempoFinal = System.nanoTime();
		
		ResultadosTeste resultados = new ResultadosTeste(TipoAlgoritmo.A_ESTRELA, tempoFinal - tempoInicial, numeroPassos, tabuleiroAtual);
		return resultados;
	}
	
	
	//Executa o SMA*
	public static ResultadosTeste smaEstrela() {
		Long numeroPassos = 0L;
		Tabuleiro tabuleiroAtual = new Tabuleiro(1,1);
		
		long tempoInicial = System.nanoTime();		
		
		//Aqui fica a lÃ³gica do SMA*
		// link de um pseudocodigo parece muito bom, da pra usar de base tambÃ©m
		// https://en.wikipedia.org/wiki/SMA*
		
		ArrayList<Tabuleiro> memoria = new ArrayList<Tabuleiro>();
		
		memoria.addAll(getMelhoresMovimentos(tabuleiroAtual));
		Collections.sort(memoria);//o(n log n)
		
		while(!tabuleiroAtual.Resultado()) {
			tabuleiroAtual = memoria.remove(0);//o(1)
			memoria.addAll(getMelhoresMovimentos(tabuleiroAtual));//o(n)
			Collections.sort(memoria);//o(n log n)
			
			while(tabuleiroAtual.becoSemSaida() && !tabuleiroAtual.Resultado()) {
				//Minha idéia é criar um outro Array de tamanho X e adicionar o tabuleiroAtual
				//Quando array.size==x podamos o braço da árvore(backtrack)
				tabuleiroAtual = memoria.remove(0); //o(1)
				memoria.addAll(getMelhoresMovimentos(tabuleiroAtual));//o(n)
				Collections.sort(memoria);//o(n log n)
			}
			numeroPassos++;
		}
		
		long tempoFinal = System.nanoTime();
		
		ResultadosTeste resultados = new ResultadosTeste(TipoAlgoritmo.SMA_ESTRELA, tempoFinal - tempoInicial, numeroPassos, tabuleiro);
		return resultados;
	}
	
	//Retorna a lista de todos os movimentos validos a partir da posicao atual do cavalo,
	//ordenados pela qualidade do movimento de acordo com a heuristica de Warnsdorff
	public static ArrayList<Tabuleiro> getMelhoresMovimentos(Tabuleiro tabuleiro) {
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
		//Collections.sort(melhoresMovimentos);
		
		return melhoresMovimentos;
	}
}
