package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestaRelacionamento {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setTitular("Isaque");
        conta.setAgencia(1212);
        conta.setNumero(1234);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Teste");
        movimentacao.setValor(new BigDecimal(200.0));
        movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        movimentacao.setConta(conta);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.persist(movimentacao);
        em.getTransaction().commit();

        em.close();
    }
}
