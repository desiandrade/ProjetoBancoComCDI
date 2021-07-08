package br.com.letscode;

import br.com.letscode.dao.ContaDao;
import br.com.letscode.dao.UsuarioDao;
import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.excessoes.UsuarioNaoEncontradoException;
import br.com.letscode.visao.ContaView;
import br.com.letscode.visao.UsuarioView;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aplicacao {
    @Inject
    private UsuarioView usuarioView;

    @Inject
    private ContaView contaView;

    @Inject
    private ContaDao contaDao;



    public Usuario createUsuario(Scanner sc){
        return usuarioView.create(sc);
        //getUsuarios().add(usuarioView.create(sc)); quando tiver uma lista de usuarios

    }

    public Usuario login (Scanner sc) throws UsuarioNaoEncontradoException {
        return usuarioView.login(sc);

    }

    public Conta createConta(Scanner sc, Usuario usuario) {
        return contaView.criarConta(sc, usuario);
    }

    public Conta acessarConta(Scanner sc, Usuario usuario1) {
        return contaDao.acessarConta(usuario1);
    }

    public void alterarConta(Conta conta) throws FileNotFoundException {
        contaView.alterarConta(conta);
    }
}
