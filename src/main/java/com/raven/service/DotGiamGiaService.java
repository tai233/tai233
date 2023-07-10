/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.service;

import com.raven.domainModel.DotGiamGia;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author user
 */
public interface DotGiamGiaService {
    
    List<DotGiamGia> getAll();
    
    boolean add(DotGiamGia dotGiamGia);
    
    boolean update(DotGiamGia dotGiamGia);
    
    boolean delete(Integer id);
    
    List<DotGiamGia> timTen(String ten);
    
    List<DotGiamGia> timMa(String ma);
    
    List<DotGiamGia> timGiam(int ptGiam);
}
