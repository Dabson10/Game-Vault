package org.github.dabson10.gamevault.service;

import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorCompletoDTO;
import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorDTO;
import org.github.dabson10.gamevault.dto.DesarrolladorDTO.DesarrolladorSimpleDTO;
import org.github.dabson10.gamevault.entity.Desarrollador;
import org.github.dabson10.gamevault.exceptions.DeveloperNotFound;
import org.github.dabson10.gamevault.exceptions.DeveloperNameDuplicate;
import org.github.dabson10.gamevault.repository.DesarrolladorRepository;
import org.github.dabson10.gamevault.utility.desarrolladorFormat.DesarrolladorSimpleFormat;
import org.github.dabson10.gamevault.utility.desarrolladorFormat.FormatDesarrollador;
import org.github.dabson10.gamevault.utility.desarrolladorFormat.FormatDesarrolladorCompleto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesarrolladorService implements DesarrolladorServiceImp {
    //Inyección de dependencias.
    private final DesarrolladorRepository deRe;
    private final FormatDesarrollador formatDes;
    private final DesarrolladorSimpleFormat desFormSimp;
    private final FormatDesarrolladorCompleto  desFormComp;

    public DesarrolladorService(DesarrolladorRepository deRe, FormatDesarrollador formatDesarrollador,
                                DesarrolladorSimpleFormat desFormSimp, FormatDesarrolladorCompleto  desFormComp){
        this.deRe = deRe;
        this.formatDes = formatDesarrollador;
        this.desFormSimp = desFormSimp;
        this.desFormComp = desFormComp;
    }
    @Override
    public DesarrolladorSimpleDTO crearDesarrollador(DesarrolladorSimpleDTO desarrollador) {
        Desarrollador desa = existenciaDesarrollador(desarrollador.getNombre());
        //Si se encuentra un desarrollador entonces no proseguimos
        if(desa != null){
            throw new DeveloperNameDuplicate("Desarrollador existente.");
        }
        //Ahora que tenemos un objeto null toca formatear con los datos del DTO a
        //al objeto vacío
        desa = deRe.save(desFormSimp.formatDataSimple(desarrollador));
        System.out.println("El ID desde el service es: " + desa.getIdDesarrollador());
        //Tienes que revisar porque no se pasa el ID del desarrollador recién creado.
        return desFormSimp.formatDataSimpleDTO(desa);
    }

    @Override
    public DesarrolladorCompletoDTO traerDesarrollador(String nombre) {
        Desarrollador des = this.existenciaDesarrollador(nombre);
        if(des == null){
            throw new DeveloperNotFound("No se encontró el desarrollador.");
        }
        return desFormComp.formDataDesarrolladorCompletoDTO(des);
    }

    @Override
    public Desarrollador existenciaDesarrollador(String nombre) {
        return deRe.findByNombre(nombre);
    }

    /**
     * Función para listar a los desarrolladores.
     * @return
     */
    @Override
    public List<DesarrolladorDTO> listaDesarrollador() {
        return formatDes.formatLista(deRe.findAll());
    }
}
