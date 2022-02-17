package rowan.app.mvc.service;

import rowan.app.data.dto.response.LoginResult;
import rowan.app.data.type.ServiceType;
import rowan.app.data.type.UserLogType;

public interface UserService {

    LoginResult.Basic login(String id, String password);

    void user_log_put(String id, ServiceType serviceType, UserLogType userLogType, String etc);

}
