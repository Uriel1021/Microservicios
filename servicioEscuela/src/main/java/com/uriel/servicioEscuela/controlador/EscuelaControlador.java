package com.uriel.servicioEscuela.controlador;

import com.uriel.servicioEscuela.interfaz.IEscuela;
import com.uriel.servicioEscuela.modelo.Escuela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/escuela")
public class EscuelaControlador {
    private final IEscuela iescuela;

    public EscuelaControlador(@Autowired IEscuela iescuela) {
        this.iescuela = iescuela;
    }


    @GetMapping("/list")
    public List<Map<String, Object>> list(){
        return iescuela.listar();
    }

    @PostMapping(value = "/add")
    public String add(@RequestBody Escuela escuela){
        Integer id = iescuela.add(escuela);
        if (id == 0){
            return "No se inserto";
        }else{
            return "Se inserto correctamente";
        }
    }
    @PostMapping(value = "/edit")
    public String edit(@RequestBody Escuela escuela){
            Integer idEscuela = iescuela.edit(escuela);
            if (idEscuela == 0){
                return "No se inserto correctamente";
            }else{
                return "Se inserto correctamente";
            }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Integer fila = iescuela.delete(id);
        if (fila == 0) {
            return "EL REGISTRO NO PUDO SER ELIMINADO";
        } else {
            return "ELEMENTO ELIMINADO CORRECTAMENTE";
        }
    }

    @GetMapping("/seach/{nombre}")
    public List<Map<String, Object>> GetByName(@PathVariable String nombre){
        return iescuela.buscar(nombre);
    }
}
