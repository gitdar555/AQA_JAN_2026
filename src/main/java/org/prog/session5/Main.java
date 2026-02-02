package org.prog.session5;

import org.prog.session6.Truck;

public class Main {

    /**
     * ######################################
     * ###[myFirstCar@Car]###################
     * ######################################
     * ####[aliceCar@Car]####################
     * ####[bobsCar@Car]#####################
     * ######################################
     * ######################################
     * ######################################
     * ======================================
     * #######10#############################
     */

    public static void main(String[] args) {
        CarService carService = new CarService();

        Car myFirstCar = new Car();
        myFirstCar.plateNumber = "AA0000AA";
        Car aliceCar = new Car();
        Car bobsCar = new Car();
        Car otherCar = myFirstCar;

        int amountToPay = 10;

        carService.paintCar(myFirstCar, "blue");
        carService.addPayment(amountToPay);
        myFirstCar.goTo("Kyiv", 70);
        myFirstCar.goTo("Odessa", 100);

        System.out.println("After payment: " + amountToPay);

        // TODO 4: массив грузовиков
        Truck[] trucks = new Truck[2];

        trucks[0] = new Truck();
        trucks[0].setTruckInfo("Volvo FH", "Alex", "AB1234CD");

        trucks[1] = new Truck();
        trucks[1].setTruckInfo("MAN TGX", "Maria", "BC5678EF");

        // TODO 3: используем String чтобы хранить и печатать
        for (Truck t : trucks) {
            String info = t.getTruckInfo(); // сохранили строку
            System.out.println(info);       // вывели строку
        }
    }


//        carService.paintCar(aliceCar, "yellow");
//        carService.paintCar(bobsCar, "black");
//
//        otherCar.goTo("Kyiv", 45);

//        myFirstCar.color = "red";
//        aliceCar.color = "blue";
//        bobsCar.color = "green";
//
//        System.out.println(otherCar.color);
//        System.out.println(aliceCar.color);
//        System.out.println(bobsCar.color);
//
//        otherCar.goTo("Kyiv", 80);
//        aliceCar.goTo("Lviv", 120);
//        bobsCar.goTo("Odessa", 60);
//
//        otherCar.color = "black";
//
//        myFirstCar.goTo("Kyiv", 80);
}
