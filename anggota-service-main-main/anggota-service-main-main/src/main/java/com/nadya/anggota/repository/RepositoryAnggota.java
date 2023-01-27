/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nadya.anggota.repository;

import com.nadya.anggota.entity.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author win 11
 */
public interface RepositoryAnggota extends JpaRepository<Anggota, Long>{
    public Anggota findByAnggotaId(Long anggotaId);
}
