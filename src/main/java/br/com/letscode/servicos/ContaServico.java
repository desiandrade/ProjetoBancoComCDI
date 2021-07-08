package br.com.letscode.servicos;

import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;

public interface ContaServico {
    Conta criarConta(ContaEnum contaEnum, Usuario usuario);
}
