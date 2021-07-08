package br.com.letscode.dao;

import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.Usuario;

public interface UsuarioDao {
    Usuario create(Usuario usuario);

    Usuario login(String nome, Integer senha);


}
