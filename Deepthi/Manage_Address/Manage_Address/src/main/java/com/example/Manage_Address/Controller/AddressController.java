package com.example.Manage_Address.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Manage_Address.Entity.AddressEntity;
import com.example.Manage_Address.Service.AddressService;

@RestController
@RequestMapping("/address")

public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/hello")
	public String getAddre(){
		return "helo";
	}
	
	@GetMapping("/view")
	public List<AddressEntity> getAddress(){
		return addressService.getAddress();
	}
	@PostMapping("/add")
	public ResponseEntity<AddressEntity> saveAddress(@RequestBody AddressEntity address) {
		
		return ResponseEntity.ok(addressService.postaddress(address));
		
	}
	@PutMapping("/put")
	public AddressEntity update(@PathVariable Integer ID, @RequestBody AddressEntity address) {
		return addressService.updateAddress(ID, address);
		
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		return addressService.deleteAddress(id);
	}
	

}
