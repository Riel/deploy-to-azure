package com.gfa.deploytoazure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "healthy_products")
public class Product implements Comparable<Product> {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name= "product_name")
  private String name;
  private int quantity;
  private int price;

  public Product() {
  }

  public Product(String name, int quantity, int price) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getPrice() {
    return price;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Id: " + id + " , name: " + name + " , quantity: " + quantity + " , price: " + price;
  }

  @Override
  public int compareTo(Product otherProduct) {
    return Integer.compare(this.id, otherProduct.getId());
  }
}
