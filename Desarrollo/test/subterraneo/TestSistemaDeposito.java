package subterraneo;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;

public class TestSistemaDeposito {

	private static String archivoIn = "Preparacion de Prueba/Lote de Prueba/Entrada/";
	private static String archivoOut = "Ejecuccion de Prueba/Salida Obtenida/";

	@Test
	public void testEnunciado() {
		SistemaDeposito sistema = new SistemaDeposito(new File(archivoIn + "00_Enunciado.in"),
				new File(archivoOut + "00_Enunciado.out"));
		sistema.resolver();
		sistema.grabarArchivo();
	}

	@Test
	public void testMaximoTodo() {
		SistemaDeposito sistema = new SistemaDeposito(new File(archivoIn + "01_Maximo_Todo.in"),
				new File(archivoOut + "01_Maximo_Todo.out"));
		sistema.resolver();
		sistema.grabarArchivo();
	}
	
	@Test
	public void testExcedePorCantidad() {
		SistemaDeposito sistema = new SistemaDeposito(new File(archivoIn + "02_Excede_Por_Cantidad.in"),
				new File(archivoOut + "02_Excede_Por_Cantidad.out"));
		sistema.resolver();
		sistema.grabarArchivo();
	}
	
	@Test
	public void testFatiga() {
		SistemaDeposito sistema = new SistemaDeposito(new File(archivoIn + "03_Fatiga.in"),
				new File(archivoOut + "03_Fatiga.out"));
		sistema.resolver();
		sistema.grabarArchivo();
	}
	
	@Test
	public void testTanquesEscalares() {
		SistemaDeposito sistema = new SistemaDeposito(new File(archivoIn + "04_Tanques_Escalares.in"),
				new File(archivoOut + "04_Tanques_Escalares.out"));
		sistema.resolver();
		sistema.grabarArchivo();
	}
	
	@Test
	public void testExcedePorSuperficie() {
		SistemaDeposito sistema = new SistemaDeposito(new File(archivoIn + "05_Excede_Por_Superficie.in"),
				new File(archivoOut + "05_Excede_Por_Superficie.out"));
		sistema.resolver();
		sistema.grabarArchivo();
	}
	
	@Test
	public void testExcedePorProfundidad() {
		SistemaDeposito sistema = new SistemaDeposito(new File(archivoIn + "06_Excede_Por_Profundidad.in"),
				new File(archivoOut + "06_Excede_Por_Profundidad.out"));
		sistema.resolver();
		sistema.grabarArchivo();
	}

	@Ignore
	public void crearCasos() {
		SistemaDeposito sistema = new SistemaDeposito(new File(archivoIn + "01_Maximo_Todo.in"),
				new File(archivoOut + "01_Maximo_Todo.out"));
		sistema.crearCasos(archivoIn + "salida.in");
	}
}
