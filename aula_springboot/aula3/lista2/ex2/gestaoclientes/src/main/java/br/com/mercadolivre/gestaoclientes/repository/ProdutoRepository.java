package br.com.mercadolivre.gestaoclientes.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mercadolivre.gestaoclientes.entities.Produto;

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
public class ProdutoRepository{

	private static final File FILE = new File("produtos.json");
	@Autowired
	private ObjectMapper mapper;

	public List<Produto> getList(){
		List<Produto> produtos = new ArrayList<>();
		try {
			FileInputStream is = new FileInputStream(FILE);
			TypeReference<List<Produto>> typeReference = new TypeReference<List<Produto>>() {};
			produtos = mapper.readValue(is, typeReference);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return produtos;
	}
	
	public void add(Produto produto) {
		try {
			 List<Produto> produtos = this.getList();
			 produtos.add(produto);
			 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
			 mapper.writeValue(out, produtos);
			 out.close();
		} catch (Exception e) {
			e.printStackTrace();
        }
	}
	
}