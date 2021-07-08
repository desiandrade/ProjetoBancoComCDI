package br.com.letscode.visao;

import br.com.letscode.dominio.Usuario;
import br.com.letscode.excessoes.UsuarioNaoEncontradoException;

import java.util.Scanner;

public interface UsuarioView {
     Usuario create(Scanner sc);
     Usuario login(Scanner sc) throws UsuarioNaoEncontradoException;
}
