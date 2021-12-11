package com.jsfspring.curddemo.repositry;

import com.jsfspring.curddemo.entity.ShoeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepo extends JpaRepository<ShoeDTO, Long> {
}