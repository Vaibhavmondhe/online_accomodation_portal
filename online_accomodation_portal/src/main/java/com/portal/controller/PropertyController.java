package com.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.AddPropertyDto;
import com.portal.dto.PropertyResponseDto;
import com.portal.service.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@PostMapping("/add")
	public ResponseEntity<?> addProperty(@RequestBody AddPropertyDto dto) {
		if (propertyService.addProperty(dto)) {
			return ResponseEntity.status(HttpStatus.OK).body("Property Added SuccessFully");
		}

		return ResponseEntity.status(HttpStatus.OK).body("Failed to Add Property");

	}

	@DeleteMapping("/delete/{propertyId}")
	public ResponseEntity<?> deleteProperty(@PathVariable Long propertyId) {
		System.out.println("Inside delete Property controller");

		if (!propertyService.deleteProperty(propertyId)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Property Not Found ...Failed To Delete Property!!");

		}

		return ResponseEntity.status(HttpStatus.OK).body("Property Deleted Successfully!!");
	}

	@GetMapping("/propertylist/{ownerId}")
	public ResponseEntity<?> getPropertyListByOwner(@PathVariable Long ownerId) {
		System.out.println("id = " + ownerId);
		List<PropertyResponseDto> propertyList = propertyService.getPropertyListByOwner(ownerId);

		if (propertyList == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong !! ");

		return ResponseEntity.status(HttpStatus.OK).body(propertyList);

	}

	@GetMapping("/properties/{city}")
	public ResponseEntity<?> getPropertyList(@PathVariable String city) {

		List<PropertyResponseDto> propertyList = propertyService.getPropertyList(city);
		System.out.println("City = " + city);
		if (propertyList == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong !! ");

		return ResponseEntity.status(HttpStatus.OK).body(propertyList);

	}

}
