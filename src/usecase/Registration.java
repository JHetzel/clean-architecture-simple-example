package usecase;

import entity.User;

/**
 * Wrapper for RegistrationUseCase components and
 * interfaces
 */
public interface Registration {

    /**
     * UseCase Input Port
     */
    interface Input {

        void execute(Request request, Output output);
    }

    /**
     * UseCase Output Port
     */
    interface Output {

        void onComplete(Response response);
    }

    /**
     * UseCase Request Model
     */
    final class Request {
        public final String mEmail;
        public final String mPassword;

        public Request(String email, String password) {
            mEmail = email;
            mPassword = password;
        }
    }

    /**
     * Use Case Response Model
     */
    final class Response {
        public final boolean mIsSuccessful;
        public final User mUser;

        private Response(boolean isSuccessful, User user) {
            mIsSuccessful = isSuccessful;
            mUser = user;
        }

        static Response create(User user) {
            boolean success = user != null;
            return new Response(success, user);
        }
    }
}
