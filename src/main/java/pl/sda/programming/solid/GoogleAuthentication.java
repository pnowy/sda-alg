package pl.sda.programming.solid;


public class GoogleAuthentication implements Authenticate {
    @Override
    public boolean authenticate(String userLogin) {
        System.out.println("calling google service here ....");
        return true;
    }
}
