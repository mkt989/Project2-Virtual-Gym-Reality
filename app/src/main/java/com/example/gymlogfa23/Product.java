package com.example.gymlogfa23;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gymlogfa23.db.AppDatabase;

@Entity(tableName = AppDatabase.PRODUCT_TABLE)
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int mProductId;

    private String mProductName;
    private String mDescription;
    private double mPrice;

    public Product(int productId, String productName, String description, double price) {
        mProductId = productId;
        mProductName = productName;
        mDescription = description;
        mPrice = price;
    }

    public int getProductId() {
        return mProductId;
    }

    public void setProductId(int productId) {
        mProductId = productId;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "mProductId=" + mProductId +
                ", mProductName='" + mProductName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }
}
