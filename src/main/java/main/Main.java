package main;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Virheelliset parametrit. Oikea muoto: puristin [pakkaa|pura] <tiedostonimi>");
            System.exit(0);
        }

        if (args[0].equals("pakkaa")) {
            System.out.println("Pakataan...");
        }

        if (args[0].equals("pura")) {
            System.out.println("Puretaan...");
        }
    }
}
