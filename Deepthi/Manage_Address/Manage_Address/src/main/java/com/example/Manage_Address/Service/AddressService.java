package com.example.Manage_Address.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Manage_Address.Entity.AddressEntity;
import com.example.Manage_Address.Repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public List<AddressEntity> getAddress(){
		return addressRepository.findAll();
		}
	
	public AddressEntity postaddress(AddressEntity address)
	{
		return addressRepository.save(address);
	}
	public AddressEntity updateAddress(Integer ID,AddressEntity newdata) {
		Optional<AddressEntity> old=addressRepository.findById(ID);
		
		if(old.isPresent()) {
			AddressEntity address=old.get();
			address.setName(newdata.getName());
			address.setPhonenumber(newdata.getPhonenumber());
			address.setPincode(newdata.getPincode());
			address.setCity(newdata.getCity());
			address.setState(newdata.getState());
			address.setLocality(newdata.getLocality());
			address.setFlat_no(newdata.getFlat_no());
			address.setLandmark(newdata.getLandmark());
			address.setType(newdata.getType());
			return addressRepository.save(address);
		}
		return null;
		
	}
	public String deleteAddress(Integer ID) {
		addressRepository.deleteById(ID);
		return "Deleted Address Successfully";
	}
}
