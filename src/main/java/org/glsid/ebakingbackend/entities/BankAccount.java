package org.glsid.ebakingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glsid.ebakingbackend.enums.AccountStatus;

import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 4)
@Data @NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id

    private String id;
    private double balance;
    private Date createAt;
    private AccountStatus status ;
    @ManyToOne
    private Customer custumor;
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperations;

}
