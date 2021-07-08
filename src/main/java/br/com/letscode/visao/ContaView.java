package br.com.letscode.visao;

import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.Usuario;


import java.io.FileNotFoundException;
import java.util.Scanner;

public interface ContaView {


    Conta criarConta(Scanner sc, Usuario usuario);

    void alterarConta(Conta conta) throws FileNotFoundException;
}
