package hitbra.hackathon.warmup.spring.controllers;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.repositories.VeiculoRepository;
import hitbra.hackathon.warmup.spring.services.ServiceOrquestrador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Retorna uma lista de veículo, filtrando por marca ou modelo.")
    public List<Veiculo>  consultarVeiculos (@ApiParam(value = "Marca do veículo", type = "query") @Param(value="marca") String marca, @ApiParam(value = "Modelo do veículo") @Param(value="modelo") String modelo) {
        if(marca==null && modelo==null){
            return repo.findByDisponivel(true);
        } else{
            return repo.findByMarcaOrModelo(marca,modelo);
        }
    }


    @GetMapping("/{placa}")
    @ApiOperation(value = "Busca veículo por placa.")
    public Veiculo consultarVeiculoPorPlaca (@PathVariable String placa) {
        return repo.findByPlaca(placa);
    }


    @PostMapping
    @ApiOperation(value = "Adicionar um veículo para venda.")
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
    @ApiOperation(value = "Altera o status de do veículo para não disponível.")
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
    @ApiOperation(value = "Altera os dados de um veículo.")
    public ResponseEntity<Veiculo> atualizarVeiculo (@PathVariable String placa, @RequestBody Veiculo atualizando) {
        Veiculo veiculo = repo.findByPlaca(placa);

        if(veiculo==null){
            return ResponseEntity.notFound().build();
        }
        repo.save(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/reativar/{placa}")
    @ApiOperation(value = "Altera status de um veículo para ativo.")
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