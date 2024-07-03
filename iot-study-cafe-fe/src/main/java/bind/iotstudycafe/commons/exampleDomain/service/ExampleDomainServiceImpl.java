package bind.iotstudycafe.commons.exampleDomain.service;

import bind.iotstudycafe.commons.exampleDomain.domain.ExampleDomain;
import bind.iotstudycafe.commons.exampleDomain.dto.ExampleDomainUpdateDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExampleDomainServiceImpl implements ExampleDomainService{

    @Value("${domain.iot-cafe-be.endpoint}")
    private String iotCafeBeEndpoint;

    private static final String RequestMapping = "/example-domain/";

    @Autowired
    private final WebClient.Builder webClientBuilder;


    @Override
    public ExampleDomain save(ExampleDomain exampleDomain) {

        return null;
    }

    @Override
    public Mono<ExampleDomain> findById(Long id) {

        WebClient webClient = webClientBuilder(iotCafeBeEndpoint);

        return webClient.get()
                .uri(RequestMapping+id)
                .retrieve()
                .bodyToMono(ExampleDomain.class);
    }

    @Override
    public List<ExampleDomain> findAll(ExampleDomain cond) {
        return List.of();
    }

    @Override
    public Mono<Void> update(Long id, ExampleDomainUpdateDto updateParam) {

        WebClient webClient = webClientBuilder(iotCafeBeEndpoint);

        return webClient.post()
                .uri(RequestMapping+id+"/edit")
                .bodyValue()
    }

    private WebClient webClientBuilder(String iotCafeBeEndpoint) {

        return webClientBuilder
                .baseUrl(iotCafeBeEndpoint)
                .build();
    }
}
