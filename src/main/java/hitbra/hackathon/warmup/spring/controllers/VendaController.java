package hitbra.hackathon.warmup.spring.controllers;
import hitbra.hackathon.warmup.spring.model.Venda;
import hitbra.hackathon.warmup.spring.repositories.VendaRepository;
import hitbra.hackathon.warmup.spring.services.ServiceOrquestrador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/sales")
@Api(value = "/v1/sales")
public class VendaController {

    @Autowired
    private VendaRepository repo;

    @Autowired
    private ServiceOrquestrador service;

    @PostMapping
    @ApiOperation(value = "Adicionar uma venda.")
    public ResponseEntity<String> adicionarVenda (@Valid @RequestBody Venda recebendo)
    {
        // MicroService com API
        // service -> ServiceVendaVeiculo.realizarVenda()
        // service -> ServiceAtualizarVeiculo.atualizarStatus()


        // MicroService com ServiceMesh
        //  service -> ServiceOrquestrador.realizarVenda( )
            service.efetivarVenda(recebendo);
            return ResponseEntity.ok("venda cadastrada com suscesso.");
    }

    @GetMapping
    @ApiOperation(value = "Listar todas as vendas.")
    public List<Venda> buscarVendas () {
        return repo.findAll();
    }
    @PutMapping("/{comprovante}")
    @ApiOperation(value = "Atualizar os dados de uma venda.")
    public ResponseEntity<String> atualizarVenda (@PathVariable String comprovante, @RequestBody Venda atualizando) {
        Venda venda = repo.findByComprovante(comprovante);

        if(venda==null){
            return ResponseEntity.notFound().build();
        }
        repo.save(atualizando);
        return ResponseEntity.ok("Venda atualizada com suscesso.");
    }

    @DeleteMapping("/{comprovante}")
    @ApiOperation(value = "Busca uma venda pelo compravante.")
    public ResponseEntity<String> apagarVenda (@PathVariable String comprovante) {
        Venda venda = repo.findByComprovante(comprovante);

        if(venda==null){
            return ResponseEntity.notFound().build();
        }
        repo.delete(venda);
        return ResponseEntity.ok("Venda apagado com suscesso.");
    }
}
