package pl.sda.programming.introduction;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

final class _35_HandlingExceptions {
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        int retry = 3;
        while (retry > 0) {
            UserService userService = new UserService();
            try {
                int token = userService.login("test", "123");

                Thread.sleep(random.nextInt(5000));

                List<String> friends = userService.getFriends(token);
                System.out.println(friends);
                break;
            } catch (InvalidLoginException ex) {
                throw new RuntimeException("invalid login", ex);
            } catch (TokenExpiredException | ServiceUnavailableException ex) {
                ex.printStackTrace();
                retry--;
            } finally {
                userService.close();
            }
        }
    }
}

class UserService {

    private int currentToken;
    private long expirationTime;

    int login(String user, String password) throws InvalidLoginException {
        if (!"test".equals(user) || !"123".equals(password)) {
            throw new InvalidLoginException("invalid user or password");
        }
        currentToken = new Random().nextInt(100_000);
        expirationTime = System.currentTimeMillis() + 1000;
        return currentToken;
    }

    List<String> getFriends(int token) throws TokenExpiredException, ServiceUnavailableException {
        if (token != currentToken) {
            throw new IllegalArgumentException("invalid token");
        }
        if (token > 50_000) {
            throw new ServiceUnavailableException("service is not responding");
        }
        if (System.currentTimeMillis() > expirationTime) {
            throw new TokenExpiredException("token expired");
        }

        return Arrays.asList("janik", "dawid", "zosia");
    }

    void close() {
        System.out.println("service is going down ...");
    }
}

class InvalidLoginException extends Exception {
    InvalidLoginException(String message) {
        super(message);
    }
}

class TokenExpiredException extends Exception {
    TokenExpiredException(String message) {
        super(message);
    }
}

class ServiceUnavailableException extends Exception {
    ServiceUnavailableException(String message) {
        super(message);
    }
}