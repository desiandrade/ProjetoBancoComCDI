package br.com.letscode;

import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.excessoes.UsuarioNaoEncontradoException;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UsuarioNaoEncontradoException, FileNotFoundException {
        final WeldContainer container = new Weld().initialize();
        final Aplicacao aplicacao = container.select(Aplicacao.class).get();
        //definindo quem é a primeira classe(principal)

        init(aplicacao);
        //metodo para iniciar a aplição chamado no main
    }

    private static void init(Aplicacao aplicacao) throws UsuarioNaoEncontradoException, FileNotFoundException {
        int opcao = 0; //iniciando a opcao selecionada no menu como 0
        System.out.println(">>>>>> Bem vindo! <<<<<<");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nO que gostaria de fazer? \n 1 - Cadastrar Usuario \n 2 - Acessar conta \n 0 - Sair");
            opcao = sc.nextInt();
            definirOpcao(sc, opcao,aplicacao); //metodo para caminhar para opcao desejada
        } while (opcao > 0);
    }

    private static void definirOpcao(Scanner sc, int opcao, Aplicacao aplicacao) throws UsuarioNaoEncontradoException, FileNotFoundException {
        switch (opcao){
            case 1:
                Usuario usuario;
                usuario = aplicacao.createUsuario(sc);
                aplicacao.createConta(sc, usuario);
                break;
            case 2:
                Conta conta = new Conta();
                Usuario usuario1;
                usuario1 = aplicacao.login(sc);
                conta = aplicacao.acessarConta(sc, usuario1);
                System.out.println("Conseguimos acessar sua conta!");
                aplicacao.alterarConta(conta);
                break;
            case 0:
                System.out.println(">>>>>>Finalizando a aplicação<<<<<<\n");
                System.exit(0);
                break;
            default:
                System.out.println(">>>>>>Digite um valor válido!!<<<<<<");

        }
    }
}
