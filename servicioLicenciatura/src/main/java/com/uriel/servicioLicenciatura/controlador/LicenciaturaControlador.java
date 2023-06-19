package com.uriel.servicioLicenciatura.controlador;

import com.uriel.servicioLicenciatura.interfaz.ILicenciatura;
import com.uriel.servicioLicenciatura.modelo.Licenciatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/licenciatura")
public class LicenciaturaControlador {
    private final ILicenciatura iLicenciatura;

    public LicenciaturaControlador(@Autowired ILicenciatura iLicenciatura) {
        this.iLicenciatura = iLicenciatura;
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        return iLicenciatura.listar();
    }

    @PostMapping(value = "/add")
    public String add(@RequestBody Licenciatura licenciatura) {
        Integer id = iLicenciatura.add(licenciatura);
        if (id == 0) {
            return "No se insertó";
        } else {
            return "Se insertó correctamente";
        }
    }

    @PostMapping(value = "/edit")
    public String edit(@RequestBody Licenciatura licenciatura) {
        System.out.println(licenciatura.toString());
        Integer id = iLicenciatura.edit(licenciatura);
        if (id == 0) {
            return "No se actualizó correctamente";
        } else {
            return "Se actualizó correctamente";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Integer fila = iLicenciatura.delete(id);
        if (fila == 0) {
            return "El registro no pudo ser eliminado";
        } else {
            return "Elemento eliminado correctamente";
        }
    }

    @GetMapping("/seach")
    public List<Map<String, Object>> buscarLicenciatura(
            @RequestParam(required = false) String nombrelic,
            @RequestParam(required = false) String campus,
            @RequestParam(required = false) String ubicacion) {
        return iLicenciatura.buscar(nombrelic, campus, ubicacion);
    }

}
