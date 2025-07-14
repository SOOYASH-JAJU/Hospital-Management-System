package com.example.demo.service;
import com.example.demo.models.Bill;
import com.example.demo.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService
{
    @Autowired
    BillRepository billRepository;

    public List<Bill> getAllBills()
    {
        try
        {
            System.out.println("Into Service Layer of Bill Class with get All bill");
            return billRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public Bill createBill(Bill bill)
    {
        try
        {
            System.out.println("Into Service Layer of Bill Class for Creating bill");
            billRepository.save(bill);
            return bill;
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id)
    {
        try
        {
            System.out.println("Into Service Layer of Bill Class for get bill By id: " + id);
             Optional<Bill> bill = billRepository.findById(id);
            return bill.orElse(null);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public void deleteBill(Long id)
    {
        try
        {
            System.out.println("Into Service Layer of Bill Class for Deleting bill By id: " + id);
            billRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }
    }

    public void updateBill(Long id, Bill bill)
    {
        try
        {
            System.out.println("Into Service Layer of Bill Class for Updating bill by id: " + id);
            Bill b = getBillById(id);

            if(b != null)
            {
                b.setPatientId(bill.getPatientId());
                b.setAmount(bill.getAmount());
                b.setStatus(bill.getStatus());
                billRepository.save(b);
            }
            else
            {
                System.out.println("No Entry Corresponding to Bill with id: " + id + " Cannot Update");
            }
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }
    }
}
