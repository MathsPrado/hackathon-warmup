package hitbra.hackathon.warmup.spring.services;

import hitbra.hackathon.warmup.spring.model.Venda;
import hitbra.hackathon.warmup.spring.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicoVendaVeiculo
{
    @Autowired
    private VendaRepository repo;

    public void realizarVenda( Venda venda )
    {
        repo.save(venda);
    }
}
