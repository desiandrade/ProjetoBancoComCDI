package br.com.letscode.visao;

import br.com.letscode.dominio.Usuario;
import br.com.letscode.excessoes.PrecondicaoException;
import br.com.letscode.excessoes.UsuarioNaoEncontradoException;
import br.com.letscode.servicos.UsuarioServico;

import javax.inject.Inject;
import java.util.Scanner;

public class UsuarioViewImpl implements UsuarioView {

    @Inject
    private UsuarioServico usuarioServico;


    @Override
    public Usuario create(Scanner sc) {
        Usuario usuario = new Usuario();
        System.out.println(">>Informe o nome do usuário<<");
        usuario.setNome(sc.next());
        System.out.println(">>Informe a idade do usuário<<");
        usuario.setIdade((sc.nextInt()));
        System.out.println(">>Informe uma senha numérica de 3 dígitos<<");
        usuario.setSenha(sc.nextInt());
        System.out.printf(">>>>Usuário %s criado com sucesso!<<<< \n", usuario.getNome());
        try {
            return usuarioServico.create(usuario);
        } catch (PrecondicaoException e) {
            System.err.println(e.getMessage());
            return new Usuario();
        }
    }

    @Override
    public Usuario login(Scanner sc) throws UsuarioNaoEncontradoException{
        System.out.println(">>>Faça login para acessar sua conta<<<");
        Usuario usuario = new Usuario();
        System.out.println(">>Informe o nome do usuario<<");
        usuario.setNome(sc.next());
        String nome = usuario.getNome();
        System.out.println(">>Informe a senha do usuario<<");
        usuario.setSenha(sc.nextInt());
        Integer senha = usuario.getSenha();
        try {
            return usuarioServico.login(nome, senha);
        } catch (UsuarioNaoEncontradoException t){
            System.err.println(t.getMessage());
            return null;
        }

    }
}
