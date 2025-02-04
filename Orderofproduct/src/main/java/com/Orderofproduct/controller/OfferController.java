package com.Orderofproduct.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.Orderofproduct.entity.Offer;
import com.Orderofproduct.service.OfferService;

import java.util.List;

@RestController
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/getall")
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    public Offer getOfferById(@PathVariable int id) {
        return offerService.getOfferById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createOffer(@RequestBody Offer offer) {
        offerService.createOffer(offer);
    }

    @PutMapping("/update/{id}")
    public Offer updateOffer(@PathVariable int id, @RequestBody Offer updatedOffer) {
        return offerService.updateOffer(id, updatedOffer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOffer(@PathVariable int id) {
        offerService.deleteOffer(id);
    }
}

