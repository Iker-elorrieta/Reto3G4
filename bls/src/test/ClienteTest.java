package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.Cliente;

class ClienteTest {

	String dni="21";
	String nombre="1";
	String apellido="21";
	char sexo='h';
	String contrasenya="12";
	Cliente cliente = new Cliente (dni,nombre,apellido,sexo,contrasenya);
	Cliente cliente1 = new Cliente (dni,nombre,apellido,sexo,contrasenya);
	Cliente cliente2 = null;
	Cliente cliente3 = new Cliente (dni,nombre,apellido,sexo,contrasenya);
	
	@Test
	void test() {
		cliente.setApellido(apellido);
		cliente.setContrasenya(contrasenya);
		cliente.setDni(dni);
		cliente.setSexo(sexo);
		cliente.setNombre(nombre);
		assertEquals(cliente.getApellido(),apellido);
		assertEquals(cliente.getDni(),dni);

		assertEquals(cliente.getContrasenya(),contrasenya);
		assertEquals(cliente.getNombre(),nombre);
		assertEquals(cliente.getSexo(),sexo);
		assertEquals(cliente.toString(), "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo
				+ ", contrasenya=" + contrasenya + "]");
		assertTrue(cliente.equals(cliente1));
		assertFalse(cliente.equals(cliente2));
		assertTrue(cliente.equals(cliente));
		assertTrue(cliente.equals(cliente3));
		assertFalse(cliente.equals(cliente.getClass()));
		
	}

}
