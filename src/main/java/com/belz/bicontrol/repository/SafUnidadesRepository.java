package com.belz.bicontrol.repository;

import com.belz.bicontrol.entity.SafUnidades;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SafUnidadesRepository extends JpaRepository<SafUnidades, Long> {

    @Query("SELECT u FROM SafUnidades u")
    Page<SafUnidades> findAllPagination(Pageable pageable);
}
