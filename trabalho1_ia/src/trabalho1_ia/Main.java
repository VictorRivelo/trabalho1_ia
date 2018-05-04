package trabalho1_ia;

public class Main {
	public static void main(String[] args) {	
		/*System.out.println("Executando A*...");
		ResultadosTeste resultadosAEstrela = InteligenciaArtificial.aEstrela();
		System.out.println(resultadosAEstrela.toString());*/
		
		System.out.println("Executando SMA*");
		ResultadosTeste resultadosSmaEstrela = InteligenciaArtificial.smaEstrela(500);
		System.out.println(resultadosSmaEstrela.toString());
		
		/*System.out.println("Executando best first search...");
		ResultadosTeste resultadosBestFirst = InteligenciaArtificial.bestFirstSearch();
		System.out.println(resultadosBestFirst.toString());*/
		
	}
}
