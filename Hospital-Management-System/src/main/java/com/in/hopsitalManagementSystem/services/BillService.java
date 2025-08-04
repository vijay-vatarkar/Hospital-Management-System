package com.in.hopsitalManagementSystem.services;

import com.in.hopsitalManagementSystem.controllers.BillController;
import com.in.hopsitalManagementSystem.models.Bill;
import com.in.hopsitalManagementSystem.repository.BillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    @Autowired
    private BillRepository billRepository;

    public Page<Bill> getAllBill(int page, int size){
        try{
            System.out.println("Into Service Layer of Bill..");
            Pageable pageable = PageRequest.of(page, size);
            return billRepository.findAll(pageable);
        } catch (Exception e) {
            logger.error("An error occurred while fetching all Billings : {}", e.getMessage());
            return null;
        }
    }

    public Bill createBill(Bill bill){
        try{
            System.out.println("Creating Billing");
            return billRepository.save(bill);
        } catch (Exception e) {
            logger.error("An error occurred while creating billings : {}", e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id){
        try{
            System.out.println("Getting Billing By Id");
            Optional<Bill> bill = billRepository.findById(id);
            return bill.orElse(null);
        } catch (Exception e) {
            logger.error("An error occurred while fetching billing by id {} : {}", id, e.getMessage());
            return null;
        }
    }

    public Bill updateBill(Long id, Bill bill){
        try{
            System.out.println("Updating Billing");
            Optional<Bill> existingBill = billRepository.findById(id);
            if(existingBill.isPresent()){
                Bill b = existingBill.get();
                b.setPatientId(bill.getPatientId());
                b.setStatus(bill.getStatus());
                b.setAmount(bill.getAmount());

                billRepository.save(b);

            }else {
                logger.error("Bill with id{} not found", id);
            }

            return null;
        } catch (Exception e) {
            logger.error("An error occurred while updating billing by id {} : {}", id, e.getMessage());
            return null;
        }
    }

    public void deleteBill(Long id){
        try{
            System.out.println("Deleting Billing");
            billRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("An error occurred while deleting billing by id {} : {}", id, e.getMessage());
        }
    }

}
