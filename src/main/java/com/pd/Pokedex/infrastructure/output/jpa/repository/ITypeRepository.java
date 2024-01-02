package com.pd.Pokedex.infrastructure.output.jpa.repository;

import com.pd.Pokedex.infrastructure.output.jpa.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepository extends JpaRepository<TypeEntity, Long> {
}
