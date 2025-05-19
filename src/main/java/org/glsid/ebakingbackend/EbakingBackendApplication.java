package org.glsid.ebakingbackend;

import org.glsid.ebakingbackend.entities.CurrentAccount;
import org.glsid.ebakingbackend.entities.Customer;
import org.glsid.ebakingbackend.entities.SavingAccount;
import org.glsid.ebakingbackend.enums.AccountStatus;
import org.glsid.ebakingbackend.repositories.AccountOperationRepository;
import org.glsid.ebakingbackend.repositories.CustomerRepository;
import org.glsid.ebakingbackend.repositories.bankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbakingBackendApplication {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public EbakingBackendApplication(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    public static void main(String[] args) {
        SpringApplication.run(EbakingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, bankAccountRepository bankAccountRepository, AccountOperationRepository accountOperationRepository) {
        return args -> {
            Stream.of("hassna", "Malika", "Aimane").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(cust -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random() * 90000);
                currentAccount.setCreateAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustumor(cust);
                currentAccount.setOverDraft(90000);
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random() * 90000);
                savingAccount.setCreateAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustumor(cust);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);
            });
        };
    }
}
