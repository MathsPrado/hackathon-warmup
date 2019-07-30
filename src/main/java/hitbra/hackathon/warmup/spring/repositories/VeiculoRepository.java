package hitbra.hackathon.warmup.spring.repositories;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VeiculoRepository extends MongoRepository<Veiculo, String> {

    public List<Veiculo> findByModelo(String modelo);
    public List<Veiculo> findByMarca(String marca);
    public Veiculo findByPlaca(String placa);
    public List<Veiculo> findByMarcaOrModelo(String marca, String modelo);
}
