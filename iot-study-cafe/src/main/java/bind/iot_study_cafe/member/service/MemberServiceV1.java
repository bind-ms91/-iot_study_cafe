package bind.iot_study_cafe.member.service;

import bind.iot_study_cafe.member.domain.Member;
import bind.iot_study_cafe.member.repository.MemberRepositoryV1;
import bind.iot_study_cafe.member.dto.MemberSearchCond;
import bind.iot_study_cafe.member.dto.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceV1 implements MemberService {

    private final MemberRepositoryV1 memberRepositoryV1;

    @Override
    public Member save(Member member) {
        return memberRepositoryV1.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepositoryV1.findById(id);
    }

    @Override
    public List<Member> findAll(MemberSearchCond cond) {
        return memberRepositoryV1.findAll(cond);
    }

    @Override
    public void update(Long id, MemberUpdateDto updateParam) {
        memberRepositoryV1.update(id, updateParam);
    }

    @Override
    public void delete(Long id) {
        memberRepositoryV1.delete(id);
    }
}
