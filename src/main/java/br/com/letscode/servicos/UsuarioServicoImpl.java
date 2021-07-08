package br.com.letscode.servicos;

import br.com.letscode.dao.UsuarioDao;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.excessoes.PrecondicaoException;
import br.com.letscode.excessoes.UsuarioNaoEncontradoException;

import javax.inject.Inject;

public class UsuarioServicoImpl implements UsuarioServico{

    @Inject
    UsuarioDao usuarioDao;


    @Override
    public Usuario create(Usuario usuario) throws PrecondicaoException {
        System.out.println("Passou no servico");
        if(usuario.getIdade()>=18){
            return usuarioDao.create(usuario);
        }
        throw new PrecondicaoException("Usuario menor de 18 anos");
    }

    @Override
    public Usuario login(String nome, Integer senha) throws UsuarioNaoEncontradoException {
        return usuarioDao.login(nome,senha);
    }


}
