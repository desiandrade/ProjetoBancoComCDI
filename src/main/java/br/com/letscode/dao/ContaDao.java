package br.com.letscode.dao;

import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

public interface ContaDao {
    void criarConta(Conta conta);

    Conta acessarConta(Usuario usuario1);

    void sacar(ContaEnum contaEnum, Conta conta, BigDecimal valor) throws FileNotFoundException;
    void depositar(ContaEnum contaEnum, Conta conta, BigDecimal valor) throws FileNotFoundException;
}
