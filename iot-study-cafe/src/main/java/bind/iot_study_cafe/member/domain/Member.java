package bind.iot_study_cafe.member.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Member {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

////    @Id
//    private String memberId;

    @EmbeddedId
    private MemberId id;

    private String memberPassword;
    private String memberName;
    private Integer age;
    private MemberGrade memberGrade;

    public Member() {
    }

    public Member(String id, String memberPassword, String memberName, Integer age, String memberGrade) {
        this.id = new MemberId(id);
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.age = age;
        this.memberGrade = MemberGrade.valueOf(memberGrade);
    }

    // Grade를 포함하는지 확인하는 메서드 추가
    public boolean containsGrade(MemberGrade memberGrade) {
        return this.memberGrade == memberGrade;
    }

}
