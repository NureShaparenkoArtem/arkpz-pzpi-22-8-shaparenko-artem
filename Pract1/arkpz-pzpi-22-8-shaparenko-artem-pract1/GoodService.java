package com.example.SRBDlab3.good;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class GoodService {

    private final GoodRepository goodRepository;

    @Autowired
    public GoodService(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    @Transactional
    public void updateDescription(Integer departmentId) {
        goodRepository.updateDescription(departmentId);
    }

    @Transactional
    public void updateGoodPrice(int goodId, double newPrice) {
        try {
            goodRepository.updateGoodPrice(goodId, newPrice);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            while (cause != null) {
                if (cause.getMessage() != null && cause.getMessage().contains("Product with ID")) {
                    String cleanMessage = cause.getMessage().split("Where:")[0].trim();
                    throw new IllegalArgumentException(cleanMessage);
                }
                cause = cause.getCause();
            }
            throw new RuntimeException("Unexpected error occurred");
        }
    }



    public List<Good> getGoods() {
        return goodRepository.findAll();
    }
}