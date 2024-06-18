package bind.iot_study_cafe.config;

import bind.iot_study_cafe.repository.member.MemberRepository;
import bind.iot_study_cafe.repository.member.memory.MemoryMemberRepository;
import bind.iot_study_cafe.service.member.MemberService;
import bind.iot_study_cafe.service.member.MemberServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceV1(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
