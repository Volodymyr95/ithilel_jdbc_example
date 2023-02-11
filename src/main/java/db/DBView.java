package db;

import models.Person;

import java.sql.*;
import java.util.ArrayList;

public class DBView {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_example";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";

    public void getAllPersons() {
        Connection connection = getConnection();
        ArrayList<Person> people = new ArrayList<>();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM persons");
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                people.add(new Person(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getInt(4)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        people.forEach(person -> System.out.println(person.toString()));

    }

    public void addPerson(Person person) {
        Connection connection = getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO persons(first_name, last_name,age");
            prepareStatement.setString(1, person.getFirstName());
            prepareStatement.setString(2, person.getLastName());
            prepareStatement.setInt(3, person.getAge());

            prepareStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            System.out.println("SQL Error");
        }
        return connection;
    }
}
