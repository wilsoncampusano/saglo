package equipo.once.elizabeth.richard.wilson.mocks;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.MobiliarioInquilino;
import equipo.once.elizabeth.richard.wilson.services.MobiliarioService;

import java.util.ArrayList;
import java.util.List;

public class MobiliarioServiceHappyPathMock implements MobiliarioService{
  List<MobiliarioInquilino> mobiliarioInquilinos = mockDbData();

  @Override
  public MobiliarioInquilino buscarPorInquilino(Inquilino inquilino) {
    return mobiliarioInquilinos
        .stream()
        .filter(mi -> mi.inquilino.equals(inquilino))
        .findFirst().get();
  }



  public static List<MobiliarioInquilino> mockDbData(){
    MobiliarioInquilino mobiliarioInquilino1 = new MobiliarioInquilino();
    MobiliarioInquilino mobiliarioInquilino2 = new MobiliarioInquilino();
    MobiliarioInquilino mobiliarioInquilino3 = new MobiliarioInquilino();

    Inquilino elizabeth = new Inquilino();
    Inquilino richard = new Inquilino();
    Inquilino wilson = new Inquilino();


    mobiliarioInquilino1.inquilino = elizabeth;
    mobiliarioInquilino2.inquilino = richard;
    mobiliarioInquilino3.inquilino = wilson;

    List<MobiliarioInquilino> mobiliarioInquilinos = new ArrayList<>();
    return mobiliarioInquilinos;
  }
}
