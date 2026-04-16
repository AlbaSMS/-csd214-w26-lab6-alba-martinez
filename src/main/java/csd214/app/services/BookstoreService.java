package csd214.app.services;

import csd214.app.entities.*;
import csd214.app.entities.PublicationEntity;
import csd214.app.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {
    private final ProductRepository productRepo;
    private final SaleLogRepository logRepo;
    private final DiscountService discountService; // Nested Service

    // Spring Injects BOTH repositories here
    public BookstoreService(ProductRepository productRepo, SaleLogRepository logRepo, DiscountService discountService) {
        this.productRepo = productRepo;
        this.logRepo = logRepo;
        this.discountService = discountService;
    }

    @Transactional
    public void performSale(Long id) {
        ProductEntity item = productRepo.findById(id).orElse(null);
        if (item != null) {
            // Log the sale to the second table
            logRepo.save(new SaleLogEntity(item.getProductId(), item.getPrice()));
            System.out.println("Sale logged to Audit table.");
        }
    }

    public void sellWithDiscount(Long id, double percent) {
        ProductEntity item = productRepo.findById(id).orElse(null);
        if (item != null) {
            double finalPrice = discountService.applyDiscount(item.getPrice(), percent);
            System.out.println("Final Discounted Price: $" + finalPrice);
            performSale(id); // Logs the sale
        }
    }
}