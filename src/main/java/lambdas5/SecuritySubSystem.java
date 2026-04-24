package main.java.lambdas5;

public class SecuritySubSystem {
    public boolean checkPermission(String userId) {
        if (userId.equals("1")) {
            return true;
        }
        return false;
    }
}