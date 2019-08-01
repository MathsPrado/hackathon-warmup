package hitbra.hackathon.warmup.spring.services;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicoAtualizarVeiculo
{
    @Autowired
    private VeiculoRepository repo;

    public void atualizarStatus( Veiculo veiculo)
    {
        veiculo.setDisponivel(false);
        repo.save(veiculo);
    }
}
