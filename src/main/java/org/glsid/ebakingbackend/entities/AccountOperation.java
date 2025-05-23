package org.glsid.ebakingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glsid.ebakingbackend.enums.OperationType;

import java.util.Date;
@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class AccountOperation {
    @Id  @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    @ManyToOne
    private BankAccount bankAccount;
}
