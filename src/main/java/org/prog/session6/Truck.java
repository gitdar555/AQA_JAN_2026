package org.prog.session6;

//TODO: add car plate number
//TODO: add method which will return owner name, model and plate number
//TODO: use String to store and print this in Main
//TODO: * - make array of trucks
public class Truck {

    public String model;        // модель грузовика
    public String name;         // владелец / водитель
    public String plateNumber;  // TODO 1: номер машины

    // Заполнение данных
    public void setTruckInfo(String m, String n, String p) {
        model = m;
        name = n;
        plateNumber = p;
    }

    // TODO 2: метод возвращает owner + model + plate ОДНОЙ строкой
    public String getTruckInfo() {
        return "Owner: " + name +
                ", Model: " + model +
                ", Plate: " + plateNumber;
    }

    public void delivery(String from, String to) {
        System.out.println("Delivering from " + from + " to " + to + " by " + name);
    }
}

/*public class Truck {

    public String model;
    public String name;

    public void setTruckInfo(String m, String n) {
        model = m;
        name = n;
    }

    public void delivery(String from, String to) {
        System.out.println("Delivering " + from + " to " + to + " by " + name);
    }
}*/
