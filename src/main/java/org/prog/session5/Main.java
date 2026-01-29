package org.prog.session5;

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
        myFirstCar.owner = "Daria";

        int amountToPay = 10;

        carService.paintCar(myFirstCar, "blue");
        carService.addPayment(amountToPay);
        myFirstCar.goTo("Kyiv", 70);
        myFirstCar.goTo("Odessa", 100);

        System.out.println("After payment: " + amountToPay);

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
}
