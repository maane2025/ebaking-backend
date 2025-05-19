package org.glsid.ebakingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glsid.ebakingbackend.enums.AccountStatus;

import java.util.Date;
import java.util.List;
@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id

    private String id;
    private double balance;
    private Date createAt;
    private AccountStatus status ;
    @ManyToOne
    private Custumor custumor;
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperations;

}
