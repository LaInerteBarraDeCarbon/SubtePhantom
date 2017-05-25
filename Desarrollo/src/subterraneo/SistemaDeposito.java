package subterraneo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase que administra un sistema de depósitos. <br>
 */
public class SistemaDeposito extends EjercicioOIA {

	/**
	 * Depósitos del sistema. <br>
	 */
	private Deposito[] depositos;
	/**
	 * Guarda la diferencia de profundidad de un depósito con respecto al
	 * despósito siguiente. <br>
	 */
	private int[] diferenciaProfundidad;
	/**
	 * Cantidad de depósitos del sistema. <br>
	 */
	private int cantidadDepositos;
	/**
	 * Volumen a cargar. <br>
	 */
	private int volumenTotal;
	/**
	 * Volumen total de todos los depósitos. <br>
	 */
	private int volumenTotalSistema = 0;
	/**
	 * Cantidad de depósitos utilizados. <br>
	 */
	private int cantidadUtilizados = 0;
	/**
	 * Cantidad desbordada del volumen a almacenar. <br>
	 */
	private int cantidadDesbordada;
	/**
	 * Distancia entre el suelo hasta el fluido. <br>
	 */
	private int distanciaSueloFluido;

	/**
	 * Crea un sistema de depósito, cargando de archivo la cantidad de
	 * depósitos, la profundidad y superficie de cada uno, y el volumen a
	 * almacenar. <br>
	 * 
	 * @param pathEntrada
	 *            Dirección del archivo .in. <br>
	 * @param pathSalida
	 *            Dirección del archivo .out. <br>
	 */
	public SistemaDeposito(File pathEntrada, File pathSalida) {
		super(pathEntrada, pathSalida);
		try {
			this.leerArchivo(super.entrada);
		} catch (IOException e) {
			System.out.println("Error abrir archivo.");
			e.printStackTrace();
		}
	}

	/**
	 * Almacena el petróleo en los distintos depósitos, indicando cuántos
	 * depósitos se utilizaron y la distancia del líquido al piso con respecto
	 * al último depósito cargado. En el caso de rebasar el contenido, se avisa
	 * cuantos litros rebasan. <br>
	 */
	public void resolver() {
		if (this.volumenTotalSistema - this.volumenTotal > 0) {
			int sumaSuperficies = 0;
			int volumenActual = 0;
			while (this.volumenTotal > volumenActual) {
				// this.volumenTotal -= (this.depositos[i].getProfundidad() -
				// this.depositos[i+1].getProfundidad()) *
				// this.depositos[i].getSuperficie()
				sumaSuperficies += this.depositos[this.cantidadUtilizados].getSuperficie();
				volumenActual += sumaSuperficies * this.diferenciaProfundidad[this.cantidadUtilizados];
				this.cantidadUtilizados++;
			}
			if (volumenActual > this.volumenTotal && this.cantidadDepositos >= this.cantidadUtilizados) {
				this.cantidadUtilizados--;
			}
			this.distanciaSueloFluido = ((volumenActual - this.volumenTotal) / sumaSuperficies)
					/ this.cantidadUtilizados;
		} else {
			this.cantidadDesbordada = this.volumenTotal - this.volumenTotalSistema;
		}
	}

	/**
	 * Lee el archivo con la secuencia de latas. <br>
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 * @throws IOException
	 *             Error al abrir el archivo. <br>
	 */
	public void leerArchivo(final File path) throws IOException {
		try {
			Scanner sc = new Scanner(path);
			this.cantidadDepositos = sc.nextInt();
			if (this.cantidadDepositos > 500) {
				this.limiteSuperado("depósitos");
			}
			this.depositos = new Deposito[this.cantidadDepositos];
			this.diferenciaProfundidad = new int[this.cantidadDepositos];
			this.depositos[0] = new Deposito(sc.nextInt(), sc.nextInt());
			this.diferenciaProfundidad[0] = this.depositos[0].getProfundidad();
			volumenTotalSistema += depositos[0].getVolumen();
			for (int i = 1; i < this.cantidadDepositos - 1; i++) {
				this.depositos[i] = new Deposito(sc.nextInt(), sc.nextInt());
				this.diferenciaProfundidad[i] = this.depositos[i].getProfundidad();
				this.diferenciaProfundidad[i - 1] -= this.diferenciaProfundidad[i];
				volumenTotalSistema += depositos[i].getVolumen();
			}
			this.depositos[cantidadDepositos - 1] = new Deposito(sc.nextInt(), sc.nextInt());
			this.diferenciaProfundidad[cantidadDepositos - 1] = this.depositos[cantidadDepositos - 1].getProfundidad();
			this.diferenciaProfundidad[cantidadDepositos - 2] -= this.depositos[cantidadDepositos - 1].getProfundidad();
			volumenTotalSistema += depositos[cantidadDepositos - 1].getVolumen();
			volumenTotal = sc.nextInt();
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Indica que supera el límite aceptado. <br>
	 */
	private void limiteSuperado(final String text) {
		throw new ArithmeticException("Cantidad superada de " + text + ".");
	}

	/**
	 * Graba el archivo con los resultados. <br>
	 */
	public void grabarArchivo() {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(super.salida));
			if (this.volumenTotalSistema - this.volumenTotal > 0) {
				salida.println(this.cantidadUtilizados);
				salida.println(this.distanciaSueloFluido);
			} else
				salida.println("Rebasan: " + this.cantidadDesbordada);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void crearCasos(final String path) {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(path));
			int volumen = 1000000;
			int profundidad = 200;
			int superficie = 400;
			int cantidad = 500;
			salida.println(cantidad);
			for (int i = 0; i < cantidad; i++) {
				salida.println(profundidad + " " + superficie);
			}
			salida.print(volumen);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
