package pl.sda.programming.introduction;

final class _09_Switch {

    public static void main(String[] args) {

        // switch statements
        int i = 3;

        switch (i) {
            case 0:
                System.out.println("case 0");
                break;
            case 1:
                System.out.println("case 1");
                break;
            case 2:
                System.out.println("case 2");
                break;
            default:
                System.out.println("default");
        }

        System.out.println("other instructions");

        // select menu
        String userSelected = "about_me";

        switch (userSelected) {
            case "portfolio":
                System.out.println("user selected: portfolio");
                break;
            case "about_me":
                System.out.println("user selected: about_me");
                break;
            case "contact":
                System.out.println("user selected contact");
                break;
            default:
                System.out.println("user selected other page");
        }
    }
}
