package session;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangnan01 on 2017/6/16.
 *
 */
public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String email;
    String group;

    Person(String nameArg, LocalDate birthdayArg, Sex genderArg, String emailArg, String groupArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        email = emailArg;
        group = groupArg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return birthday.until(IsoChronology.INSTANCE.dateNow()).getYears();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public static List<Person> createRoster() {
        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "Fred",
                        IsoChronology.INSTANCE.date(1980, 6, 20),
                        Sex.MALE,
                        "fred@example.com",
                        "1"));
        roster.add(
                new Person(
                        "Jane",
                        IsoChronology.INSTANCE.date(1990, 7, 15),
                        Sex.FEMALE, "jane@example.com",
                        "2"));
        roster.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Sex.MALE, "george@example.com",
                        "1"));
        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2000, 9, 12),
                        Sex.MALE, "bob@example.com",
                        "3"));

        return roster;
    }

    public void printPerson() {
        System.out.println(name + ":" + this.getAge());
    }

    public String toString(){
        return name + ":" + getAge();
    }
}
