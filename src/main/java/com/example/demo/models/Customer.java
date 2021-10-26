package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String nic;
    @NonNull
    private String phone;
    @NonNull
    private String email;
    @NonNull
    private Timestamp createdAt;

    @OneToMany(targetEntity = Subscription.class,mappedBy = "customer",  cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Subscription> subscriptions;

    public Customer() {
    }

    public Customer(Integer id, @NonNull String firstName, @NonNull String lastName, @NonNull String nic, @NonNull String phone, @NonNull String email, @NonNull Timestamp createdAt, Set<Subscription> subscriptions) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.phone = phone;
        this.email = email;
        this.createdAt = createdAt;
        this.subscriptions = subscriptions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getNic() {
        return nic;
    }

    public void setNic(@NonNull String nic) {
        this.nic = nic;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
