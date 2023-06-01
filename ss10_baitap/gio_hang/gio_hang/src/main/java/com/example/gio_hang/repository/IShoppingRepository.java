package com.example.gio_hang.repository;

import com.example.gio_hang.model.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShoppingRepository extends JpaRepository<Shopping ,Integer> {
}
