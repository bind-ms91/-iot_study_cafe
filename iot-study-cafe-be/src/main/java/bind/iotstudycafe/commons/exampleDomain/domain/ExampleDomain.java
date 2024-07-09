package bind.iotstudycafe.commons.exampleDomain.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExampleDomain {

    private Long id;

    private String loginId;
    private String password;
    private String name;
    private Integer age;

    public ExampleDomain(String loginId, String password, String name, Integer age) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.age = age;
    }
}
