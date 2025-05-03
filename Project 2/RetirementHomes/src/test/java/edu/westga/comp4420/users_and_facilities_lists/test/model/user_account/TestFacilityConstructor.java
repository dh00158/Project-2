package edu.westga.comp4420.users_and_facilities_lists.test.model.facility;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import edu.westga.comp4420.users_and_facilities_lists.model.Facility;

class TestFacilityConstructor {
	
	@ParameterizedTest
	@CsvSource({"Lovely Homes, 123 Sesame street, bob"})
	void testValidInput(String homeName, String address, String owner) {
		Facility testFacility = new Facility(homeName, address, owner);
		
		assertEquals(homeName, testFacility.getHomeName(), "checking the name of the facility");
		assertEquals(address, testFacility.getAddress(), "checking the address of the facility");
		assertEquals(owner, testFacility.getOwner(), "checking the owner of the facility");
	}
	
	@ParameterizedTest
	@CsvSource({", , ", "'', , 1", "bob, '', ''", "bob, 1, ''"})
	void testInvalidInput(String homeName, String address, String owner) {
		assertThrows(IllegalArgumentException.class, ()->{new Facility(homeName, address, owner);});
	}
}
