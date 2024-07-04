package bind.iotstudycafe.commons.exampleDomain.service;

import bind.iotstudycafe.commons.exampleDomain.domain.ExampleDomain;
import bind.iotstudycafe.commons.exampleDomain.dto.ExampleDomainUpdateDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ExampleDomainService {

//    ExampleDomain save(ExampleDomain exampleDomain);

    Mono<ResponseEntity<ExampleDomain>> findById(Long id);

//    List<ExampleDomain> findAll(ExampleDomain cond);
//
//     Mono<Void> update(Long id, ExampleDomainUpdateDto updateParam);

}
