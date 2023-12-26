//package com.sai.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.io.Serial;
//import java.io.Serializable;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "users")
//@Entity
//public class UserEntity implements Serializable {
//
//    private static final long serialVersionUID = -5656019010991649838L;
//
//    @Id
//    @GeneratedValue
//    private long id;
//
//    @Column(nullable = false, length = 50)
//    private String firstName;
//
//    @Column(nullable = false, length = 50)
//    private String lastName;
//
//    @Column(nullable = false, length = 120, unique = true)
//    private String email;
//
//    @Column(nullable = false, unique = true)
//    private String userId;
//
//    @Column(nullable = false, unique = true)
//    private String encryptedPassword;
//}
