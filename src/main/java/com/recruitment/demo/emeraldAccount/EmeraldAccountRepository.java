package com.recruitment.demo.emeraldAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmeraldAccountRepository extends JpaRepository<EmeraldAccount, Long> {

}
