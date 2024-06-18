package bind.iot_study_cafe.service.member;

import bind.iot_study_cafe.domain.member.Member;
import bind.iot_study_cafe.repository.member.MemberSearchCond;
import bind.iot_study_cafe.repository.member.MemberUpdateDto;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member save(Member member);

    Optional<Member> findById(Long id);

    List<Member> findAll(MemberSearchCond cond);

    void update(Long id, MemberUpdateDto updateParam);

    void delete(Long id);

}
