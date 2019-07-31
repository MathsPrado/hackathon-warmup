package hitbra.hackathon.warmup.spring;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import hitbra.hackathon.warmup.spring.model.Message;

public class Client {

	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Message>> response = restTemplate.exchange(
				"http://fipeapi.appspot.com/api/1/carros/veiculo/21/001267-0/2013-1.json",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Message>>() { });
		List<Message> messages = response.getBody();
		System.out.println(messages.toString());
	}
}
