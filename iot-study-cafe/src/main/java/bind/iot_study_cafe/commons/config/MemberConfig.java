package bind.iot_study_cafe.commons.config;

import bind.iot_study_cafe.member.repository.MemberRepositoryV1;
import bind.iot_study_cafe.member.repository.memory.MemoryMemberRepository;
import bind.iot_study_cafe.member.service.MemberService;
import bind.iot_study_cafe.member.service.MemberServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceV1(memberRepository());
    }

    @Bean
    public MemberRepositoryV1 memberRepository() {
        return new MemoryMemberRepository();
    }
}
