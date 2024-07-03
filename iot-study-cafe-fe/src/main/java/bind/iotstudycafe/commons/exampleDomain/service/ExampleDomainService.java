package bind.iotstudycafe.commons.exampleDomain.service;

import bind.iotstudycafe.commons.exampleDomain.domain.ExampleDomain;
import bind.iotstudycafe.commons.exampleDomain.dto.ExampleDomainUpdateDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ExampleDomainService {

    ExampleDomain save(ExampleDomain exampleDomain);

    Mono<ExampleDomain> findById(Long id);

    List<ExampleDomain> findAll(ExampleDomain cond);

     Mono<Void> update(Long id, ExampleDomainUpdateDto updateParam);

}
