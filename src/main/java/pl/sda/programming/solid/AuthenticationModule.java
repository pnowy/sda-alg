package pl.sda.programming.solid;

public class AuthenticationModule {
    private Authenticate auth;

    public AuthenticationModule(Authenticate auth) {
        this.auth = auth;
    }

    void authUser(String principal) {
        this.auth.authenticate(principal);
        //
    }


    //// ----------



    //// ----------
}
