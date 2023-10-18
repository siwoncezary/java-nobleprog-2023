package pl.nobleprog.advanced.day1.c2interface;

import pl.nobleprog.advanced.day1.c1abstraction.Product;

public interface ProductService {
    int max = 100;
    int saveProduct(Product product);
    Product getById(int id);

    Product deleteById(int id);

   default Product sellProductById(int id){
        Product result;
        if ((result = getById(id)) != null){
            deleteById(id);
            registerTransaction();
            return result;
        }
        return null;
    }

    private void registerTransaction(){
        // logowanie transakcji
    }

}
