package bind.iot_study_cafe.member.service;

import bind.iot_study_cafe.member.domain.Member;
import bind.iot_study_cafe.member.dto.MemberSearchCond;
import bind.iot_study_cafe.member.dto.MemberUpdateDto;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member save(Member member);

    Optional<Member> findById(Long id);

    List<Member> findAll(MemberSearchCond cond);

    void update(Long id, MemberUpdateDto updateParam);

    void delete(Long id);

}
