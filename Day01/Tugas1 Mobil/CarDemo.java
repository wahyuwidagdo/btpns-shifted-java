class CarDemo {
    public static void main(String[] args) {
        // Buat Object
        Car tesla = new Car();
        Car mercedes = new Car();

        tesla.tambahGigi(1);
        tesla.tambahGigi(2);
        tesla.kurangGigi(1);
        tesla.printStates();

        tesla.mengerem(5);
        tesla.printStates();

        mercedes.tambahGigi(1);
        mercedes.tambahGigi(2);
        mercedes.tambahGigi(3);
        mercedes.tambahGigi(4);
        mercedes.kurangGigi(3);
        mercedes.mengerem(5);
        mercedes.printStates();
    }
}