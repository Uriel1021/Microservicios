package com.uriel.servicioPreRegistro.Controlador;

import com.uriel.servicioPreRegistro.Interfaces.IAspirante;
import com.uriel.servicioPreRegistro.Interfaces.ILicenciatura;
import com.uriel.servicioPreRegistro.Interfaces.ITutor;
import com.uriel.servicioPreRegistro.Modelo.Aspirante;
import com.uriel.servicioPreRegistro.Modelo.Escuela;
import com.uriel.servicioPreRegistro.Modelo.Licenciatura;
import com.uriel.servicioPreRegistro.Servicio.IEscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aspirante")
public class AspiranteControlador {
    //Servicio
    public final IAspirante iAspirante;
    public final ITutor iTutor;

    //Consumiendo el micro servicio escuela
    public final IEscuelaService iEscuelaService;
    public final ILicenciatura iLicenciatura;

    public AspiranteControlador(@Autowired IAspirante iAspirante, IEscuelaService iEscuelaService, ITutor iTutor, ILicenciatura iLicenciatura) {
        this.iAspirante = iAspirante;
        this.iEscuelaService = iEscuelaService;
        this.iTutor = iTutor;
        this.iLicenciatura = iLicenciatura;
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list(){
        return iAspirante.listar();
    }

    @PostMapping("/add")
    public String add(@RequestBody Aspirante aspirante){
        Escuela[] escuela = iEscuelaService.buscarEscuela(aspirante.getEscuela());
        List<Map<String, Object>> tutor = iTutor.existeTutor(aspirante.getTutor());
        //Licenciatura licenciaturas = iLicenciatura.obtenerLicenciaturaPorDetalle(aspirante.getLicenciatura());
        //System.out.println(licenciaturas);
        aspirante.setNumeroficha(iAspirante.generarNumeroAleatorio());
        if (escuela != null && escuela.length > 0 && !tutor.isEmpty()){
            Integer id = iAspirante.add(aspirante);
            if (id == 0){
                return "No se inserto";
            }else{
                return "Se inserto correctamente";
            }
        }else{
            return "No se inserto";
        }
    }

    @PostMapping("/edit")
    public String edit(@RequestBody Aspirante aspirante){
        Integer id = iAspirante.edit(aspirante);
        if (id == 0){
            return "No se inserto";
        }else{
            return "Se modifico correctamente";
        }
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Integer fila = iAspirante.delete(id);
        if(fila == 0){
            return "No se elimino correctamente";
        }else{
            return "Se elimno correctamente";
        }
    }
}
