package com.retribution.cursomc;

import com.retribution.cursomc.domain.CategoriaDomain;
import com.retribution.cursomc.domain.ProdutoDomain;
import com.retribution.cursomc.repositories.CategoriaRepository;
import com.retribution.cursomc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	//Chama o objeto que faz contato com o banco de dados para que possa ser usado na classe
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	//Criando metodo para instanciação automatica dos objetos do banco de dados assim que o programa for executado
	@Override
	public void run(String... args) throws Exception {
		//Instacia o objeto categoria
		CategoriaDomain cat1 = new CategoriaDomain(null, "Informática");
		CategoriaDomain cat2 = new CategoriaDomain(null, "Escritório");

		//Instanciando os produtos da lista de produtos
		ProdutoDomain p1 = new ProdutoDomain(null, "Computador", 2000.00);
		ProdutoDomain p2 = new ProdutoDomain(null, "Impressora", 800.00);
		ProdutoDomain p3 = new ProdutoDomain(null, "Mouse", 80.00);

		//Juntando a lista de produtos de acordo com suas categorias, usando a lista de produtos
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		//Juntado as listas de categorias de acordo com seus produtos, usando a lista de categorias
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		//Salva todos os dados apos fazer contato com o banco de dados
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
}
