package hitbra.hackathon.warmup.spring.services;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import hitbra.hackathon.warmup.spring.model.Fipe;
import hitbra.hackathon.warmup.spring.model.Message;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
