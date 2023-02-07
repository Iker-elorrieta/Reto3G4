package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import modelo.Cliente;

class ClienteTest {
	int id_cliente=1;
	int id_cliente0=0;
	String dni="21";
	String nombre="1";
	String apellido="21";
	char sexo='h';
	String contrasenya="12";
	Cliente cliente = new Cliente (id_cliente,dni,nombre,apellido,sexo,contrasenya);
	Cliente cliente1 = new Cliente (id_cliente,dni,nombre,apellido,sexo,contrasenya);
	Cliente cliente2 = null;
	Cliente cliente3 = new Cliente (id_cliente0,dni,nombre,apellido,sexo,contrasenya);
	
	@Test
	void test() {
		cliente.setApellido(apellido);
		cliente.setContraseña(contrasenya);
		cliente.setDni(dni);
		cliente.setId_cliente(id_cliente);
		cliente.setSexo(sexo);
		cliente.setNombre(nombre);
		assertEquals(cliente.getApellido(),apellido);
		assertEquals(cliente.getDni(),dni);
		assertEquals(cliente.getId_cliente(),id_cliente);

		assertEquals(cliente.getContraseña(),contrasenya);
		assertEquals(cliente.getNombre(),nombre);
		assertEquals(cliente.getSexo(),sexo);
		assertEquals(cliente.toString(),"id_cliente=" + id_cliente + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", sexo="
				+ sexo + ", contraseña=" + contrasenya);
		assertTrue(cliente.equals(cliente1));
		assertFalse(cliente.equals(cliente2));
		assertTrue(cliente.equals(cliente));
		assertTrue(cliente.equals(cliente3));
		assertFalse(cliente.equals(cliente.getClass()));
		
	}

}
