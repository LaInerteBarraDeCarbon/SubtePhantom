package subterraneo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class SistemaDeposito {

	private Deposito[] depositos;
	private int cantidadDepositos;
	private int volumenTotal;
	private int volumenTotalSistema = 0;
	private int cantidadUtilizados = 0;
	private int cantidadDesbordada;
	private int profundidadSinUso;
	
	public SistemaDeposito(final String path){
		try {
			this.leerArchivo(path);
		} catch (IOException e) {
			System.out.println("Error abrir archivo.");
			e.printStackTrace();
		}
	}
	
	public void resolver(){
		if(this.volumenTotal - this.volumenTotalSistema > 0){
			int i = 0;
			while(this.volumenTotal != 0){
				//this.volumenTotal -= (this.depositos[i].getProfundidad() - this.depositos[i+1].getProfundidad()) * this.depositos[i].getSuperficie()
			}
			
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
	public void leerArchivo(final String path) throws IOException {
		try {
			Scanner sc = new Scanner(new File(path));
			this.cantidadDepositos = sc.nextInt();
			if (this.cantidadDepositos > 500) {
				this.limiteSuperado("depósitos");
			}
			this.depositos = new Deposito[this.cantidadDepositos];
			
			for(int i = 0; i < cantidadDepositos; i++){
				depositos[i] = new Deposito(sc.nextInt(), sc.nextInt());
				
				volumenTotalSistema += depositos[i].getVolumen();
			}
			
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
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 */
	public void grabarArchivo(final String path) {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(path));
			if(this.volumenTotal - this.volumenTotalSistema > 0){
				salida.println(this.cantidadUtilizados);
				salida.println(this.profundidadSinUso);
			}
			else
				salida.println("Rebasan: " + this.cantidadDesbordada);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
