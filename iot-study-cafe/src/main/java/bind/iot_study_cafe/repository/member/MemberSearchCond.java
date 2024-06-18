package bind.iot_study_cafe.repository.member;

import bind.iot_study_cafe.domain.member.Grade;
import lombok.Data;

@Data
public class MemberSearchCond {

    private String userId;
    private String userName;
    private Integer maxAge;
    private Integer minAge;
    private Grade grade;

    public MemberSearchCond() {
    }

    public MemberSearchCond(String userId, String userName, Integer maxAge, Integer minAge, Grade grade) {
        this.userId = userId;
        this.userName = userName;
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.grade = grade;
    }
}
