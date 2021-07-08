package br.com.letscode.dominio;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Usuario {

    private String nome;
    private Integer idade;
    private Integer senha;
}
