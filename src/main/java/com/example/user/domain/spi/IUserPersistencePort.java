package com.example.user.domain.spi;

import com.example.user.domain.model.Login;
import com.example.user.domain.model.User;

public interface IUserPersistencePort {

    String login(Login login);

    String register(User register , Long idRolCreate);


}
