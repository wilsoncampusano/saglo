package equipo.once.elizabeth.richard.wilson.entities.dao.impl;

import equipo.once.elizabeth.richard.wilson.entities.dao.InquilinoRepositoryCustom;
import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;

public class InquilinoRepositoryImpl implements InquilinoRepositoryCustom{

  @Override
  public Inquilino findByCodigo(String codigo) {
    return this.findByCodigo(codigo);
  }

  @Override
  public <S extends Inquilino> S save(S entity) {
    return null;
  }

  @Override
  public <S extends Inquilino> Iterable<S> save(Iterable<S> entities) {
    return null;
  }

  @Override
  public Inquilino findOne(Long aLong) {
    return null;
  }

  @Override
  public boolean exists(Long aLong) {
    return false;
  }

  @Override
  public Iterable<Inquilino> findAll() {
    return null;
  }

  @Override
  public Iterable<Inquilino> findAll(Iterable<Long> longs) {
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
  public void delete(Inquilino entity) {

  }

  @Override
  public void delete(Iterable<? extends Inquilino> entities) {

  }

  @Override
  public void deleteAll() {

  }
}
