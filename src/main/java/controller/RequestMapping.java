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
    
    // �� ��û uri�� ���� controller ��ü�� ������ HashMap ����
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// �� uri�� �����Ǵ� controller ��ü�� ���� �� ����
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());
        
        // ȸ�� ���� �� ��û�� ���� ��û ó�� ���� (���� Ŀ�´�Ƽ ���� �޴� �߰��� ����)
        mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/user/register", new RegisterUserController());

        // ����� ���� ���� �� ��û�� ���� ��û ó�� ����
        //mappings.put("/user/update/form", new UpdateUserFormController());        
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/delete", new DeleteUserController());
              
        //class����
        mappings.put("/class", new ForwardController("/class/class.jsp"));
        mappings.put("/class/list", new ListClassController());
        mappings.put("/class/details", new ViewClassController());
        mappings.put("/class/open/form", new ForwardController("/class/classOpenform.jsp"));
        mappings.put("/class/open", new OpenClassController());
        mappings.put("/class/update", new UpdateClassController());
        
        //meeting����
        mappings.put("/meeting", new ForwardController("/meeting/meeting.jsp"));
        mappings.put("/meeting/list", new ListMeetingController());
        mappings.put("/meeting/details", new ViewMeetingController());
        mappings.put("/meeting/open/form", new ForwardController("/meeting/meetingOpenform.jsp"));
        mappings.put("/meeting/open", new OpenMeetingController());
        mappings.put("/meeting/update", new UpdateMeetingController());
        
        //Funding����
        mappings.put("/funding", new ForwardController("/funding/funding.jsp"));
        mappings.put("/funding/list", new ListFundingController());
        mappings.put("/funding/details", new ViewFundingController());
        mappings.put("/funding/open/form", new ForwardController("/funding/fundingOpenform.jsp"));
        mappings.put("/funding/open", new OpenFundingController());
        mappings.put("/funding/update", new UpdateFundingController());
        
        //Board����
        mappings.put("/community", new ForwardController("/community/community.jsp"));
        mappings.put("/community/write/form", new ForwardController("/community/postWrite.jsp"));
        mappings.put("/community/list", new ListPostController());
        mappings.put("/community/register", new RegisterPostController());  
        mappings.put("/community/view", new ViewPostController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// �־��� uri�� �����Ǵ� controller ��ü�� ã�� ��ȯ
        return mappings.get(uri);
    }
}
