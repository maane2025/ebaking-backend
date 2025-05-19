package org.glsid.ebakingbackend.repositories;

import org.glsid.ebakingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
