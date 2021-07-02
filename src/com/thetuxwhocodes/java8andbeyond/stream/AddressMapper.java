package com.thetuxwhocodes.java8andbeyond.stream;
                                                                                                                                                                          
import java.util.ArrayList;                                                                                                                                               
import java.util.List;                                                                                                                                                    
import java.util.Map;                                                                                                                                                     
import java.util.stream.Collectors;                                                                                                                                       
                                                                                                                                                                          
public class AddressMapper {                                                                                                                                              
                                                                                                                                                                          
	public static void main(String[] args) {                                                                                                                              
		List<Address> addresses = new ArrayList<>();                                                                                                                      
                                                                                                                                                                          
		addresses.add(new Address(AddressType.PRIMARY, "TVM", true));                                                                                                     
		addresses.add(new Address(AddressType.SECONDARY, "EKM", false));                                                                                                  
		addresses.add(new Address(AddressType.TERTIARY, "KTR", false));                                                                                                   
                                                                                                                                                                          
		Map<AddressType, Address> map = addresses.stream().collect(Collectors.toMap(Address::getAddressType, address -> address));                                        
		System.out.println(map);                                                                                                                                          
                                                                                                                                                                          
		Map<AddressType, Address> filteredMap = addresses.stream().filter(Address::isMailingAddress)
				.collect(Collectors.toMap(Address::getAddressType, address -> address));                                                                                  
		System.out.println(filteredMap);                                                                                                                                  
		                                                                                                                                                                  
		long countOfMailingAddresses= addresses.stream().filter(Address::isMailingAddress).count();
		System.out.println("countOfMailingAddresses = " + countOfMailingAddresses);                                                                                       
	}                                                                                                                                                                     
                                                                                                                                                                          
}                                                                                                                                                                         
                                                                                                                                                                          
class Address {                                                                                                                                                           
                                                                                                                                                                          
	AddressType addressType;                                                                                                                                              
	String data;                                                                                                                                                          
	boolean isMailingAddress;                                                                                                                                             
                                                                                                                                                                          
	public Address(AddressType addressType, String data, boolean isMailingAddress) {                                                                                      
		super();                                                                                                                                                          
		this.addressType = addressType;                                                                                                                                   
		this.data = data;                                                                                                                                                 
		this.isMailingAddress = isMailingAddress;                                                                                                                         
	}                                                                                                                                                                     
                                                                                                                                                                          
	public AddressType getAddressType() {                                                                                                                                 
		return addressType;                                                                                                                                               
	}                                                                                                                                                                     
                                                                                                                                                                          
	public void setAddressType(AddressType addressType) {                                                                                                                 
		this.addressType = addressType;                                                                                                                                   
	}                                                                                                                                                                     
                                                                                                                                                                          
	public String getData() {                                                                                                                                             
		return data;                                                                                                                                                      
	}                                                                                                                                                                     
                                                                                                                                                                          
	public void setData(String data) {                                                                                                                                    
		this.data = data;                                                                                                                                                 
	}                                                                                                                                                                     
                                                                                                                                                                          
	public boolean isMailingAddress() {                                                                                                                                   
		return isMailingAddress;                                                                                                                                          
	}                                                                                                                                                                     
                                                                                                                                                                          
	public void setMailingAddress(boolean isMailingAddress) {                                                                                                             
		this.isMailingAddress = isMailingAddress;                                                                                                                         
	}                                                                                                                                                                     
                                                                                                                                                                          
	@Override                                                                                                                                                             
	public String toString() {                                                                                                                                            
		return String.format("<%s -- %s (%s)>", addressType, data, isMailingAddress ? "Mailing" : "NonMailing");                                                          
	}                                                                                                                                                                     
                                                                                                                                                                          
}                                                                                                                                                                         
                                                                                                                                                                          
enum AddressType {                                                                                                                                                        
	PRIMARY, SECONDARY, TERTIARY                                                                                                                                          
}                                                                                                                                                                         
                                                                                                                                                                          
