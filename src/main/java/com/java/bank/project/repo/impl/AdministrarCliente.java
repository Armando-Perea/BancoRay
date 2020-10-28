package com.java.bank.project.repo.impl;

import javax.swing.JOptionPane;

import com.java.bank.project.model.Cliente;
import com.java.bank.project.repository.ClientRepository;

public class AdministrarCliente {
	
	public static Cliente crearNuevoCliente(Cliente cliente) {
		
		if(ClientRepository.mapaClientes.add(cliente)) {
		JOptionPane.showMessageDialog(null, "Cliente: "+cliente.getNombre()+" dado de alta con exito!");
		}else {
			JOptionPane.showMessageDialog(null, "Cliente: "+cliente.getNombre()+" ya existe!");	
		}
		return cliente;
	}
	
	public static Cliente borrarCliente(Cliente cliente) {
		if(ClientRepository.mapaClientes.remove(cliente)) {
		JOptionPane.showMessageDialog(null, "Cliente: "+cliente.getNombre()+" dado de baja con exito!");
		}else {
		JOptionPane.showMessageDialog(null, "Cliente: "+cliente.getNombre()+" no pudo ser borrado");	
		}
		return cliente;
	}
	
	public static Cliente desactivarCuentaCliente(Cliente cliente) {
		ClientRepository.mapaClientes.remove(cliente);
		cliente.setCuentaActiva(false);
		ClientRepository.mapaClientes.add(cliente);
		JOptionPane.showMessageDialog(null, "Cliente: "+cliente.getIdCliente()+" desactivado con exito!");
		return cliente;
	}
	
	public static Cliente consultarCliente(Cliente cliente) {
		System.out.println("Consultando Cliente.....");
		for (Cliente cli :  ClientRepository.mapaClientes) {
			if(cli.getIdCliente().equals(cliente.getIdCliente()) && cli.getNip().equals(cliente.getNip())) {
				cliente = cli;
				return cliente;
			}
		}
		return cliente;
	}
	
	public static void revisarClientes() {
		System.out.println("Revisando Clientes.....");
		for (Cliente cli :  ClientRepository.mapaClientes) {
			System.out.println(cli.toString());
		}
	}

}
