package bind.iot_study_cafe.repository.member;

import bind.iot_study_cafe.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);

    List<Member> findAll(MemberSearchCond cond);

    void update(Long id, MemberUpdateDto updateParam);

    void delete(Long id);

}
