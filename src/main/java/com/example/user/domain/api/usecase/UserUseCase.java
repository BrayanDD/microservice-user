package com.example.user.domain.api.usecase;

import com.example.user.domain.api.IUserServicePort;
import com.example.user.domain.model.Login;
import com.example.user.domain.model.PublicResponseTok;
import com.example.user.domain.model.User;
import com.example.user.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort{

    public final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public String login(Login login) {
        return userPersistencePort.login(login);
        
    }

    @Override
    public String register(User register,Long idRolCreate) {
        return userPersistencePort.register(register,idRolCreate);
        
    }

}
