public class LeapYear {
    public static void main(String[] args) {
        int anno1 = 2024;
        int anno2 = 1900;
        int anno3 = 2000;
        int anno4 = 2026;

        boolean bisestile1 = (anno1 % 4 == 0 && anno1 % 100 != 0) || anno1 % 400 == 0;
        boolean bisestile2 = (anno2 % 4 == 0 && anno2 % 100 != 0) || anno2 % 400 == 0;
        boolean bisestile3 = (anno3 % 4 == 0 && anno3 % 100 != 0) || anno3 % 400 == 0;
        boolean bisestile4 = (anno4 % 4 == 0 && anno4 % 100 != 0) || anno4 % 400 == 0;

        System.out.println(anno1 + " bisestile: " + bisestile1);
        System.out.println(anno2 + " bisestile: " + bisestile2);
        System.out.println(anno3 + " bisestile: " + bisestile3);
        System.out.println(anno4 + " bisestile: " + bisestile4);
    }
}
