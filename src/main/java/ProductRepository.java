public class ProductRepository {

    private Product[] items = new Product[0];

    public void save(Product item) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int id) {

        Product[] tmp = new Product[items.length - 1];
        int newElement = 0;

        for (int i = 0; i < items.length; i++) {
            Product product = items[i];
            if (product.getId() != id) {
                tmp[newElement] = product;
                newElement++;
            }
        }
       items = tmp;
    }

    public Product[] getItems () {
        return items;
    }

    public Product[] findAll(){
        return items;
    }
}
