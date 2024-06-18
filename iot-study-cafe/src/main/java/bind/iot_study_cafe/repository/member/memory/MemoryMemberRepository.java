package bind.iot_study_cafe.repository.member.memory;

import bind.iot_study_cafe.domain.member.Grade;
import bind.iot_study_cafe.domain.member.Member;
import bind.iot_study_cafe.repository.member.MemberRepository;
import bind.iot_study_cafe.repository.member.MemberSearchCond;
import bind.iot_study_cafe.repository.member.MemberUpdateDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>(); //static
    private static long sequence = 0L; //static


    @Override
    public Member save(Member member) {

        member.setSequence(++sequence);
        store.put(member.getSequence(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll(MemberSearchCond cond) {

        String userId = cond.getUserId();
        String userName = cond.getUserName();
        Integer maxAge = cond.getMaxAge();
        Integer minAge = cond.getMinAge();
        Grade grade = cond.getGrade();

        return store.values().stream()
                .filter(member -> {
                    if (ObjectUtils.isEmpty(userId)) {
                        return true;
                    }
                    return member.getUserId().contains(userId);
                }).filter(member -> {
                    if (ObjectUtils.isEmpty(userName)) {
                        return true;
                    }
                    return member.getUserName().contains(userName);
                }).filter(member -> {
                    if (maxAge == null && minAge == null) {
                        return true;
                    }
                    return member.getAge() <= minAge && member.getAge() >= maxAge;
                }).filter(member -> {
                    if (ObjectUtils.isEmpty(grade)) {
                        return true;
                    }
                    return member.containsGrade(grade);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void update(Long id, MemberUpdateDto updateParam) {

        Member findMember = findById(id).orElseThrow();
        findMember.setGrade(updateParam.getGrade());
        findMember.setUserPassword(updateParam.getUserPassword());
        findMember.setUserName(updateParam.getUserName());
        findMember.setAge(updateParam.getAge());

    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

    public void clearStore() {
        store.clear();
    }

}
