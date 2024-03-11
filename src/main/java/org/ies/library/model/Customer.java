package org.ies.library.model;

import java.util.Objects;

public class Customer {
    private String nif;
    private String name;
    private String surname;
    private int customerNumber;
    private int zipCode;


    public Customer(String nif, String name, String surname, int customerNumber, int zipCode) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.customerNumber = customerNumber;
        this.zipCode = zipCode;
    }

    public Customer() {
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerNumber != customer.customerNumber) return false;
        if (zipCode != customer.zipCode) return false;
        if (!Objects.equals(nif, customer.nif)) return false;
        if (!Objects.equals(name, customer.name)) return false;
        return Objects.equals(surname, customer.surname);
    }

    @Override
    public int hashCode() {
        int result = nif != null ? nif.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + customerNumber;
        result = 31 * result + zipCode;
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", customerNumber=" + customerNumber +
                ", zipCode=" + zipCode +
                '}';
    }
}
