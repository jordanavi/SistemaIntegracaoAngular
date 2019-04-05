package com.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.biblioteca.model.Categoria;
import com.biblioteca.model.Editora;
import com.biblioteca.repository.CategoriaRepository;
import com.biblioteca.repository.EditoraRepository;

@SpringBootApplication
public class SistemaEcommerceServerApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repoCategoria;
	@Autowired
	private EditoraRepository repoEditora;

	public static void main(String[] args) {
		SpringApplication.run(SistemaEcommerceServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria("Iracema - José de Alencar");
		Categoria cat2 = new Categoria("O Guarani - José de Alencar");
		Categoria cat3 = new Categoria("Marimbondos de Fogo - José Sarney");
		Categoria cat4 = new Categoria("Saraminda- José Sarney");
		Categoria cat5 = new Categoria("Como Desaparecer Completamente - André de Leones");
		Categoria cat6 = new Categoria("O Diário de um Mago - Paulo Coelho");
		Categoria cat7 = new Categoria("Brida- Paulo Coelho");
		Categoria cat8 = new Categoria("O Alquimista - Paulo Coelho");
		Categoria cat9 = new Categoria("No Buraco - Tony Bellotto");
		Categoria cat10 = new Categoria("Mentes Perigosas - Ana Beatriz Barbosa Silva");
		Categoria cat11 = new Categoria("O Tigre Na Sombra - Lya Luft");
		Categoria cat12 = new Categoria("O Lado Fatal - Lya Luft");
		Categoria cat13 = new Categoria("O Crepúsculo do Macho - Fernando Gabeira");
		Categoria cat14 = new Categoria("O Xangô de Baker Street - Jô Soares");
		Categoria cat15 = new Categoria("As Esganadas - Jô Soares");
		Categoria cat16 = new Categoria("Mar Morto - Jorge Amado");
		Categoria cat17 = new Categoria("Memórias de um Sargento de Milícias - Manuel Antônio de Almeida");
		Categoria cat18 = new Categoria("Estorvo - Chico Buarque");
		Categoria cat19 = new Categoria("O Mundo Não é Chato - Caetano Veloso");
		Categoria cat20 = new Categoria("Triângulo no Ponto - Eros Grau");
		Categoria cat21 = new Categoria("A Paixão Segundo G.H. - Clarice Lispector ");
		Categoria cat22 = new Categoria("O Inverno das Fadas - Carolina Munhóz");
		Categoria cat23 = new Categoria("O Dia Mastroianni - João Paulo Cuenca");
		Categoria cat24 = new Categoria("A Vida Sabe o Que Faz - Zibia Gasparetto");
		Categoria cat25 = new Categoria("A Escrava Isaura - Bernardo Guimarães");
		Categoria cat26 = new Categoria("Farewell - Carlos Drummond de Andrade ");
		Categoria cat27 = new Categoria("Rosinha, Minha Canoa - José Mauro de Vasconcelos");
		Categoria cat28 = new Categoria("Obra Completa - J. G. de Araújo Jorge");
		Categoria cat29 = new Categoria("Guia-Mapa de Gabriel Arcanjo - Nélida Piñon");
		this.repoCategoria.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7,cat8,cat9,cat10,cat11,cat12,cat13,
				cat14,cat15,cat16,cat17,cat18,cat19,cat20,cat21,cat22,cat23,cat24,cat25,cat26,cat27,cat28,cat29));

		Editora edit1 = new Editora("EBAL‎");
		Editora edit2 = new Editora("Editora Bloch‎");
		Editora edit3 = new Editora("Editora Confiança‎");
		Editora edit4 = new Editora("Editora Europa‎");
		Editora edit5 = new Editora("Editora Globo‎");
		Editora edit6 = new Editora("Editora Positivo‎");
		Editora edit7 = new Editora("Editoras anarquistas do Brasil‎");
		Editora edit8 = new Editora("Editoras de banda desenhada do Brasil‎");
		Editora edit9 = new Editora("Editoras de RPG do Brasil‎");
		Editora edit10 = new Editora("Editoras do Rio de Janeiro‎");
		Editora edit11 = new Editora("Geração Editorial‎");
		Editora edit12 = new Editora("Grupo Editorial Record‎");
		Editora edit13 = new Editora("Grupo Escala de Publicações‎");
		this.repoEditora.saveAll(Arrays.asList(edit1,edit2,edit3,edit4,edit5,edit6,edit7,edit8,edit9,edit10,edit11,edit12,edit13));

	}

}
