package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		// instanciando o entity manager, com as configura�oes do arquivo persistence
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		// aqui criamos a conex�o com o banco de dados
		EntityManager em = emf.createEntityManager();
		
		// buscando os dados no banco de dados
		// o .find busca uma informa��o atrav�s do id
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto");
		em.close();
		emf.close();
	}

}
