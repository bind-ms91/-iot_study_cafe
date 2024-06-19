package bind.iot_study_cafe.member.dto;

import bind.iot_study_cafe.member.domain.MemberGrade;
import lombok.Data;

@Data
public class MemberUpdateDto {

    private String userPassword;
    private String userName;
    private int age;
    private String memberGrade;

    public MemberUpdateDto() {
    }

    public MemberUpdateDto(String userPassword, String userName, int age, String memberGrade) {
        this.userPassword = userPassword;
        this.userName = userName;
        this.age = age;
        this.memberGrade = memberGrade;
    }
}
