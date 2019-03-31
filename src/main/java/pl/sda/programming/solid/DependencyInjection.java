package pl.sda.programming.solid;

public class DependencyInjection {
    public static void main(String[] args) {
        // DI init
//        Authenticate auth = new GoogleAuthentication();
        Authenticate auth = new DatabaseAuthentication();

        AuthenticationModule authenticationModule = new AuthenticationModule(auth);
        authenticationModule.authUser("xyz");
    }
}
