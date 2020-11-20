class CommandLineOverloadArray {
    public static void main(String[] args) {
        int luasAlas = 0;
        int tinggi = 0;
        double r =0;
        int volumePersegi = volumeBangunan(luasAlas, tinggi);
        double volumeBola = volumeBangunan(r);

        switch (Integer.parseInt(args[0])) {
            case 1: 
                System.out.println("Volume Kubus : " + volumeBangunan(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
            break;
            case 2: 
                System.out.println("Volume Bola : " + volumeBangunan(Double.parseDouble(args[1])));
            break;
            case 3: 
                Arrays(Integer.parseInt(args[1]));
            break;
        }
    }

    public static int volumeBangunan(int luasAlas, int tinggi) {
        int kubus;
        kubus = luasAlas * tinggi;
        return kubus;
    }

    public static double volumeBangunan(double r) {
        double bola;
        bola = 4/3 * 3.14 * r;
        return bola;
    }

    public static void Arrays(int row) {
        String[][] arr = {
                {"siji", "loro", "telu"},
                {"papat", "limo"}
            };

        String[][] arrs = {
                {"ciek", "duo", "tigo"},
                {"ampek", "limo"}
            };
            
        if (row == 2) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println("");
            }
        } else if (row == 3) {
            for (int i = 0; i < arrs.length; i++) {
                for (int j = 0; j < arrs[i].length; j++) {
                    System.out.print(arrs[i][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}