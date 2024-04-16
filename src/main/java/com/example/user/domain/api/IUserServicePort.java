package com.example.user.domain.api;

import com.example.user.domain.model.Login;
import com.example.user.domain.model.PublicResponseTok;
import com.example.user.domain.model.User;

public interface IUserServicePort {

    String login(Login login);

    String register(User register,Long idRolCreate);
}
