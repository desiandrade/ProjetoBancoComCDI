package br.com.letscode.dominio;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Conta {
    private String nome;
    private Integer senha;
    private BigDecimal saldo;
    private String tipoConta;
}
