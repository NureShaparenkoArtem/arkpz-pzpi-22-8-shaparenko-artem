package com.example.SRBDlab3.sale;

import com.example.SRBDlab3.good.Good;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sales")
public class SaleDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sale_id;
    private Long check_no;
    private Date date_sale;
    private Long quantity;
    @ManyToOne
    @JoinColumn(name = "good_id")
    private Good good;

    public SaleDTO() {
    }

    public SaleDTO(Integer sale_id, Long check_no, Date date_sale, Long quantity, Good good) {
        this.sale_id = sale_id;
        this.check_no = check_no;
        this.date_sale = date_sale;
        this.quantity = quantity;
        this.good = good;
    }

    public SaleDTO(Long check_no, Date date_sale, Long quantity, Good good) {
        this.check_no = check_no;
        this.date_sale = date_sale;
        this.quantity = quantity;
        this.good = good;
    }

    public Integer getSale_id() {
        return sale_id;
    }

    public void setSale_id(Integer sale_id) {
        this.sale_id = sale_id;
    }

    public Long getCheck_no() {
        return check_no;
    }

    public void setCheck_no(Long check_no) {
        this.check_no = check_no;
    }

    public Date getDate_sale() {
        return date_sale;
    }

    public void setDate_sale(Date date_sale) {
        this.date_sale = date_sale;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "SaleGTO{" +
                "sale_id=" + sale_id +
                ", check_no=" + check_no +
                ", date_sale=" + date_sale +
                ", price=" + quantity * good.getPrice() +
                ", good=" + good.getName() +
                ", producer=" + good.getProducer() +
                '}';
    }
}
