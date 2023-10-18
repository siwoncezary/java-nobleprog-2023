package pl.nobleprog.advanced.day1.c2interface;

import pl.nobleprog.advanced.day1.c1abstraction.Product;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MemoryProductService implements ProductService, Serializable {
    private Map<Integer, Product> map = new HashMap<>();
    private int id = 0;
    @Override
    public int saveProduct(Product product) {
        map.put(++id, product);
        return id;
    }

    @Override
    public Product getById(int id) {
        return map.get(id);
    }

    @Override
    public Product deleteById(int id) {
        return map.remove(id);
    }

}
