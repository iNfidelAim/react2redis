package ru.afanasiev.react2redis.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "inn")
public class Inn {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotEmpty(message = "Наименование не должно быть пустым")
    @Size(min = 2, max = 100, message = "Наименование не должно быть от 2 до 100 символов длиной")
    @Column(name = "pesron_id")
    private int personId;

    @Column(name = "number")
    private int number;


    public Inn() {
    }

    public Inn(int id, int personId, int number, Person person) {
        this.id = id;
        this.personId = personId;
        this.number = number;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public String toString() {
        return "Inn{" +
                "id=" + id +
                ", personId=" + personId +
                ", number=" + number +
                ", person=" +
                '}';
    }
}
