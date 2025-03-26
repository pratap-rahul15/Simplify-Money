// DB repository  will handle the DB operations like fetching & saving data.

package com.simplifymoney.insurance_api.repository;


import com.simplifymoney.insurance_api.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    // JpaRepository is used as it provide built-in methods like findAll(), save(), deleteById() et cetra.
}
