package com.greymatter.gmpetclinic.services.map;

import com.greymatter.gmpetclinic.model.Visit;
import com.greymatter.gmpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet()==null || visit.getPet().getOwner()==null || visit.getPet().getId()==null
            || visit.getPet().getOwner().getId()==null){
            System.out.println(visit.getPet());
            System.out.println(visit.getPet().getOwner());
            System.out.println(visit.getPet().getId());
            System.out.println(visit.getPet().getOwner().getId());
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
