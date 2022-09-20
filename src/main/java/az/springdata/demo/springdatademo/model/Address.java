package az.springdata.demo.springdatademo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;


    @OneToOne
    private Employee employee;

}
