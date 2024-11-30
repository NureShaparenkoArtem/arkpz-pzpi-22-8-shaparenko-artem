package com.example.SRBDlab3.good;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/v1/good")
@CrossOrigin(origins = "http://localhost:3000")
public class GoodController {
    private final GoodService goodService;

    @Autowired
    public GoodController(GoodService goodService){
        this.goodService = goodService;
    }

    @PostMapping("/update-description")
    public void updateDescription(@RequestParam("departmentId") Integer departmentId) {
        goodService.updateDescription(departmentId);
    }

    @PutMapping("/{goodId}/price")
    public ResponseEntity<?> updateGoodPrice(
            @PathVariable Integer goodId,
            @RequestParam Double newPrice) {
        try {
            goodService.updateGoodPrice(goodId, newPrice);
            return ResponseEntity.ok(Map.of("message", "Price updated successfully"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Map.of("error", "An unexpected error occurred: " + e.getMessage()));
        }
    }

    @GetMapping
    public List<Good> getGoods(){
        return goodService.getGoods();
    }
}