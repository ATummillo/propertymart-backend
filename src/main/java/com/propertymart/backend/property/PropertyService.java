package com.propertymart.backend.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Property updateProperty(Long id, Property property) {
        if (propertyRepository.existsById(id)) {
            property.setId(id);
            return propertyRepository.save(property);
        } else {
            throw new IllegalArgumentException("Property with ID " + id + " does not exist.");
        }
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
