package repository;

import exception.UserAlreadyExistsException;
import exception.UserNotFoundException;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    Map<Integer, User> userMap = new HashMap<>();

    public void addUser(int userId, String name, double funds) {

        if(userMap.containsKey(userId)){
            System.out.println(userMap.get(userId).toString());
            throw new UserAlreadyExistsException("User present, update of necessary");
        }

        User u1 = new User(userId, name, funds);
        userMap.put(userId, u1);
    }

    public User getUser(int userId){
        if(!userMap.containsKey(userId)){
            throw new UserNotFoundException("User not found");
        }
        return userMap.get(userId);
    }

    public User updateUser(int userId, double funds){
        User user = getUser(userId);

        user.setFunds(funds);
        userMap.put(userId, user);

        return user;
    }
}
