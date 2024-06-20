package bind.iot_study_cafe.member.service;

import bind.iot_study_cafe.member.domain.MemberGrade;
import bind.iot_study_cafe.member.domain.Member;
import bind.iot_study_cafe.member.dto.MemberSearchCond;
import bind.iot_study_cafe.member.dto.MemberUpdateDto;
import bind.iot_study_cafe.member.repository.MemberRepositoryV1;
import bind.iot_study_cafe.member.repository.memory.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
@SpringBootTest
//@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepositoryV1 memberRepository;

    @Autowired
    MemberService memberService;

    @AfterEach
    void afterEach() {
        //MemoryRepository 사용시 제한적으로 사용
        if(memberRepository instanceof MemoryMemberRepository) {
            ((MemoryMemberRepository) memberRepository).clearStore();
        }
    }

    @Test
    void save() {

        //given
        Member member = new Member("ms91", "123", "조민성", 23, "OPERATOR");

        //when
        memberService.save(member);

        //then
        Member findMember = memberService.findById(member.getId()).get();

        log.info("member: {}", member);
        log.info("findMember: {}", findMember);

        assertThat(member).isEqualTo(findMember);
    }

    @Test
    void update() {

        //given
        Member member = new Member("ms91", "123", "조민성", 23, "OPERATOR");
        memberService.save(member);
        Long memberId = member.getId();

        //when
        MemberUpdateDto updateParam = new MemberUpdateDto("1234", "민성", 24, "OWNER");
        memberService.update(memberId, updateParam);

        //then
        Member findMember = memberService.findById(memberId).get();
        assertThat(findMember.getMemberPassword()).isEqualTo(updateParam.getMemberPassword());
        assertThat(findMember.getMemberName()).isEqualTo(updateParam.getMemberName());
        assertThat(findMember.getAge()).isEqualTo(updateParam.getAge());
        assertThat(findMember.getMemberGrade()).isEqualTo(MemberGrade.valueOf(updateParam.getMemberGrade()));
        log.info("findMember: {}", findMember);
        log.info("updateParam: {}", updateParam);

    }

    @Test
    void findMembers() {

        //given
        Member member1 = new Member("ms91", "123", "조민성1", 23, "OWNER");
        Member member2 = new Member("ms92", "1234", "조민성2", 22, "OPERATOR");
        Member member3 = new Member("ms93", "1235", "조민성3", 21, "BASIC");

        memberService.save(member1);
        memberService.save(member2);
        memberService.save(member3);
        //when

        //유저 아이디로 테스트
        search("ms91", null, null, null, null, member1);
        search("ms", null, null, null, null, member1, member2, member3);
        search("", null, null, null, null, member1, member2, member3);

        //유저 이름 테스트
        search(null, "조민성1", null, null, null, member1);
        search(null, "민성", null, null, null, member1, member2, member3);
        search(null, "", null, null, null, member1, member2, member3);

        //유저 등급 테스트
        search(null, null, null, null, "OWNER", member1);
        search(null, null, null, null, "OPERATOR", member2);
        search(null, null, null, null, "BASIC", member3);
        search(null, null, null, null, "", member1, member2, member3);

        //나이 테스트
        search(null, null, 23, null, null, member1, member2, member3);
        search(null, null, 23, 23, null, member1);
        search(null, null, null, 22, null, member1, member2);

        List<Member> findMembers = memberService.findAll(new MemberSearchCond());
        //then
        //search()

        assertThat(findMembers).hasSize(3);

    }

    @Test
    void deleteById() {

        //given
        Member member = new Member("ms91", "123", "조민성", 23, "OPERATOR");
        memberService.save(member);
        Long memberId = member.getId();
        Member findMember = memberService.findById(memberId).get();
        log.info("findMember: {}", findMember);

        //when
        memberService.deleteById(memberId);

        //then
        assertThatThrownBy(() -> memberService.findById(memberId).get())
                .isInstanceOf(NoSuchElementException.class);
    }

    void search(String userId, String userName, Integer maxAge,  Integer minAge, String memberGrade, Member... members) {
        List<Member> result = memberService.findAll(new MemberSearchCond(userId, userName, maxAge, minAge, memberGrade));
        assertThat(result).containsExactly(members);
    }
}