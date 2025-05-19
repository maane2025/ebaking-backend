package org.glsid.ebakingbackend.repositories;

import org.glsid.ebakingbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bankAccountRepository  extends JpaRepository<BankAccount,String> {
}
