package test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import modelo.Cliente;
import modelo.Entrada;
import modelo.Pedido;

class PedidoTest {
	Entrada entrada;
	Entrada[]arrayEntradas= {entrada};
	Cliente cliente;
	Pedido pedido = new Pedido();
	Pedido pedido1 = new Pedido();
	Pedido pedido2 = null;
	Pedido pedido3 = new Pedido();
	@Test
	void test() {
		pedido.setArrayEntradas(arrayEntradas);
		pedido.setCliente(cliente);
		pedido.setId_pedido(1);
		pedido.setPrecioTotal(1.1f);
		
		assertEquals(pedido.getCliente(),cliente);
		assertEquals(pedido.getId_pedido(),1);
		assertEquals(pedido.getPrecioTotal(),1.1f);
		assertTrue(pedido.getArrayEntradas().equals(arrayEntradas));
		assertEquals(pedido.toString(),"Pedido [arrayEntradas=" + Arrays.toString(arrayEntradas) + ", cliente=" + cliente + ", precioTotal="
				+ 1.1f + ", id_pedido=" + 1 + "]");
		pedido1.setId_pedido(1);
		assertTrue(pedido.equals(pedido1));
		
		assertFalse(pedido.equals(pedido2));
		assertTrue(pedido.equals(pedido));
		pedido3.setId_pedido(5);
		assertFalse(pedido.equals(pedido3));
		assertFalse(pedido.equals(pedido.getClass()));
		
	}

}
