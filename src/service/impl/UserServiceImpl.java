package service.impl;

import exception.UserAlreadyExistsException;
import exception.UserNotFoundException;
import model.User;
import repository.UserRepository;
import service.UserService;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(int userId, String name, double funds) {

        userRepository.addUser(userId, name, funds);

    }

    @Override
    public void addFunds(int userId, double funds) {

        User user = userRepository.updateUser(userId, funds);
        System.out.println("User funds updated");
    }
}
