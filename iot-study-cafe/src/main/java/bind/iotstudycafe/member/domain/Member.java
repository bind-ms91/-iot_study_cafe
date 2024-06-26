package bind.iotstudycafe.member.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

@Data
@Entity
@DynamicInsert
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;        //seq

    private String memberId;
    private String memberPassword;
    private String memberName;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;

    public Member() {
    }

    public Member(String memberId, String memberPassword, String memberName, Integer age, String memberGrade) {
        this.memberId = memberId;
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