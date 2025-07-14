package com.example.demo.controllers;
import com.example.demo.models.Bill;
import com.example.demo.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController
{
    @Autowired
    BillService billService;
    @GetMapping
    public List<Bill> getAllBills()
    {
        System.out.println("Fetching all the Bills");
        return billService.getAllBills();
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill)
    {
        System.out.println("Creating Bill");
        return billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id)
    {
        System.out.println("Fetching Bill By ID: " + id);
        return billService.getBillById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id)
    {
        System.out.println("Deleting the Bill By Id: " + id);
        billService.deleteBill(id);
    }

    @PutMapping("/{id}")
    public void updateBill(@PathVariable Long id, @RequestBody Bill bill)
    {
        System.out.println("Updating the Bill With Specific Id: " + id);
        billService.updateBill(id,bill);
    }
}
