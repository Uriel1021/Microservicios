package com.uriel.servicioPreRegistro.Controlador;

import com.uriel.servicioPreRegistro.Interfaces.ITutor;
import com.uriel.servicioPreRegistro.Modelo.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tutor")
public class TutorControlador {
    private final ITutor iTutor;

    public TutorControlador(@Autowired ITutor iTutor) {
        this.iTutor = iTutor;
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        return iTutor.listar();
    }

    @PostMapping("/add")
    public String add(@RequestBody Tutor tutor) {
        Integer id = iTutor.add(tutor);
        if (id == 0) {
            return "No se pudo insertar el tutor";
        } else {
            return "Tutor insertado correctamente";
        }
    }

    @PostMapping("/edit")
    public String edit(@RequestBody Tutor tutor) {
        Integer id = iTutor.edit(tutor);
        if (id == 0) {
            return "No se pudo editar el tutor";
        } else {
            return "Tutor editado correctamente";
        }
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Integer rowsAffected = iTutor.delete(id);
        if (rowsAffected == 0) {
            return "No se encontró el tutor con el ID especificado para eliminar";
        } else {
            return "Tutor eliminado correctamente";
        }
    }
    @GetMapping("/search/{id}")
    public List<Map<String, Object>> searchTutor(@PathVariable Integer id) {
        return iTutor.existeTutor(id);

    }

}
