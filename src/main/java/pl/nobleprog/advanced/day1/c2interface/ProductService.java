package pl.nobleprog.advanced.day1.c2interface;

public interface ProductService {
    int MAX_COUNT = 10;
    int addProduct(String product);
    String getProduct(int id);
    void deleteProduct(int id);

    default String sellProduct(int id){
        String product;
        if ((product = getProduct(id))!= null){
            deleteProduct(id);
            registerTransaction();
            return product;
        }
        return null;
    }

    private void registerTransaction(){

    }
}
