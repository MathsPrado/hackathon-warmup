package hitbra.hackathon.warmup.spring.controllers;
import hitbra.hackathon.warmup.spring.model.Veiculo;
import hitbra.hackathon.warmup.spring.model.Venda;
import hitbra.hackathon.warmup.spring.repositories.VendaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sales")
@Api(value = "/sales")
public class VendaController {

    @Autowired
    private VendaRepository repo;

    @PostMapping
    public ResponseEntity<String> adicionarVenda (@Valid @RequestBody Venda recebendo){
            //Venda venda = new Venda();
            //venda = recebendo;
            repo.save(recebendo);
            return ResponseEntity.ok("venda cadastrada com suscesso.");
    }

    @GetMapping
    public List<Venda> buscarVendas () {
        return repo.findAll();
    }
    @PutMapping("/{comprovante}")
    public ResponseEntity<String> atualizarVenda (@PathVariable String comprovante, @RequestBody Venda atualizando) {
        Venda venda = repo.findByComprovante(comprovante);

        if(venda==null){
            return ResponseEntity.notFound().build();
        }
        repo.save(atualizando);
        return ResponseEntity.ok("Venda atualizada com suscesso.");
    }

    @DeleteMapping("/{comprovante}")
    public ResponseEntity<String> apagarVenda (@PathVariable String comprovante) {
        Venda venda = repo.findByComprovante(comprovante);

        if(venda==null){
            return ResponseEntity.notFound().build();
        }
        repo.delete(venda);
        return ResponseEntity.ok("Venda apagado com suscesso.");
    }



}
