package equipo.once.elizabeth.richard.wilson.mocks;

import equipo.once.elizabeth.richard.wilson.entities.dominio.Inquilino;
import equipo.once.elizabeth.richard.wilson.entities.dominio.MobiliarioInquilino;
import equipo.once.elizabeth.richard.wilson.services.MobiliarioService;

import java.util.ArrayList;
import java.util.List;

public class MobiliarioServiceHappyPathMock implements MobiliarioService{
  static List<MobiliarioInquilino> mobiliarioInquilinos = new ArrayList<>();


  static  {
    mobiliarioInquilinos = mockDbData();
  }

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
    elizabeth.codigo = "I-elizabeth-1";
    Inquilino richard = new Inquilino();
    richard.codigo = "I-richard-1";
    Inquilino wilson = new Inquilino();
    wilson.codigo = "I-wilson-1";

    mobiliarioInquilino1.inquilino = elizabeth;
    mobiliarioInquilino2.inquilino = richard;
    mobiliarioInquilino3.inquilino = wilson;

    List<MobiliarioInquilino> mobiliarioInquilinos = new ArrayList<>();
    mobiliarioInquilinos.add(mobiliarioInquilino1);
    mobiliarioInquilinos.add(mobiliarioInquilino2);
    mobiliarioInquilinos.add(mobiliarioInquilino3);
    return mobiliarioInquilinos;
  }
}
