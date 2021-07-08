package br.com.letscode.excessoes;

public class UsuarioNaoEncontradoException extends Exception {

    public UsuarioNaoEncontradoException(){
        super();
    }

    public UsuarioNaoEncontradoException(String message){
        super(message);
    }
}
