package bind.iot_study_cafe.service.member;

import bind.iot_study_cafe.domain.member.Member;
import bind.iot_study_cafe.repository.member.MemberRepository;
import bind.iot_study_cafe.repository.member.MemberSearchCond;
import bind.iot_study_cafe.repository.member.MemberUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceV1 implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findAll(MemberSearchCond cond) {
        return memberRepository.findAll(cond);
    }

    @Override
    public void update(Long id, MemberUpdateDto updateParam) {
        memberRepository.update(id, updateParam);
    }

    @Override
    public void delete(Long id) {
        memberRepository.delete(id);
    }
}
