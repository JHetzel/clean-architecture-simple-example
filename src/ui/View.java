package ui;

import entity.User;

public interface View {
    String getEmailInputText();

    String getPasswordInputText();

    void showUserRegistered(User user);

    void showErrorRegisteringUser();
}
