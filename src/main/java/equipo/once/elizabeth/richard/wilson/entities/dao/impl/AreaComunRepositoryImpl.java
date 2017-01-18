package equipo.once.elizabeth.richard.wilson.entities.dao.impl;

import equipo.once.elizabeth.richard.wilson.entities.dao.AreaComunRepositoryCustom;
import equipo.once.elizabeth.richard.wilson.entities.dominio.AreaComun;

import java.util.List;

public class AreaComunRepositoryImpl implements AreaComunRepositoryCustom{

  @Override
  public List<AreaComun> findByNombreIgnoreCaseContaining(String palabra) {
    return this.findByNombreIgnoreCaseContaining(palabra);
  }

  @Override
  public <S extends AreaComun> S save(S entity) {
    return this.save(entity);
  }

  @Override
  public <S extends AreaComun> Iterable<S> save(Iterable<S> entities) {
    return this.save(entities);
  }

  @Override
  public AreaComun findOne(Long aLong) {
    return this.findOne(aLong);
  }

  @Override
  public boolean exists(Long aLong) {
    return this.exists(aLong);
  }

  @Override
  public Iterable<AreaComun> findAll() {
    return this.findAll();
  }

  @Override
  public Iterable<AreaComun> findAll(Iterable<Long> longs) {
    return this.findAll(longs);
  }

  @Override
  public long count() {
    return this.count();
  }

  @Override
  public void delete(Long aLong) {
    this.delete(aLong);
  }

  @Override
  public void delete(AreaComun entity) {
    this.delete(entity);
  }

  @Override
  public void delete(Iterable<? extends AreaComun> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
