package br.com.mercadolivre.gestaoclientes.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mercadolivre.gestaoclientes.entities.Cliente;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ClienteRepository{

	private static final File FILE = new File("clientes.json");
	@Autowired
	private ObjectMapper mapper;

	public List<Cliente> getList(){
		List<Cliente> clientes = new ArrayList<>();
		try {
			FileInputStream is = new FileInputStream(FILE);
			TypeReference<List<Cliente>> typeReference = new TypeReference<List<Cliente>>() {};
			clientes = mapper.readValue(is, typeReference);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return clientes;
	}
	
	public void add(Cliente cliente) {
		try {
			 List<Cliente> clientes = this.getList();
			 clientes.add(cliente);
			 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			 mapper.writeValue(out, clientes);
			 out.close();
		} catch (Exception e) {
			e.printStackTrace();
        }
	}
	
}