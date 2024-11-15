package br.com.check.app.service;

import org.springframework.stereotype.Service;

@Service
public interface UnitService {


  void createUnit(String name, String region);
}
