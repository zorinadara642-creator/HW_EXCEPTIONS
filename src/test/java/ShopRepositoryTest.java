import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Bread", 50);
        Product product2 = new Product(2, "Milk", 90);
        Product product3 = new Product(3, "Cheese", 400);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenRemovingNonExistingProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Bread", 50));
        repo.add(new Product(2, "Milk", 90));

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(100));
    }
}
