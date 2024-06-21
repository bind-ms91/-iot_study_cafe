package bind.iot_study_cafe.member.repository;

import bind.iot_study_cafe.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepositoryV2 extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberId(String memberId);

}
