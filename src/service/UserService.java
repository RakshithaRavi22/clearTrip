package service;

public interface UserService {

    void addUser(int userId, String name, double funds);

    void addFunds(int userId, double funds);

}
