import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    Product book = new Book("Ana Karenina",101, 100, "Tolstoi");
    Product book2 = new Book("Voina i Mir",102, 200, "Tolstoi");
    Product book3 = new Book("Tri Sestri",103, 300, "Tschechov");

    Product smart = new Smartphone("Iphone 11",987, 1000, "Apple");
    Product smart2 = new Smartphone("Galaxy X5",643, 900, "Samsung");
    Product smart3 = new Smartphone("ZTE 40",345, 422, "LG");

    ProductRepository repo = new ProductRepository();


    @Test
    public void shouldShowManufacturerOfSmartphone() {

        Smartphone smartphone = new Smartphone("Galaxy X5",643, 900, "Samsung");

        smartphone.setManufacturer("Samsung");

        String expected = "Samsung";
        String actual = smartphone.getManufacturer();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldNotShowDeleteElementOFSmartphone() {

        repo.save(smart);
        repo.save(smart2);
        repo.save(smart3);
        repo.removeById(smart2.getId());

        Product [] expected = {smart, smart3};
        Product [] actual = repo.getItems();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldShowAuthorOfBook() {

        Book book4 = new Book("Anna Karenina", 102, 100, "Tolstoi");

        book4.setAuthor("Tolstoi");

        String expected = "Tolstoi";
        String actual = book4.getAuthor() ;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldShowNameOfProduct() {

        Product product = new Product("Book", 123,300);

        product.setName("Book");

        String expected = "Book";
        String actual = product.getName() ;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldShowIdOfProduct() {

        Product product = new Product("Book", 123,300);

        product.setId(123);

        int expected = 123;
        int actual = product.getId();

    Assertions.assertEquals(expected,actual);
}

    @Test
    public void shouldShowPriseOfProduct() {

        Product product = new Product("Book", 123,300);

        product.setPrice(300);

        int expected = 300;
        int actual = product.getPrice();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldShowProduct() {

        repo.save(book);
        repo.save(book2);
        repo.save(book3);

        Product [] expected = {book, book2, book3};
        Product [] actual = repo.getItems();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldNotShowDeleteElement() {

        repo.save(book);
        repo.save(book2);
        repo.save(book3);
        repo.removeById(book.getId());

        Product [] expected = {book2, book3};
        Product [] actual = repo.getItems();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldSearchWithResult() {

        ProductManager manager = new ProductManager(repo);

        manager.add(book);
        manager.add(book2);
        manager.add(book3);

        Product [] expected = {book, book2, book3};
        Product [] actual = manager.searchBy("i");

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldSearchWithoutResult() {

        ProductManager manager = new ProductManager(repo);

        manager.add(book);
        manager.add(book2);
        manager.add(book3);

        Product [] expected = { };
        Product [] actual = manager.searchBy("j");

        Assertions.assertArrayEquals(expected,actual);
    }

}
