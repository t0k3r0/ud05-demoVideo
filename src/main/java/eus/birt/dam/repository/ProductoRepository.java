package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
