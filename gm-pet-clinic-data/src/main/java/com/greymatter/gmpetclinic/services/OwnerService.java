package com.greymatter.gmpetclinic.services;

import com.greymatter.gmpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends  CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
