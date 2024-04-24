package com.example.user.domain.api.usecase;

import com.example.user.domain.api.IUserServicePort;
import com.example.user.domain.model.Login;
import com.example.user.domain.model.User;
import com.example.user.domain.spi.IUserPersistencePort;





public class UserUseCase implements IUserServicePort {


    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {

        this.userPersistencePort = userPersistencePort;

    }

    @Override
    public String login(Login login) {


        return userPersistencePort.login(login);


    }

    @Override
    public String registerAdmin(User register) {
        Long idRolCreate = 1L;
        return userPersistencePort.register(register, idRolCreate);
    }

    @Override
    public String registerTutor(User register) {
        Long idRolCreate = 2L;
        return userPersistencePort.register(register, idRolCreate);
    }

    @Override
    public String registerStudent(User register) {
        Long idRolCreate = 3L;
        return userPersistencePort.register(register, idRolCreate);
    }






}
