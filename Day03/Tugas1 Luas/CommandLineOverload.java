public class CommandLineOverload {
    public static void main(String[] args) {
        MethodOverloading test = new MethodOverloading(); //membuat objek test dari class MethodOverLoading
        // for(int i = 0; i<test.luasBangun(i, i); i++) {
        //     System.out.println("args[" + i + "]: " + args[i]);
        // }

        // switch (i)

        /** Membuat java command line dengan macam-macam argumennya */
        switch (Integer.parseInt(args[0])) {
            case 1: 
                System.out.println("Luas Persegi : " + test.luasBangun(Integer.parseInt(args[1])) );
            break;
            case 2: 
                System.out.println("Luas Segitiga : " + test.luasBangun(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
            break;
            case 3:
                System.out.println("Luas Lingkaran : " + test.luasBangun(Double.parseDouble(args[1]), Double.parseDouble(args[2])) );
            break;
            case 4:
                System.out.println("Umur : " + umur(2020, Integer.parseInt(args[3])));
            break;
            default:
            System.out.println("Wrong Arguments");
            break;

        }
    }

    // Membuat method umur karena methodnya belum ada di class MethodOverloading
    public static int umur(int thisYear, int birthYear) {
        return thisYear - birthYear;
    }
}