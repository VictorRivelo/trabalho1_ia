package trabalho1_ia;

public class Main {
	public static void main(String[] args) {	
		if(args.length!=3){ //checa se a entrada é do tamanho certo
			System.out.println("Usage: java -jar {programa}.jar t x y");
			System.out.println("t: dimensão do tabuleiro, x: posição eixo x do cavalo, y: posição eixo y do cavalo");
		}else{
			/*System.out.println("Executando A*...");
			ResultadosTeste resultadosAEstrela = InteligenciaArtificial.aEstrela();
			System.out.println(resultadosAEstrela.toString());*/

			int tamanhoTabuleiro =Integer.parseInt(args[0]) ;
			int posicaoX =Integer.parseInt(args[1]) ;
			int posicaoY =Integer.parseInt(args[2]) ;
			System.out.println("Tabuleiro: "+tamanhoTabuleiro+"x"+tamanhoTabuleiro+" Cavalo incial: x="+posicaoX+" y="+posicaoY);
			System.out.println("Executando SMA*");
			ResultadosTeste resultadosSmaEstrela = InteligenciaArtificial.smaEstrela(tamanhoTabuleiro,posicaoX,posicaoY,500);
			System.out.println(resultadosSmaEstrela.toString());

			System.out.println("Executando best first search...");
			ResultadosTeste resultadosBestFirst = InteligenciaArtificial.bestFirstSearch(tamanhoTabuleiro,posicaoX,posicaoY);
			System.out.println(resultadosBestFirst.toString());
		}

	}
}