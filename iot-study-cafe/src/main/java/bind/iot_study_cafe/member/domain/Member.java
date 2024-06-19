package bind.iot_study_cafe.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private String userId;
    private String userPassword;
    private String userName;
    private Integer age;
    private MemberGrade memberGrade;

    public Member() {
    }

    public Member(String userId, String userPassword, String userName, Integer age, String memberGrade) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.age = age;
        this.memberGrade = MemberGrade.valueOf(memberGrade);
    }

    // Grade를 포함하는지 확인하는 메서드 추가
    public boolean containsGrade(MemberGrade memberGrade) {
        return this.memberGrade == memberGrade;
    }

}
