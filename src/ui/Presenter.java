package ui;

import datasource.UserDataStoreImplementation;
import usecase.Registration;
import usecase.RegistrationUseCase;

public class Presenter implements Registration.Output{
    private final View mView;
    private final Registration.Input mRegistration;

    public Presenter(View view) {
        mView = view;
        mRegistration = new RegistrationUseCase(new UserDataStoreImplementation());
    }

    public void onRegistrationClick() {
        String email = mView.getEmailInputText();
        String password = mView.getPasswordInputText();

        Registration.Request request = new Registration.Request(email, password);
        mRegistration.execute(request, this);
    }

    @Override
    public void onComplete(Registration.Response response) {
        if(response.mIsSuccessful) {
            mView.showUserRegistered(response.mUser);
        } else {
            mView.showErrorRegisteringUser();
        }
    }
}
