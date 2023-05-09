package com.belz.bicontrolapi.repository;

import com.belz.bicontrolapi.entity.SafUnidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SafUnidadesRepository extends JpaRepository<SafUnidades, String> {

    SafUnidades findByMarca(String marca);


}
