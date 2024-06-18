package bind.iot_study_cafe.domain.member;

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
    private Long sequence;

    @Id
    private String userId;
    private String userPassword;
    private String userName;
    private Integer age;
    private Grade grade;

    public Member() {
    }

    public Member(String userId, String userPassword, String userName, Integer age, Grade grade) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.age = age;
        this.grade = grade;
    }

    // Grade를 포함하는지 확인하는 메서드 추가
    public boolean containsGrade(Grade grade) {
        return this.grade == grade;
    }

}
