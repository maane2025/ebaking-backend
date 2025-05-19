package org.glsid.ebakingbackend.repositories;

import org.glsid.ebakingbackend.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository  extends JpaRepository<AccountOperation,Long> {
}
