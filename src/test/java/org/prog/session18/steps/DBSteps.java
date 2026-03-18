package org.prog.session18.steps; // пакет

import io.cucumber.java.en.And; // аннотация And
import org.prog.session18.model.Phone; // класс Phone
import org.testng.Assert; // для assert

import java.sql.Connection; // соединение с БД
import java.sql.PreparedStatement; // SQL запрос
import java.sql.ResultSet; // результат запроса
import java.util.List; // список

public class DBSteps { // класс шагов для БД

    public static Connection connection;
    // connection приходит из CucumberRunner

    @And("check phones in db")
    // шаг из feature

    public void checkPhonesInDb() throws Exception {

        List<Phone> phones = GoogleSteps.phones;
        // берём телефоны найденные на сайте

        for (Phone phone : phones) {
            // проверяем каждый телефон

            PreparedStatement select =
                    connection.prepareStatement(
                            "select price from phones where model=?"
                    );
            // SQL запрос найти цену по модели

            select.setString(1, phone.getModel());
            // в ? подставляем модель

            ResultSet rs = select.executeQuery();
            // выполняем запрос

            if (rs.next()) {
                // если модель есть в БД

                int dbPrice = rs.getInt("price");
                // берём цену из БД

                Assert.assertEquals(
                        dbPrice,
                        phone.getPrice()
                );
                // проверяем что цена совпадает

            } else {
                // если модели нет в БД

                PreparedStatement insert =
                        connection.prepareStatement(
                                "insert into phones(model, price) values(?, ?)"
                        );
                // SQL вставка

                insert.setString(1, phone.getModel());
                // подставить модель

                insert.setInt(2, phone.getPrice());
                // подставить цену

                insert.executeUpdate();
                // выполнить insert
            }
        }
    }
}
/*package org.prog.session18.steps;

import io.cucumber.java.en.Given;
import org.prog.session16.dto.PersonDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBSteps {

    public static Connection connection;

    public static final List<String> randomNames = new ArrayList<>();

    @Given("I store these people in DB")
    public void storePeopleInDB() throws SQLException {
        //turn them to java list
        List<PersonDto> persons = ApiSteps.results.getResults();

        //for each element in list -> record to DB
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                        "VALUES (?, ?, ?, ?, ?)");

        for (PersonDto person : persons) {
            preparedStatement.setString(1, person.getName().getFirst());
            preparedStatement.setString(2, person.getName().getLast());
            preparedStatement.setString(3, person.getGender());
            preparedStatement.setString(4, person.getName().getTitle());
            preparedStatement.setString(5, person.getNat());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to insert into DB " + person);
            }
        }
    }

    @Given("I pick {int} random person from DB")
    public void pickRandomPersonFromDB(int amount) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from Persons ORDER BY RAND() LIMIT " + amount);

        randomNames.clear();
        while (resultSet.next()) {
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            randomNames.add(firstName + " " + lastName);
        }
    }
}
*/