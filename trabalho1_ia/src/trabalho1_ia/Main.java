package trabalho1_ia;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {	
		System.out.println("Executando A*...");
		ResultadosTeste resultadosAEstrela = InteligenciaArtificial.aEstrela();
		System.out.println(resultadosAEstrela.toString());
		
		/*ResultadosTeste resultadosSmaEstrela = InteligenciaArtificial.smaEstrela();
		System.out.println(resultadosSmaEstrela.toString());*/
		
	}
}
