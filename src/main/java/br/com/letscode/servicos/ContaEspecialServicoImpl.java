package br.com.letscode.servicos;

import br.com.letscode.dao.ContaDao;
import br.com.letscode.dominio.Conta;
import br.com.letscode.dominio.ContaEnum;
import br.com.letscode.dominio.Usuario;
import br.com.letscode.visao.TipoConta;

import javax.inject.Inject;
import java.math.BigDecimal;

@TipoConta(value = ContaEnum.ESPECIAL)
public class ContaEspecialServicoImpl implements ContaServico{

    @Inject
    private ContaDao contaDao;


    @Override
    public Conta criarConta(ContaEnum contaEnum, Usuario usuario) {
        System.out.println("Criando conta especial");
        Conta conta = new Conta();
        conta.setTipoConta("Especial");
        conta.setNome(usuario.getNome());
        conta.setSenha(usuario.getSenha());
        conta.setSaldo(new BigDecimal(0));
        contaDao.criarConta(conta);
        return conta;
    }
}
