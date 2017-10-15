package usecase;

import entity.User;

public interface UserDataStore {

    User register(String email, String password);
}
