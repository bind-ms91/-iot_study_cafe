package bind.iot_study_cafe.repository.member;

import bind.iot_study_cafe.domain.member.Grade;
import lombok.Data;

@Data
public class MemberUpdateDto {

    private String userPassword;
    private String userName;
    private int age;
    private Grade grade;

    public MemberUpdateDto() {
    }

    public MemberUpdateDto(String userPassword, String userName, int age, Grade grade) {
        this.userPassword = userPassword;
        this.userName = userName;
        this.age = age;
        this.grade = grade;
    }
}
