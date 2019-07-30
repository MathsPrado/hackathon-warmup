package hitbra.hackathon.warmup.spring.controllers;
import hitbra.hackathon.warmup.spring.model.Venda;
import hitbra.hackathon.warmup.spring.repositories.VendaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@Api(value = "/sales")
public class VendaController {

    @Autowired
    private VendaRepository repo;

    @PostMapping
    public ResponseEntity<String> adicionar (@RequestBody Venda recebendo){
            repo.save(recebendo);
            return ResponseEntity.ok("venda cadastrada com suscesso.");

    }

    @GetMapping
    public List<Venda> buscar () {
        return repo.findAll();
    }


}
