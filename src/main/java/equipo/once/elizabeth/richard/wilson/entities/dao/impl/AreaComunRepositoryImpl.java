package equipo.once.elizabeth.richard.wilson.entities.dao.impl;

import equipo.once.elizabeth.richard.wilson.entities.dao.AreaComunRepositoryCustom;
import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AreaComunRepositoryImpl implements AreaComunRepositoryCustom{

  AreaComun piscina = AreaComun.crear("A-piscina-1","Piscina");
  AreaComun areaBBQ = AreaComun.crear("A-BBQ-1", "BBQ");
  List<AreaComun> areasComunes = Arrays.asList(piscina, areaBBQ);


  @Override
  public List<AreaComun> findByNombreContaining(String palabra) {
    return this.findByNombreContaining(palabra);
  }

  @Override
  public <S extends AreaComun> S save(S entity) {
    return this.save(entity);
  }

  @Override
  public <S extends AreaComun> Iterable<S> save(Iterable<S> entities) {
    return null;
  }

  @Override
  public AreaComun findOne(Long aLong) {
    return null;
  }

  @Override
  public boolean exists(Long aLong) {
    return false;
  }

  @Override
  public Iterable<AreaComun> findAll() {
    return null;
  }

  @Override
  public Iterable<AreaComun> findAll(Iterable<Long> longs) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void delete(Long aLong) {

  }

  @Override
  public void delete(AreaComun entity) {

  }

  @Override
  public void delete(Iterable<? extends AreaComun> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
