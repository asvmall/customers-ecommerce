package com.example.Manage_Address.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressdetail")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private Long phonenumber;

    @Column(name = "pincode")
    private Integer pincode;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "locality")
    private String locality;

    @Column(name = "flat_no")
    private Integer flat_no;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "type")
    private String type;

    // ⭐ IMPORTANT: JPA needs this default constructor
    public AddressEntity() {
    }

	public AddressEntity(Integer iD, String name, Long phonenumber, Integer pincode, String city, String state,
			String locality, Integer flat_no, String landmark, String type) {
		super();
		ID = iD;
		this.name = name;
		this.phonenumber = phonenumber;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.locality = locality;
		this.flat_no = flat_no;
		this.landmark = landmark;
		this.type = type;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public Integer getFlat_no() {
		return flat_no;
	}

	public void setFlat_no(Integer flat_no) {
		this.flat_no = flat_no;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    
}
