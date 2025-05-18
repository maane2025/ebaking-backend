package org.glsid.ebakingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data @NoArgsConstructor @AllArgsConstructor
public class Custumor {
    private String id;
    private String name;
    private String email;
    private List<BankAccount> bankAccounts;

}
