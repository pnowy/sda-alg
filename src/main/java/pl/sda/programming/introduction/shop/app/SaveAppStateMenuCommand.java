package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Account;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

final class SaveAppStateMenuCommand implements MenuCommand<List<Account>> {
    @Override
    public String getText() {
        return "Save to file";
    }

    @Override
    public void execute(List<Account> accounts) {
        /*
        InputStream  - source of data
        OutputStream - destination of data
        */

//        ObjectOutputStream output = null;
//        try {
//            output = new ObjectOutputStream(
//                    new FileOutputStream("data.state"));
//
//            output.writeObject(accounts);
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            if (output != null) {
//                try {
//                    output.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        // try with resources
        try (ObjectOutputStream stream =
                     new ObjectOutputStream(
                             new FileOutputStream(new File("data.state")))) {
            stream.writeObject(accounts);
            System.out.println("Successfully file written!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
