package org.prog.session5;

public class Car {

    //TODO: add owner as String
    //TODO: make goTo print "car owned by {owner} is going to {destination} at {speed}
    //TODO: do not forget to set owner name :)

    public String color;
    public int mileage;
    public String plateNumber;
    public String owner;

    public void goTo(String destination, int speed) {
        System.out.println("before trip miles: " + mileage);

        if ("black".equals(color)) {
            System.out.println("black cars are cool");
        }

        mileage += speed * 10;

        System.out.println("Car owned by " + owner +
                " is going to " + destination +
                " at " + speed + " km/h");

        System.out.println("After trip miles: " + mileage);
    }}

