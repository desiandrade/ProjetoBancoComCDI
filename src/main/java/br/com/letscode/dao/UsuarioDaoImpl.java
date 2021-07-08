package br.com.letscode.dao;


import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class UsuarioDaoImpl implements UsuarioDao {


    @Override
    public Usuario create(Usuario usuario) {
        System.out.println("Passou na persistencia");
        final var caminhodoArquivo = "C:\\Users\\desia\\projetos intelij\\bancocdidesi2\\src\\main\\resources\\arquivos/usuarios.txt";
        try (var arquivo = new FileWriter(caminhodoArquivo, false)){
            var escreverArquivo = new PrintWriter(arquivo);
            escreverArquivo.printf("%s%n%s%n%s" ,usuario.getNome(),usuario.getIdade(),usuario.getSenha());
        } catch (Exception ex){
            System.out.println("Não foi possível criar o arquivo");
        }
        return usuario;
    }

    @Override
    public Usuario login(String nome, Integer senha) {
        String senhaTemp = Integer.toString(senha);
        Usuario usuario = new Usuario();
        final var caminhodoArquivo = "C:\\Users\\desia\\projetos intelij\\bancocdidesi2\\src\\main\\resources\\arquivos/usuarios.txt";
        try (var lerArquivo = new BufferedReader(new FileReader(caminhodoArquivo))){
           String nomeArquivo = lerArquivo.readLine();
           String idadeArquivo = lerArquivo.readLine();
           String senhaArquivo = lerArquivo.readLine();
           if(nomeArquivo.equalsIgnoreCase(nome) && senhaArquivo.equals(senhaTemp)){
               usuario.setNome(nomeArquivo);
               Integer idadeTemp = Integer.parseInt(idadeArquivo);
               usuario.setIdade(idadeTemp);
               Integer senhaTemp2 = Integer.parseInt(senhaArquivo);
               usuario.setSenha(senhaTemp2);
               System.out.println(">>>Login efetuado com sucesso!<<<");
           } else {
               System.out.println("Usuario ou senha incorretos");
           }

        } catch (Exception ex) {
            System.out.println("Não foi possível ler o arquivo");
        }
        return usuario;
    }






}
