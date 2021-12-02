package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.class_.ListClassController;
import controller.class_.OpenClassController;
import controller.class_.UpdateClassController;
import controller.class_.ViewClassController;
import controller.community.ListPostController;
import controller.community.RegisterPostController;
import controller.community.ViewPostController;
import controller.funding.ListFundingController;
import controller.funding.OpenFundingController;
import controller.funding.UpdateFundingController;
import controller.funding.ViewFundingController;
import controller.meeting.ListMeetingController;
import controller.meeting.OpenMeetingController;
import controller.meeting.UpdateMeetingController;
import controller.meeting.ViewMeetingController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());
        
        // 회원 가입 폼 요청과 가입 요청 처리 병합 (폼에 커뮤니티 선택 메뉴 추가를 위함)
        mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/user/register", new RegisterUserController());

        // 사용자 정보 수정 폼 요청과 수정 요청 처리 병합
        //mappings.put("/user/update/form", new UpdateUserFormController());        
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/delete", new DeleteUserController());
              
        //class관련
        mappings.put("/class", new ForwardController("/class/class.jsp"));
        mappings.put("/class/list", new ListClassController());
        mappings.put("/class/details", new ViewClassController());
        mappings.put("/class/open/form", new ForwardController("/class/classOpenform.jsp"));
        mappings.put("/class/open", new OpenClassController());
        mappings.put("/class/update", new UpdateClassController());
        
        //meeting관련
        mappings.put("/meeting", new ForwardController("/meeting/meeting.jsp"));
        mappings.put("/meeting/list", new ListMeetingController());
        mappings.put("/meeting/details", new ViewMeetingController());
        mappings.put("/meeting/open/form", new ForwardController("/meeting/meetingOpenform.jsp"));
        mappings.put("/meeting/open", new OpenMeetingController());
        mappings.put("/meeting/update", new UpdateMeetingController());
        
        //Funding관련
        mappings.put("/funding", new ForwardController("/funding/funding.jsp"));
        mappings.put("/funding/list", new ListFundingController());
        mappings.put("/funding/details", new ViewFundingController());
        mappings.put("/funding/open/form", new ForwardController("/funding/fundingOpenform.jsp"));
        mappings.put("/funding/open", new OpenFundingController());
        mappings.put("/funding/update", new UpdateFundingController());
        
        //Board관련
        mappings.put("/community", new ForwardController("/community/community.jsp"));
        mappings.put("/community/write/form", new ForwardController("/community/postWrite.jsp"));
        mappings.put("/community/list", new ListPostController());
        mappings.put("/community/register", new RegisterPostController());  
        mappings.put("/community/view", new ViewPostController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}
