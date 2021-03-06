package datasource;

import entity.User;
import usecase.UserDataStore;

import java.util.ArrayList;
import java.util.List;

public class UserDataStoreImplementation implements UserDataStore {
    private final List<User> mUsers = new ArrayList<>();

    @Override
    public User register(String email, String password) {
        long existingUserCount = mUsers.stream()
                .filter(user -> user.mEmail.equals(email))
                .count();
        
        if(existingUserCount > 0) {
            return null;
        } else {
            User newUser = new User(email, password);
            mUsers.add(newUser);
            return newUser;
        }
    }
}
