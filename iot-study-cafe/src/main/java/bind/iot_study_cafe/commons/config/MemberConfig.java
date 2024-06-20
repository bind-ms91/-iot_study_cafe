package bind.iot_study_cafe.commons.config;

import bind.iot_study_cafe.member.repository.MemberRepositoryV1;
import bind.iot_study_cafe.member.repository.memory.MemoryMemberRepositoryV1;
import bind.iot_study_cafe.member.service.MemberService;
import bind.iot_study_cafe.member.service.MemberServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceV1(memberRepositoryV1());
    }

    @Bean
    public MemberRepositoryV1 memberRepositoryV1() {
        return new MemoryMemberRepositoryV1();
    }
}
