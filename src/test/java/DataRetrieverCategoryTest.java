import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataRetrieverCategoryTest {

    @Test
    public void testGetAllCategories() {
        DataRetriever dr = new DataRetriever();
        List<Category> categories = dr.getAllCategories();

        assertNotNull(categories);
        assertTrue(categories.size() > 0, "Il doit y avoir au moins une catégorie");
    }
}

