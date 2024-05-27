package com.Orderofproduct.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Orderofproduct.dao.OfferDao;
import com.Orderofproduct.entity.Offer;
import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferDao offerDao;

    public List<Offer> getAllOffers() {
        return offerDao.getAllOffers();
    }

    public Offer getOfferById(int id) {
        return offerDao.getOfferById(id);
    }

    public void createOffer(Offer offer) {
        offerDao.createOffer(offer);
    }

    public Offer updateOffer(int id, Offer updatedOffer) {
        return offerDao.updateOffer(id, updatedOffer);
    }

    public void deleteOffer(int id) {
        offerDao.deleteOffer(id);
    }
}
