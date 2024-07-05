package bind.iotstudycafe.commons.exampleDomain.controller;


import bind.iotstudycafe.commons.exampleDomain.domain.ExampleDomain;
import bind.iotstudycafe.commons.exampleDomain.service.ExampleDomainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/example")
public class ExampleDomainController {

    @Autowired
    private ExampleDomainService exampleDomainService;

    @GetMapping("/{id}")
    public Optional<ExampleDomain> findByIdToEntity(@PathVariable Long id) {

        log.info("ExampleDomainController.findByIdToEntity get id: {}", id);

        return exampleDomainService.findById(id);
    }

}
