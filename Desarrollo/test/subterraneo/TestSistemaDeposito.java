package subterraneo;

import static org.junit.Assert.*;

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

	@Ignore
	public void crearCasos() {
		SistemaDeposito sistema = new SistemaDeposito(new File(archivoIn + "01_Maximo_Todo.in"),
				new File(archivoOut + "01_Maximo_Todo.out"));
		sistema.crearCasos(archivoIn + "salida.in");
	}
}
