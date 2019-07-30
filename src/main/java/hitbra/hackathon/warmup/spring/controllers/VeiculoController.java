package hitbra.hackathon.warmup.spring.controllers;

import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.repositories.VeiculoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vehicles")
@Api(value = "/vehicles")
public class VeiculoController {

    @Autowired
    private VeiculoRepository repo;

    @GetMapping
    public List<Veiculo>  buscar (@Param(value="marca") String marca,@Param(value="modelo") String modelo) {
        if(marca==null && modelo==null){
            return repo.findAll();
        } else{
            return repo.findByMarcaOrModelo(marca,modelo);
        }
    }

    @PostMapping
    public ResponseEntity<String> adicionar (@RequestBody Veiculo recebendo){
        Veiculo existe = repo.findByPlaca(recebendo.getPlaca());

        if(existe==null){
            repo.save(recebendo);
            return ResponseEntity.ok("Veículo cadastrado com suscesso.");
        }
        return new ResponseEntity<>("Veículo já cadastrado.", HttpStatus.BAD_REQUEST);//.badRequest().body("Veículo já cadastrado.");
    }


    //Colocar a placa do carro desejado para apagar
    @DeleteMapping("/{placa}")
    public ResponseEntity<Veiculo> Delete(@PathVariable String placa) {
        Veiculo veiculo = repo.findByPlaca(placa);

        if(veiculo==null){
            return ResponseEntity.notFound().build();
        }
        repo.delete(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/{placa}")
    public ResponseEntity<Veiculo> Put(@PathVariable String placa, @RequestBody Veiculo atualizando) {
        Veiculo veiculo = repo.findByPlaca(placa);

        if(veiculo==null){
            return ResponseEntity.notFound().build();
        }
        repo.save(veiculo);
        return ResponseEntity.ok(veiculo);
    }



}