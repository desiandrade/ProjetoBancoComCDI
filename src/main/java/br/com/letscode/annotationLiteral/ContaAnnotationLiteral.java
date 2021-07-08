package br.com.letscode.annotationLiteral;

import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.visao.TipoConta;

import javax.enterprise.util.AnnotationLiteral;

public class ContaAnnotationLiteral extends AnnotationLiteral <TipoConta> implements TipoConta{

    private final ContaEnum contaEnum;

    public ContaAnnotationLiteral(ContaEnum contaEnum){
        this.contaEnum = contaEnum;
    }

    @Override
    public ContaEnum value() {
        return contaEnum;
    }
}
