package br.com.alura.jpa.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Isaque");
        conta.setAgencia(1212);
        conta.setNumero(1234);

        em.getTransaction().begin();

        em.persist(conta);

        em.getTransaction().commit();
        em.close();

        EntityManager em2 = emf.createEntityManager();
        em2.getTransaction().begin();
        conta.setTitular("Lucas");
        em2.merge(conta);
        conta.setTitular("Isaq");
        em2.getTransaction().commit();
    }
}
