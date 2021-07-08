package br.com.letscode.visao;

import br.com.letscode.dao.ContaDao;
import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.servicos.ContaFactory;
import br.com.letscode.servicos.ContaServico;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class ContaViewImpl implements ContaView {

    @Inject
    private ContaFactory contaFactory;

    @Inject
    private UsuarioView usuarioView;
    @Inject
    private ContaDao contaDao;


    @Override
    public Conta criarConta(Scanner sc, Usuario usuario) {
        Conta conta = new Conta();
//        conta.setNome(usuario.getNome());
//        conta.setSenha(usuario.getSenha());
        System.out.println("Que tipo de conta gostaria de criar?\n 1-Simples \n 2-Especial \n 3-Popança");
        Integer opcao = sc.nextInt();
        ContaEnum contaEnum = null;
        switch (opcao) {
            case 1:
                contaEnum = ContaEnum.SIMPLES;
                conta.setTipoConta("Simples");
                break;
            case 2:
                contaEnum = ContaEnum.ESPECIAL;
                conta.setTipoConta("Especial");
                break;
            case 3:
                contaEnum = ContaEnum.POUPANCA;
                conta.setTipoConta("Poupanca");
            default:
                System.out.println("Selecione uma opção válida");

        }
        ContaServico contaServico = contaFactory.createConta(contaEnum, usuario);
        return contaServico.criarConta(contaEnum, usuario);
    }

    @Override
    public void alterarConta(Conta conta) throws FileNotFoundException {
        ContaEnum contaEnum = getContaEnum(conta);

        System.out.printf("Olá, %s. Os dados da sua conta são\n", conta.getNome());
        System.out.printf("Tipo de conta : %s\n", conta.getTipoConta());
        System.out.println("Saldo:" + conta.getSaldo());
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("O que gostaria de fazer? \n 1- Sacar \n 2- Depositar \n 0- Sair");
            opcao = sc.nextInt();
            definirOpcao(sc, opcao, contaEnum, conta);
        } while (opcao > 0);

    }

    private void definirOpcao(Scanner sc, int opcao, ContaEnum contaEnum, Conta conta) throws FileNotFoundException {
        switch (opcao) {
            case 1:
                System.out.println("Quanto deseja sacar?");
                BigDecimal valor = sc.nextBigDecimal();
                contaDao.sacar(contaEnum, conta, valor);
                break;
            case 2:
                System.out.println("Quando deseja depositar?");
                BigDecimal valor1 = sc.nextBigDecimal();
                contaDao.depositar(contaEnum, conta, valor1);
                break;
            case 0:
                System.out.println("Encerrando a aplicação\n");
                System.exit(0);
                break;
            default:
                System.out.println("Digite um valor válido");
        }
    }

    public ContaEnum getContaEnum(Conta conta){
        ContaEnum contaEnum;
        String tipo = conta.getTipoConta();
        if (tipo.equalsIgnoreCase("SIMPLES")){
            contaEnum = ContaEnum.SIMPLES;
        } if (tipo.equalsIgnoreCase("POUPANCA")){
            contaEnum = ContaEnum.POUPANCA;
        } else {
            contaEnum = ContaEnum.ESPECIAL;
        }

        return contaEnum;
    }
}

