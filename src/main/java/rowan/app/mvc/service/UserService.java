package rowan.app.mvc.service;

import rowan.app.data.dto.response.LoginResult;

public interface UserService {

    LoginResult.Basic login(String id, String password);

}
