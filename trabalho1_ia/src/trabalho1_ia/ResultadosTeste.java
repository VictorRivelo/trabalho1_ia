package trabalho1_ia;

//Encapsula os dados que serao usados para comparar os algoritmos
public class ResultadosTeste {
	private TipoAlgoritmo tipoAlgoritmo;
	private Long tempo;
	private Long numeroPassos;
	private Tabuleiro tabuleiroResultante;
	
	public ResultadosTeste(TipoAlgoritmo tipo, Long tempo, Long numeroPassos, Tabuleiro tabuleiro) {
		this.tipoAlgoritmo = tipo;
		this.tempo = tempo;
		this.numeroPassos = numeroPassos;
		this.tabuleiroResultante = tabuleiro;
	}
	//Tempo de execucao do algoritmo
	public Long getTempo() {
		return tempo;
	}
	public void setTempo(Long tempo) {
		this.tempo = tempo;
	}
	
	//Numero de passos que o algoritmo precisou pra encontrar a solucao
	public Long getNumeroPassos() {
		return numeroPassos;
	}
	public void setNumeroPassos(Long numeroPassos) {
		this.numeroPassos = numeroPassos;
	}
	
	//Tabuleiro com a solução
	public Tabuleiro getTabuleiroResultante() {
		return tabuleiroResultante;
	}
	public void setTabuleiroResultante(Tabuleiro tabuleiroResultante) {
		this.tabuleiroResultante = tabuleiroResultante;
	}
	
	//Converte os dados da classe para uma string apresentavel
	public String toString() {
		StringBuilder outputString = new StringBuilder();
		outputString.append("O algoritmo "+ tipoAlgoritmo.toString() +" executou em "+(tempo/1000000000)+" segundos.\n");
		outputString.append("Foram necessários "+numeroPassos+" passos.\n");
		outputString.append("O tabuleiro resultante é: \n");
		outputString.append(tabuleiroResultante.toString());
		outputString.append(System.lineSeparator());
		return outputString.toString();
	}
	
}