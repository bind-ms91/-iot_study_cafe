package bind.iot_study_cafe.member.repository;

import bind.iot_study_cafe.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoryV2 extends JpaRepository<Member, Long> {

}
