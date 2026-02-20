
package org.prog.collections.session11;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        List<Phone> androids = new ArrayList<>();
        List<Phone> apples = new ArrayList<>();

        // Android (10, один розовый)
        androids.add(new Phone("Samsung", "Black"));
        androids.add(new Phone("Samsung", "White"));
        androids.add(new Phone("Xiaomi", "Blue"));
        androids.add(new Phone("Xiaomi", "Green"));
        androids.add(new Phone("Pixel", "Gray"));
        androids.add(new Phone("Pixel", "White"));
        androids.add(new Phone("OnePlus", "Black"));
        androids.add(new Phone("OnePlus", "Blue"));
        androids.add(new Phone("Motorola", "Silver"));
        androids.add(new Phone("Samsung", "Pink")); // розовый

        // Apple (10, один золотой)
        apples.add(new Phone("iPhone", "Black"));
        apples.add(new Phone("iPhone", "White"));
        apples.add(new Phone("iPhone", "Blue"));
        apples.add(new Phone("iPhone", "Red"));
        apples.add(new Phone("iPhone", "Purple"));
        apples.add(new Phone("iPhone", "Green"));
        apples.add(new Phone("iPhone", "Silver"));
        apples.add(new Phone("iPhone", "Gold")); // золотой
        apples.add(new Phone("iPhone", "Gray"));
        apples.add(new Phone("iPhone", "Blue Pro"));

        // Проверки
        boolean pinkAndroidExists = androids.stream()
                .anyMatch(p -> p.getColor().equals("Pink"));

        boolean goldAndroidExists = androids.stream()
                .anyMatch(p -> p.getColor().equals("Gold"));

        boolean goldAppleExists = apples.stream()
                .anyMatch(p -> p.getColor().equals("Gold"));

        boolean pinkAppleExists = apples.stream()
                .anyMatch(p -> p.getColor().equals("Pink"));

        System.out.println("Pink Android exists: " + pinkAndroidExists);
        System.out.println("Gold Android exists: " + goldAndroidExists);
        System.out.println("Gold Apple exists: " + goldAppleExists);
        System.out.println("Pink Apple exists: " + pinkAppleExists);
    }
}/*package org.prog.collections.session11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TODO: Create list of Android phones and list of Apple Phones (10 each)
//TODO: One Android must be pink, NO PINK APPLES
//TODO: One Apple must be gold, NO GOLD ANDROIDS
//TODO: 1. confirm pink android is in the list of androids
//TODO: 2. confirm gold android is NOT in the list of androids
//TODO: 3. Same of pink/gold Apple

public class ListDemo {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        System.out.println(list.isEmpty());
//        System.out.println(list.size());
//        list.add("a");//0
//        list.add(null);//1
//        list.add(null);//2
//        list.add("b");//3
//        System.out.println(list.isEmpty());
//        System.out.println(list.size());
//        System.out.println(list.get(0));
//        System.out.println(list.get(3));
//        list.add(1, "c");
//        System.out.println(list.size());
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(4));

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("c");
        list1.add("d");

        list2.add("d");
        list2.add("e");
        list2.add("f");
        list2.add("g");

//        list1.addAll(list2);
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//        }
//        System.out.println("============================");
//        list1.removeAll(list2);
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//        }

        List<Owner> owners = new ArrayList<>();
        owners.add(new Owner("Alice","A"));
        owners.add(new Owner("Billy","B"));
        owners.add(new Owner("Charlie","C"));
        owners.add(new Owner("Douglas","D"));
        owners.add(new Owner("Evil","E"));
        owners.add(new Owner("Fred","F"));
        owners.add(new Owner("Gary","G"));
        owners.add(new Owner("Henry","H"));
        owners.add(new Owner("Ivan","I"));
        owners.add(new Owner("Jack","J"));

        Collections.shuffle(owners);
        System.out.println(owners);


//        System.out.println(owners.size());
//        owners.remove(new Owner("Charlie","C"));
//        System.out.println(owners.size());

//        System.out.println(owners.contains(new Owner("Evil","E")));
//
//        List<Owner> debtOwners = new ArrayList<>();
//        debtOwners.add(new Owner("Alice", "A"));
//        debtOwners.add(new Owner("Billy", "B"));
//
//        owners.set(0, new Owner("Kate", "K"));
//        List<Owner> subOwners = owners.subList(2,5);
//
//        for (Owner owner : subOwners) {
//            System.out.println(owner);
//        }
//
//        System.out.println(owners.get(100));
    }
}*/
