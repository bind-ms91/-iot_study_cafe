package bind.iot_study_cafe.member.service;

import bind.iot_study_cafe.member.domain.Member;
import bind.iot_study_cafe.member.domain.MemberGrade;
import bind.iot_study_cafe.member.dto.MemberSearchCond;
import bind.iot_study_cafe.member.dto.MemberUpdateDto;
import bind.iot_study_cafe.member.repository.MemberRepositoryV1;
import bind.iot_study_cafe.member.repository.MemberRepositoryV2;
import bind.iot_study_cafe.member.repository.querydsl.MemberQueryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceV2 implements MemberService {

    private final MemberRepositoryV2 memberRepositoryV2;
    private final MemberQueryRepository memberQueryRepository;

    @Override
    public Member save(Member member) {
        return memberRepositoryV2.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepositoryV2.findById(id);
    }

    @Override
    public List<Member> findAll(MemberSearchCond cond) {
        return memberQueryRepository.findAll(cond);
    }

    @Override
    public void update(Long id, MemberUpdateDto updateParam) {
        Member findMember = memberRepositoryV2.findById(id).orElseThrow();
        findMember.setMemberGrade(MemberGrade.valueOf(updateParam.getMemberGrade()));
        findMember.setMemberPassword(updateParam.getMemberPassword());
        findMember.setMemberName(updateParam.getMemberName());
        findMember.setAge(updateParam.getAge());
    }

    @Override
    public void deleteById(Long id) {
        memberRepositoryV2.deleteById(id);
    }
}
