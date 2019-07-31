package hitbra.hackathon.warmup.spring.controllers;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.repositories.VeiculoRepository;
import hitbra.hackathon.warmup.spring.services.ServiceOrquestrador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/vehicles")
@Api(value = "/v1/vehicles")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repo;

    @Autowired
    private ServiceOrquestrador serviceOrq;

    @GetMapping
    public List<Veiculo>  consultarVeiculos (@Param(value="marca") String marca,@Param(value="modelo") String modelo) {
        if(marca==null && modelo==null){
            return repo.findByDisponivel(true);
        } else{
            return repo.findByMarcaOrModelo(marca,modelo);
        }
    }


    @GetMapping("/{placa}")
    public Veiculo consultarVeiculoPorPlaca (@PathVariable String placa) {
        return repo.findByPlaca(placa);
    }


    @PostMapping
    public ResponseEntity<String> adicionarVeiculo (@Valid @RequestBody Veiculo recebendo){
        Veiculo existe = repo.findByPlaca(recebendo.getPlaca());

        if(existe==null){
            recebendo.setDisponivel(true);
            recebendo.setPrecoFipe(serviceOrq.consultaPrecoFipe(recebendo));
            repo.save(recebendo);
            return ResponseEntity.ok("Veículo cadastrado com suscesso.");
        }

        if(!existe.isDisponivel()){
            return new ResponseEntity<>("Veiculo já foi cadastrado anteriormente, para Reativalo atualize o status dele para disponível", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Veículo já cadastrado.", HttpStatus.BAD_REQUEST);//.badRequest().body("Veículo já cadastrado.");
    }



    @DeleteMapping("/{placa}")
    public ResponseEntity<Veiculo> apagarVeiculo (@PathVariable String placa) {
        Veiculo veiculo = repo.findByPlaca(placa);

        if(veiculo==null){
            return ResponseEntity.notFound().build();
        }
        veiculo.setDisponivel(false);
        repo.save(veiculo);

        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/{placa}")
    public ResponseEntity<Veiculo> atualizarVeiculo (@PathVariable String placa, @RequestBody Veiculo atualizando) {
        Veiculo veiculo = repo.findByPlaca(placa);

        if(veiculo==null){
            return ResponseEntity.notFound().build();
        }
        repo.save(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/reativar/{placa}")
    public ResponseEntity<Veiculo> reativarVeiculo (@PathVariable String placa) {
        Veiculo veiculo = repo.findByPlaca(placa);

        if(veiculo==null){
            return ResponseEntity.notFound().build();
        }
        veiculo.setDisponivel(true);
        repo.save(veiculo);

        return ResponseEntity.ok(veiculo);
    }




}