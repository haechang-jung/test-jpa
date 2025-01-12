package me.hc999.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Entity
@Data
@ToString
@Table(name="customer_tb")
public class Customer {

    @Id
    private String id;
    private String name;
    private long registerDate;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.registerDate = System.currentTimeMillis();
    }

    public static Customer sample() {
        return new Customer("ID0001", "Jung");
    }
}
