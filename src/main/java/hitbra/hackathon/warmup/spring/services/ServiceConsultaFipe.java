package hitbra.hackathon.warmup.spring.services;

import hitbra.hackathon.warmup.spring.model.Fipe;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceConsultaFipe {

    public String consultarPreco(String rota){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Fipe> response = restTemplate.exchange(
                rota,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Fipe>() { });
        Fipe veiculo = response.getBody();

        return veiculo.getPreco();
    }
}
