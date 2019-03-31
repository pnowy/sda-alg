package pl.sda.programming.solid;

public class DatabaseAuthentication implements Authenticate {
    @Override
    public boolean authenticate(String userLogin) {
        System.out.println("calling database connection here ....");
        return true;
    }
}
