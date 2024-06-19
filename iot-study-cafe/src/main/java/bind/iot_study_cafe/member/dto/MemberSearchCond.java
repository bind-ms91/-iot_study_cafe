package bind.iot_study_cafe.member.dto;

import bind.iot_study_cafe.member.domain.MemberGrade;
import lombok.Data;

@Data
public class MemberSearchCond {

    private String userId;
    private String userName;
    private Integer maxAge;
    private Integer minAge;
    private MemberGrade memberGrade;

    public MemberSearchCond() {
    }

    public MemberSearchCond(String userId, String userName, Integer maxAge, Integer minAge, MemberGrade memberGrade) {
        this.userId = userId;
        this.userName = userName;
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.memberGrade = memberGrade;
    }
}
