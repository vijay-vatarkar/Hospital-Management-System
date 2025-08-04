package com.in.hopsitalManagementSystem.controllers;

import com.in.hopsitalManagementSystem.services.BillService;
import com.in.hopsitalManagementSystem.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/v1/bill"})
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping
    public Bill createBill(@RequestBody Bill bill){
        System.out.println("creating a bill..");
        return billService.createBill(bill);
    }

    @GetMapping
    public Page<Bill> getAllBill(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size){
        System.out.println("getting all bills of patients...");
        return billService.getAllBill(page,size);
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id){
        System.out.println("fetching patient bill by ID:"+ id);
        return billService.getBillById(id);
    }

    @PutMapping("/{id}")
    public Bill updateBillById(@PathVariable Long id, @RequestBody Bill bill){
        System.out.println("upadated Patient bill by ID:"+ id);
        return billService.updateBill(id, bill);
    }

    @DeleteMapping("/{id}")
    public void deleteBillById(@PathVariable Long id){
        System.out.println("Deleting Billing by ID:"+ id);
        billService.deleteBill(id);
    }
}
