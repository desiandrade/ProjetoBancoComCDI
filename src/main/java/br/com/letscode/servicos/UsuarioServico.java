package br.com.letscode.servicos;

import br.com.letscode.dominio.Usuario;
import br.com.letscode.excessoes.PrecondicaoException;
import br.com.letscode.excessoes.UsuarioNaoEncontradoException;

public interface UsuarioServico {

    Usuario create(Usuario usuario) throws PrecondicaoException;

    Usuario login(String nome, Integer senha) throws UsuarioNaoEncontradoException;
}
