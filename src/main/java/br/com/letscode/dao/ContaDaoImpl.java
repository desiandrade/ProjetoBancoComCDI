package br.com.letscode.dao;

import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class ContaDaoImpl implements ContaDao {
    @Override
    public void criarConta(Conta conta) {
        System.out.println("Passou na persistencia conta");
        final var caminhoDoArquivo = "C:\\Users\\desia\\projetos intelij\\bancocdidesi2\\src\\main\\resources\\arquivos/contas" + conta.getNome() + conta.getSenha() + ".txt";
        try (var arquivo = new FileWriter(caminhoDoArquivo, false)) {
            var escreverArquivo = new PrintWriter(arquivo);
            escreverArquivo.printf("%s%n%s%n%s%n%s", conta.getTipoConta(), conta.getNome(), conta.getSenha(), conta.getSaldo());
            System.out.println("Dados da conta salvos com sucesso!");
        } catch (Exception ex) {
            System.out.println("Não foi possível criar o arquivo");
        }
    }

    @Override
    public Conta acessarConta(Usuario usuario1) {
        Conta conta = new Conta();
        final var caminhoArquivo = "C:\\Users\\desia\\projetos intelij\\bancocdidesi2\\src\\main\\resources\\arquivos/contas" + usuario1.getNome() + usuario1.getSenha() + ".txt";
        try (var lerArquivo = new BufferedReader(new FileReader(caminhoArquivo))) {
            String tipoContaArquivo = lerArquivo.readLine();
            String nomeArquivo = lerArquivo.readLine();
            String senhaArquivo = lerArquivo.readLine();
            String saldoArquivo = lerArquivo.readLine();

            conta.setTipoConta(tipoContaArquivo);
            conta.setNome(nomeArquivo);
            Integer senhaTemp = Integer.parseInt(senhaArquivo);
            conta.setSenha(senhaTemp);
            BigDecimal saldoTemp = new BigDecimal(saldoArquivo);
            conta.setSaldo(saldoTemp);
        } catch (Exception ex) {
            System.out.println("Não foi possível ler o arquivo da conta");
        }
        return conta;
    }

    @Override
    public void sacar(ContaEnum contaEnum, Conta conta, BigDecimal valor) throws FileNotFoundException {
        final var caminhoDoArquivo = "C:\\Users\\desia\\projetos intelij\\bancocdidesi2\\src\\main\\resources\\arquivos/contas" + conta.getNome() + conta.getSenha() + ".txt";
        try (var lerArquivo = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String tipoContaArquivo = lerArquivo.readLine();
            String nomeArquivo = lerArquivo.readLine();
            String senhaArquivo = lerArquivo.readLine();
            String saldoArquivo = lerArquivo.readLine();

            conta.setTipoConta(tipoContaArquivo);
            conta.setNome(nomeArquivo);
            Integer senhaTemp = Integer.parseInt(senhaArquivo);
            conta.setSenha(senhaTemp);
            BigDecimal saldoTemp = new BigDecimal(saldoArquivo).subtract(valor);

            BigDecimal limiteMinimo = new BigDecimal(0);
            BigDecimal limiteMaximo = null;
            if (conta.getTipoConta().equalsIgnoreCase("Especial")) {
                limiteMinimo = new BigDecimal(-400);
                limiteMaximo = new BigDecimal(200);
            } else {
                limiteMinimo = new BigDecimal(0);
                limiteMaximo = new BigDecimal(999999999);
            }

            if (saldoTemp.compareTo(limiteMinimo) < 0 || saldoTemp.compareTo(limiteMaximo) > 0) {
                System.err.println("Limite minimo atigido\n Impossível realizar operação");
            } else {
                try (var arquivo = new FileWriter(caminhoDoArquivo, false)) {
                    conta.setSaldo(saldoTemp);
                    var escreverArquivo = new PrintWriter(arquivo);
                    escreverArquivo.printf("%s%n%s%n%s%n%s", conta.getTipoConta(), conta.getNome(), conta.getSenha(), conta.getSaldo());
                    System.out.println("Dados da conta salvos com sucesso!");
                    System.out.println("Seu novo saldo é de " + conta.getSaldo());
                } catch (Exception ex) {
                    System.out.println("Não foi possível criar o arquivo");
                }
            }

        } catch (Exception ex) {
            System.out.println("Não foi possível alterar os dados do arquivo da conta");

        }
    }

    public void depositar(ContaEnum contaEnum, Conta conta, BigDecimal valor) throws FileNotFoundException {
        final var caminhoDoArquivo = "C:\\Users\\desia\\projetos intelij\\bancocdidesi2\\src\\main\\resources\\arquivos/contas" + conta.getNome() + conta.getSenha() + ".txt";
        try (var lerArquivo = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            String tipoContaArquivo = lerArquivo.readLine();
            String nomeArquivo = lerArquivo.readLine();
            String senhaArquivo = lerArquivo.readLine();
            String saldoArquivo = lerArquivo.readLine();

            conta.setTipoConta(tipoContaArquivo);
            conta.setNome(nomeArquivo);
            Integer senhaTemp = Integer.parseInt(senhaArquivo);
            conta.setSenha(senhaTemp);
            BigDecimal saldoTemp = new BigDecimal(saldoArquivo).add(valor);

            BigDecimal limiteMinimo = new BigDecimal(0);
            BigDecimal limiteMaximo = null;
            if (conta.getTipoConta().equalsIgnoreCase("Especial")) {
                limiteMinimo = new BigDecimal(-400);
                limiteMaximo = new BigDecimal(200);
            } else {
                limiteMinimo = new BigDecimal(0);
                limiteMaximo = new BigDecimal(999999999);
            }

            if (saldoTemp.compareTo(limiteMinimo) < 0 || saldoTemp.compareTo(limiteMaximo) > 0) {
                System.err.println("Limite minimo atigido\n Impossível realizar operação");
            } else {
                try (var arquivo = new FileWriter(caminhoDoArquivo, false)) {
                    conta.setSaldo(saldoTemp);
                    var escreverArquivo = new PrintWriter(arquivo);
                    escreverArquivo.printf("%s%n%s%n%s%n%s", conta.getTipoConta(), conta.getNome(), conta.getSenha(), conta.getSaldo());
                    System.out.println("Dados da conta salvos com sucesso!");
                    System.out.println("Seu novo saldo é de " + conta.getSaldo());
                } catch (Exception ex) {
                    System.out.println("Não foi possível criar o arquivo");
                }
            }

        } catch (Exception ex) {
            System.out.println("Não foi possível alterar os dados do arquivo da conta");

        }
    }
}

