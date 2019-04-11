package com.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biblioteca.model.AreaConhecimento;
import com.biblioteca.model.Disciplina;
import com.biblioteca.repository.AreaConhecimentoRepository;
import com.biblioteca.repository.DisciplinaRepository;

@SpringBootApplication
public class SistemaIngegracaoServerApplication implements CommandLineRunner {

	@Autowired
	private DisciplinaRepository repoDisciplina;
	@Autowired
	private AreaConhecimentoRepository repoAreaConhecimento;

	public static void main(String[] args) {
		SpringApplication.run(SistemaIngegracaoServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*Disciplina disc1 = new Disciplina("Historia");
		Disciplina disc2 = new Disciplina("Matematica");
			this.repoDisciplina.saveAll(Arrays.asList(disc1,disc2));

		AreaConhecimento edit1 = new AreaConhecimento("Ciencias Humanas");
		AreaConhecimento edit2 = new AreaConhecimento("Ciencias Exatas‎");
			this.repoAreaConhecimento.saveAll(Arrays.asList(edit1,edit2));*/
	}
}
