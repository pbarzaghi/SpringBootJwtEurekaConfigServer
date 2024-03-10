package ar.programa.proyectointegrador.mapper;

import ar.programa.proyectointegrador.dto.*;
import ar.programa.proyectointegrador.entity.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


import java.util.List;
//@Mapper(
//        componentModel = MappingConstants.ComponentModel.SPRING
//)
@Mapper(componentModel = "spring")
public interface MapperEntity{
    MapperEntity  mapper= Mappers.getMapper(MapperEntity.class);
//-------------------------------------
    // CLIENTE
    ClienteDto toDto(Cliente bean);
    Cliente toBean(ClienteDto dto);
    List<ClienteDto> toDtoListCliente(List<Cliente> beanList);
    List<Cliente> toEntityListCliente(List<ClienteDto> dtoList);
//-------------------------------------
    //DetalleIncidencia

    DetalleIncidenciaDto toDto(DetalleIncidencia bean);
    DetalleIncidencia toBean(DetalleIncidenciaDto dto);
    List<DetalleIncidenciaDto> toDtoListDetalleIncidencia(List<DetalleIncidencia> beanList);
    List<DetalleIncidencia> toEntityListDetalleIncidencia(List<DetalleIncidenciaDto> dtoList);
//-------------------------------------
    //Especialidad

    EspecialidadDto toDto(Especialidad bean);
    Especialidad toBean(EspecialidadDto dto);
    List<EspecialidadDto> toDtoListEspecialidad(List<Especialidad> beanList);
    List<Especialidad> toEntityListEspecialidad(List<EspecialidadDto> dtoList);
//-------------------------------------
    //Incidencia
    IncidenciaDto toDto(Incidencia bean);
    Incidencia toBean(IncidenciaDto dto);
    List<IncidenciaDto> toDtoListIncidencia(List<Incidencia> beanList);
    List<Incidencia> toEntityListIncidencia(List<IncidenciaDto> dtoList);
//-------------------------------------
    //Servicio
    ServicioDto toDto(Servicio bean);
    Servicio toBean(ServicioDto dto);
    List<ServicioDto> toDtoListServicio(List<Servicio> beanList);
    List<Servicio> toEntityListServicio(List<ServicioDto> dtoList);
//-------------------------------------
    //Tecnico
    TecnicoDto toDto(Tecnico bean);
    Tecnico toBean(TecnicoDto dto);
    List<TecnicoDto> toDtoListTecnico(List<Tecnico> beanList);
    List<Tecnico> toEntityListTecnico(List<TecnicoDto> dtoList);

//-------------------------------------
    //TipoProblema
   TipoProblemaDto toDto(TipoProblema bean);
    TipoProblema toBean(TipoProblemaDto dto);
    List<TipoProblemaDto> toDtoListTipoProblema(List<TipoProblema> beanList);
    List<TipoProblema> toEntityListTipoProblema(List<TipoProblemaDto> dtoList);

//-------------------------------------
   //Usuario
    UsuarioDto toDto(Usuario bean);
    Usuario toBean(UsuarioDto dto);
    List<UsuarioDto> toDtoListUsuario(List<Usuario> beanList);
    List<Usuario> toEntityListUsuario(List<UsuarioDto> dtoList);


//-------------------------------------
    //TipoUsuario
    TipoUsuarioDto toDto(TipoUsuario bean);

    TipoUsuario toBean(TipoUsuarioDto dto);
    List<TipoUsuarioDto> toDtoListTipoUsuario(List<TipoUsuario> beanList);
    List<Usuario> toEntityListTipoUsuario(List<TipoUsuario> dtoList);
}
