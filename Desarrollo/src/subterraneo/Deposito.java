package subterraneo;

/**
 * Clase que muestra la superficie y la profundidad de un depóstio. <br>
 */
public class Deposito {
	private int profundidad;
	private int superficie;
	// private int volumenHastaSiguiente;

	/**
	 * Crea un depósito con su profundidad y su superficie. <br>
	 * 
	 * @param profundidad
	 *            Profundidad del depósito. <br>
	 * @param superficie
	 *            Superficie del depósito. <br>
	 */
	public Deposito(final int profundidad, final int superficie) {
		this.profundidad = profundidad;
		this.superficie = superficie;
	}

	/**
	 * Devuelve la profundidad del depósito. <br>
	 * 
	 * @return profundidad Profundidad del depósito. <br>
	 */
	public int getProfundidad() {
		return profundidad;
	}

	/**
	 * Devuelve la superficie del depósito. <br>
	 * 
	 * @return superficie Superficie del depósito. <br>
	 */
	public int getSuperficie() {
		return superficie;
	}

	/**
	 * Devuelve el volumen del depósito. <br>
	 * 
	 * @return Volumen del depósito. <br>
	 */
	public int getVolumen() {
		return this.superficie * this.profundidad;
	}

	/*
	 * /** Devuelve el volumen de más que tiene un depósito respecto del
	 * siguiente. <br>
	 * 
	 * @param profundidad2
	 * 
	 * @return Volumen de más del depósito respecto del siguiente. <br>
	 * 
	 * public int getVolumenHastaSiguiene(int profundidad2) { return
	 * (this.profundidad - profundidad2) * this.superficie; }
	 */
}
