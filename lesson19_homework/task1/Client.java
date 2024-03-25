package org.example.homeworks.lesson19_homework.task1;

import java.io.Serializable;

public class Client implements Serializable {
    private Long id;
    private String status;
    private Long taxCode;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

    public Client(Long id, String status, Long taxCode, String firstName, String lastName, String email, String address,String phone) {
        this.id = id;
        this.status = status;
        this.taxCode = taxCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Long getTaxCode() {
        return taxCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", taxCode=" + taxCode +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "Client \n" +
//                "id:" + id + "\n" +
//                "status:" + status + "\n" +
//                "taxCode=" + taxCode + "\n" +
//                "firstName=" + firstName + "\n" +
//                "lastName=" + lastName + "\n" +
//                "email=" + email + "\n" +
//                "address=" + address + "\n" +
//                "phone=" + phone;
//    }
}
