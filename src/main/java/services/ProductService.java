package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * ISOLATION LEVELS:
     *
     * DEFAULT ---> read committed
     *
     * READ_UNCOMMITTED
     * READ_COMMITTED
     * REPEATABLE_READ
     * SERIALIZABLE
     *
     *
     * PROBLEMS:
     * -dirty reads
     * -repeatable reads
     * -phantom reads
     *
     *
     * */

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void addTenProducts() {
        for(int i = 0; i <= 10; i++){
            productRepository.addProduct("Product" + i);
        }
    }
}
