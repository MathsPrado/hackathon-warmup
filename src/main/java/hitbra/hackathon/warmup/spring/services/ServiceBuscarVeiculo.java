package hitbra.hackathon.warmup.spring.services;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.model.Venda;
import hitbra.hackathon.warmup.spring.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBuscarVeiculo {

    @Autowired
    private VeiculoRepository repo;

    public Veiculo buscarVeiculo(Venda venda){
        return repo.findByPlaca(venda.getPlaca());
    }

}
