import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindTest {

    ShopRepository repository = new ShopRepository();
    Product product1 = new Product (9, "open", 999);
    Product product2 = new Product (7, "open", 999);
    Product product3 = new Product (54, "open", 999);
    Product product4 = new Product (1, "open", 999);

    @BeforeEach
    public void addProduct() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
    }

    @Test
    public void findTest() {

        Product expected = null;
        Product actual = repository.findById(-1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeByInvalidIdTest() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(8);
        });
    }

    @Test
    public void removeByIdTest() {

        repository.removeById(product2.getId());

        Product[] expected = {product1, product3, product4};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}
