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
    private ServiceConsultaFipe serviceConsultaFipe;

    @Autowired
    private ServicoVendaVeiculo serviceVenda;
    //endregion

    public String consultaPrecoFipe(Veiculo veiculo)
    {

        String idMarca = veiculo.getIdFipe();
        String codFipe = veiculo.getCodigoFipe();
        String anoCarro = veiculo.getAno().toString() + "-1";

        String rota = "https://fipeapi.appspot.com/api/1/carros/veiculo/" + idMarca + "/" + codFipe
                + "/" + anoCarro + ".json";

        return serviceConsultaFipe.consultarPreco(rota);
    }

    public void efetivarVenda(Venda venda)
    {
        serviceVenda.realizarVenda(venda);
        Veiculo veiculo = serviceBuscarVeiculo.buscarVeiculo(venda);
        serviceAtualizar.atualizarStatus(veiculo);

    }
}
