package br.com.letscode.servicos;

import br.com.letscode.annotationLiteral.ContaAnnotationLiteral;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

public class ContaFactory {

    @Inject
    @Any
    private Instance<ContaServico> contaServicoInstance;

    public ContaServico createConta(ContaEnum contaEnum, Usuario usuario){
        final ContaAnnotationLiteral literal = new ContaAnnotationLiteral(contaEnum);
        return contaServicoInstance.select(literal).get();
    }
}
