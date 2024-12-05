package org.mycompany.shopinventory.service;

import lombok.RequiredArgsConstructor;
import org.mycompany.shopinventory.dto.Product;
import org.mycompany.shopinventory.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Product updateProduct(Long id, Product product) {
        return repository.findById(id)
                         .map(existingProduct -> {
                             existingProduct.setName(product.getName());
                             existingProduct.setDescription(product.getDescription());
                             existingProduct.setPrice(product.getPrice());
                             existingProduct.setQuantity(product.getQuantity());
                             return repository.save(existingProduct);
                         }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
