package com.example.SRBDlab3.good;

import com.example.SRBDlab3.department.Department;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "goods")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer good_id;
    private String name;
    private Double price;
    private Integer quantity;
    private String producer;
    private Long dept_id;
    private String description;

    public Good() {
    }

    public Good(Integer good_id,
                String name,
                Double price,
                Integer quantity,
                String producer,
                Long dept_id,
                String description) {
        this.good_id = good_id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
        this.dept_id = dept_id;
        this.description = description;
    }

    public Good(String name,
                Double price,
                Integer quantity,
                String producer,
                Long dept_id,
                String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.producer = producer;
        this.dept_id = dept_id;
        this.description = description;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Long getDept_id() {
        return dept_id;
    }

    public void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Good{" +
                "good_id=" + good_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", producer='" + producer + '\'' +
                ", dept_id=" + dept_id +
                ", description='" + description + '\'' +
                '}';
    }
}