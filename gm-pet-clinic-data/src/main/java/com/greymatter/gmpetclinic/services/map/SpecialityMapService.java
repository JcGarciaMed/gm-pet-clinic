package com.greymatter.gmpetclinic.services.map;

import com.greymatter.gmpetclinic.model.Specialty;
import com.greymatter.gmpetclinic.services.SpecialtiesService;

import java.util.Set;

public class SpecialityMapService extends AbstractMapService<Specialty,Long> implements SpecialtiesService {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty object) {
        return super.save(object);
    }

    @Override
    public void delete(Specialty object) {
        super.delete(object);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }
}
