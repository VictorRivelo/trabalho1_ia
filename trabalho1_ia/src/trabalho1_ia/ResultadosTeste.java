package trabalho1_ia;

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
	
	public Long getTempo() {
		return tempo;
	}
	public void setTempo(Long tempo) {
		this.tempo = tempo;
	}
	public Long getNumeroPassos() {
		return numeroPassos;
	}
	public void setNumeroPassos(Long numeroPassos) {
		this.numeroPassos = numeroPassos;
	}
	public Tabuleiro getTabuleiroResultante() {
		return tabuleiroResultante;
	}
	public void setTabuleiroResultante(Tabuleiro tabuleiroResultante) {
		this.tabuleiroResultante = tabuleiroResultante;
	}
	
	public void imprimeResultado() {
		StringBuilder outputString = new StringBuilder();
		outputString.append("O algoritmo "+ tipoAlgoritmo.toString() +" executou em "+tempo.toString()+" segundos.");
		outputString.append("Foram necessários "+tempo.toString()+" passos.");
		outputString.append("O tabuleiro resultante é: ");
		outputString.append(tabuleiroResultante.toString());
		outputString.append(System.lineSeparator());
	}
	
}
