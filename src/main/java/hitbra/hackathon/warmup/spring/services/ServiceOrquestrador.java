package hitbra.hackathon.warmup.spring.services;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.model.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrquestrador
{
    //region @Autowired
    @Autowired
    private ServicoAtualizarVeiculo serviceAtualizar;

    @Autowired
    private ServiceBuscarVeiculo serviceBuscarVeiculo;

    @Autowired
    private ServicoVendaVeiculo serviceVenda;
    //endregion

    public void efetivarVenda(Venda venda)
    {
        serviceVenda.realizarVenda(venda);
        Veiculo veiculo = serviceBuscarVeiculo.buscarVeiculo(venda);
        serviceAtualizar.atualizarStatus(veiculo);
    }
}
