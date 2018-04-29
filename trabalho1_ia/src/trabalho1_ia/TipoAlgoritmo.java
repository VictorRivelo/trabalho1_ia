package trabalho1_ia;

public enum TipoAlgoritmo {
	A_ESTRELA("A*"),
	SMA_ESTRELA("SMA*");
	
	private String nomeAlgoritmo;
	
	private TipoAlgoritmo(String nomeAlgoritmo) {
		this.nomeAlgoritmo = nomeAlgoritmo;
	}
	
	public String toString() {
		return this.nomeAlgoritmo;
	}
}
