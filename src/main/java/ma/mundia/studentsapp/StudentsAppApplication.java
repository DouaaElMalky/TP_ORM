package ma.mundia.studentsapp;

import ma.mundia.studentsapp.entities.Product;
import ma.mundia.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(StudentsAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        productRepository.save(new Product(null, "Computer", 4300, 3));
//        productRepository.save(new Product(null, "Printer", 1200, 4));
//        productRepository.save(new Product(null, "Smartphone", 3200, 32));
        System.out.println("**************");
        List<Product> products = productRepository.findAll();
        System.out.println("***** Affichage de la liste complète des produits :*****");
        products.forEach(p->{
            System.out.println(p.toString());
        });

        System.out.println("________________________________");
        Product product=productRepository.findById(Long.valueOf(2)).get();
        System.out.println("***** Affichage d'un produit par son ID *****");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("________________________________");
        System.out.println("***** Recherche par mot clé (méthode Contains) *****");
        List<Product> productList2=productRepository.findByNameContainsIgnoreCase("C");
        productList2.forEach(product1 -> {
            System.out.println(product1);
        });
        System.out.println("________________________________");
        System.out.println("***** Recherche par mot clé (méthode Query) *****");
        List<Product> productList3=productRepository.search("%C%");
        productList3.forEach(product2 -> {
            System.out.println(product2);
        });
        System.out.println("________________________________");
        System.out.println("***** Recherche par prix supérieur à un seuil (findByPrice) *****");
        List<Product> productList4=productRepository.findByPriceGreaterThan(5000);
        productList4.forEach(product3 -> {
            System.out.println(product3);
        });
        System.out.println("________________________________");
        System.out.println("***** Recherche par prix supérieur à un seuil (méthode Query) *****");
        List<Product> productList5=productRepository.searchByPrice(5000);
        productList5.forEach(product4 -> {
            System.out.println(product4);
        });
        System.out.println("________________________________");
    }
}
