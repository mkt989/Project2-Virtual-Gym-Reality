import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.example.gymlogfa23.GymLog;
import com.example.gymlogfa23.Product;
import com.example.gymlogfa23.User;
import com.example.gymlogfa23.db.AppDatabase;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private AppDatabase mAppDatabase;

    @Before
    public void createDatabase() {
        mAppDatabase = Room.inMemoryDatabaseBuilder(
                        ApplicationProvider.getApplicationContext(),
                        AppDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

    @After
    public void closeDatabase() {
        mAppDatabase.close();
    }

    @Test
    public void testUserInsertUpdateDelete() {
        // Insertion test for User table
        User user = new User("JohnDoe", "password", false);
        long userId = mAppDatabase.getUserDAO().insertUser(user);

        assertEquals(1, userId); // Ensure insertion was successful

        // Update test for User table
        user.setUserName("JaneDoe");
        mAppDatabase.getUserDAO().updateUser(user);

        User updatedUser = mAppDatabase.getUserDAO().getUserById((int) userId);
        assertEquals("JaneDoe", updatedUser.getUserName());

        // Deletion test for User table
        mAppDatabase.getUserDAO().deleteUser(updatedUser);
        User deletedUser = mAppDatabase.getUserDAO().getUserById((int) userId);
        assertNull(deletedUser);
    }

    @Test
    public void testGymLogInsertUpdateDelete() {
        // Insertion test for GymLog table
        GymLog gymLog = new GymLog("Exercise", 10, 50.5, 1);
        long logId = mAppDatabase.getGymLogDAO().insert(gymLog);

        assertEquals(1, logId); // Ensure insertion was successful

        // Update test for GymLog table
        gymLog.setExercise("New Exercise");
        mAppDatabase.getGymLogDAO().update(gymLog);

        GymLog updatedLog = mAppDatabase.getGymLogDAO().getGymLogById((int) logId);
        assertEquals("New Exercise", updatedLog.getExercise());

        // Deletion test for GymLog table
        mAppDatabase.getGymLogDAO().delete(updatedLog);
        GymLog deletedLog = mAppDatabase.getGymLogDAO().getGymLogById((int) logId);
        assertNull(deletedLog);
    }

    @Test
    public void testProductInsertUpdateDelete() {
        // Insertion test for Product table
        Product product = new Product(1, "Product", "Description", 25.99);
        long productId = mAppDatabase.getProductDAO().insertProduct(product);

        assertEquals(1, productId); // Ensure insertion was successful

        // Update test for Product table
        product.setProductName("New Product");
        mAppDatabase.getProductDAO().updateProduct(product);

        Product updatedProduct = mAppDatabase.getProductDAO().getProductById((int) productId);
        assertEquals("New Product", updatedProduct.getProductName());

        // Deletion test for Product table
        mAppDatabase.getProductDAO().deleteProduct(updatedProduct);
        Product deletedProduct = mAppDatabase.getProductDAO().getProductById((int) productId);
        assertNull(deletedProduct);
    }
}
