package com.bipro.ecommerce.Domain.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name="Email")
    private String email;
    @Column(name="Password")
    private String password;

}
