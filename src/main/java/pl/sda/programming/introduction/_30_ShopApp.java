package pl.sda.programming.introduction;


import pl.sda.programming.introduction.shop.app.ShopApp;
import pl.sda.programming.introduction.shop.model.Account;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

final class _30_ShopApp {

    public static void main(String[] args) {
        new ShopApp(getAppState()).run();
    }

    private static List<Account> getAppState() {
        try (ObjectInputStream stream = new ObjectInputStream(
                new FileInputStream(new File("data.state")))) {

            return (List<Account>) stream.readObject();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
