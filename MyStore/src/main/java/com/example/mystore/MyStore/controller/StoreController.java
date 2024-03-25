package com.example.mystore.MyStore.controller;
import com.example.mystore.MyStore.model.Address;
import com.example.mystore.MyStore.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

//mcv model view controller

@RestController
public class StoreController {

    @Autowired
    StoreRepository StoreRepository;

    //get all addresses
    @GetMapping("/get-all-addresses")
    public List<Address> getAddresses()
    {
        return StoreRepository.findAll();
    }

    @GetMapping("/get-address/{id}")
    public Address getAddress(@PathVariable("id") Integer id)
    {
        return StoreRepository.findById(id).get();
    }

    @DeleteMapping("/remove-address/{id}")
    public boolean removeAddress(@PathVariable("id") Integer id)
    {
       if(StoreRepository.existsById(id))
       {
           StoreRepository.deleteById(id);
           return true;
       }
         return false;
    }

    @PutMapping("/update-address/{id}")
    public Address updateAddress(@PathVariable("id") Integer id, @RequestBody Map<String, String> body)
    {
            Address current = StoreRepository.findById(id).get();
            current.setNumber(Integer.parseInt(body.get("number")));
            current.setStreet(body.get("street"));
            current.setPostalCode(body.get("postalCode"));
            StoreRepository.save(current);
            return current;
    }

    @PostMapping("/add-address")
    public Address addAddress(@RequestBody Map<String, String> body)
    {
        Address address = new Address();
        address.setNumber(Integer.parseInt(body.get("number")));
        address.setStreet(body.get("street"));
        address.setPostalCode(body.get("postalCode"));
        StoreRepository.save(address);
        return address;
    }
}
