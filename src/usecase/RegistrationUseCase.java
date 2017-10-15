package usecase;

import entity.User;

import java.util.regex.Pattern;

public class RegistrationUseCase implements Registration.Input{
    private final UserDataStore mUserDataStore;

    public RegistrationUseCase(UserDataStore userDataStore) {
        mUserDataStore = userDataStore;
    }

    @Override
    public void execute(Registration.Request request, Registration.Output output) {
        String email = request.mEmail;
        String password = request.mPassword;
        User newUser = null;

        if(isValidEmailAddress(email) && isValidPassword(password)){
            newUser = mUserDataStore.register(email, password);
        }

        output.onComplete(Registration.Response.create(newUser));
    }

    private boolean isValidEmailAddress(String string) {
        return Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)
                .matcher(string)
                .find();
    }

    private boolean isValidPassword(String string) {
        return string.length() > 8;
    }
}
