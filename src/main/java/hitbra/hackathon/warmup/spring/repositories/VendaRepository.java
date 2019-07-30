package hitbra.hackathon.warmup.spring.repositories;
import hitbra.hackathon.warmup.spring.model.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
public interface VendaRepository extends MongoRepository<Venda, String> {

    //public List<Venda> disponivel(String placa);
}
