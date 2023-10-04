package com.example.springsecuritytuto.sec.config;

import java.util.List;
import java.util.Set;


public interface EntityMapper<T , D > {

    public T dtoToEntity(D object);
    public D entityToDto(T object);
    public List<T> listDtoToEntity(List<D> list);
    public Set<T> listDtoToEntity(Set<D> list);
    public List<D> listEntityToDto(List<T> list);
    public Set<D> listEntityToDto(Set<T> list);

}
