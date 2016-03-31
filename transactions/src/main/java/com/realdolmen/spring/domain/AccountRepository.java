package com.realdolmen.spring.domain;

import com.realdolmen.spring.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
