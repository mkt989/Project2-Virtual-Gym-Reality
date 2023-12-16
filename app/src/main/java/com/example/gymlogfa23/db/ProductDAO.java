package com.example.gymlogfa23.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gymlogfa23.Product;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    void insertProduct(Product product);

    @Insert
    void insertMultipleProducts(List<Product> products);

    @Update
    void updateProduct(Product product);

    @Delete
    void deleteProduct(Product product);

    @Query("SELECT * FROM " + AppDatabase.PRODUCT_TABLE)
    List<Product> getAllProducts();

    @Query("SELECT * FROM " + AppDatabase.PRODUCT_TABLE + " WHERE mProductId = :productId")
    Product getProductById(int productId);

    @Query("DELETE FROM " + AppDatabase.PRODUCT_TABLE)
    void deleteAllProducts();

    @Query("SELECT * FROM " + AppDatabase.PRODUCT_TABLE + " WHERE mPrice < :maxPrice")
    List<Product> getProductsCheaperThan(double maxPrice);

    @Query("SELECT * FROM " + AppDatabase.PRODUCT_TABLE + " WHERE mProductName LIKE :searchQuery")
    List<Product> searchProductsByName(String searchQuery);

}
