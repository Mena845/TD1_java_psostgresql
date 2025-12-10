import org.junit.jupiter.api.Test;
import Class.DataRetriever;
import Class.Category;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataRetrieverCategoryTest {

    @Test
    public void testGetAllCategories() {
        DataRetriever dr = new DataRetriever();
        List<Category> categories = dr.getAllCategories();

        assertNotNull(categories);
        assertTrue(categories.size() > 0, "Il doit y avoir au moins une catégorie");
    }
}

