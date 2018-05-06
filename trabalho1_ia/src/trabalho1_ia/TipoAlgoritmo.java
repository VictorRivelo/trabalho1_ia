package trabalho1_ia;

public enum TipoAlgoritmo {
	A_ESTRELA("A*"),
	SMA_ESTRELA("SMA*"),
	BEST_FIRST("Greedy best-first search");
	
	private String nomeAlgoritmo;
	
	private TipoAlgoritmo(String nomeAlgoritmo) {
		this.nomeAlgoritmo = nomeAlgoritmo;
	}
	
	public String toString() {
		return this.nomeAlgoritmo;
	}
}