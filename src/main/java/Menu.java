import db.DBView;

import java.util.Scanner;

public class Menu {


    DBView dbView = new DBView();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("1 - ALL users");
        System.out.println("2 - Add new user");


    }

    private void readUserInput() {
        int typed = scanner.nextInt();
        if (typed == 1) {
            dbView.getAllPersons();
        }
    }

}
