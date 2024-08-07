package bind.iotstudycafe.commons.web.session;

import bind.iotstudycafe.member.domain.Member;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SessionManagerTest {

    @Test
    void sessionTest() {
        //세션 생성
        MockHttpServletRequest request = new MockHttpServletRequest();
        HttpSession session = request.getSession();

        //요청에 응답 쿠키 저장
        Member loginMember = new Member("ms91", "1234", "조민성", 33, "BASIC");
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember.getMemberId());


        //세션 조회
        Object result = session.getAttribute(SessionConst.LOGIN_MEMBER);
        assertThat(result).isEqualTo(loginMember.getMemberId());

        //세션 만료
        session.invalidate();
        assertThrows(IllegalStateException.class,
                () -> session.getAttribute(SessionConst.LOGIN_MEMBER));

    }

}