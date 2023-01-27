/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nadya.penjualan.service.service;
import com.nadya.penjualan.service.VO.Pelanggan;
import com.nadya.penjualan.service.VO.ResponseTemplateVO;
import com.nadya.penjualan.service.entity.Penjualan;
import com.nadya.penjualan.service.repository.PenjualanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author win 11
 */
@Service
public class PenjualanService {
    @Autowired
    private PenjualanRepository penjualanRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Penjualan savePenjualan(Penjualan penjualan) {
        return penjualanRepository.save(penjualan);
    }

    public ResponseTemplateVO getPenjualan(Long penjualanId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Long penjualanKodeBarang = null;
        Penjualan penjualan = penjualanRepository.findByPenjualanId(penjualanId);
//        Pelanggan pelanggan = restTemplate.getForObject("http://localhost:9007/pelangggan/" 
//              + penjualan.getPelangganId(), Pelanggan.class);
//        vo.setPelanggan(pelanggan);
        Pelanggan pelanggan = restTemplate.getForObject("http://localhost:9007/pelanggan/"
                + penjualan.getPelangganId(), Pelanggan.class);
        vo.setPenjualan(penjualan);
        vo.setPelanggan(pelanggan);
        return vo;
    }
}