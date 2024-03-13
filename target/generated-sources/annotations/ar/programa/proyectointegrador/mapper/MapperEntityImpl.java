package ar.programa.proyectointegrador.mapper;

import ar.programa.proyectointegrador.dto.ClienteDto;
import ar.programa.proyectointegrador.dto.DetalleIncidenciaDto;
import ar.programa.proyectointegrador.dto.EspecialidadDto;
import ar.programa.proyectointegrador.dto.IncidenciaDto;
import ar.programa.proyectointegrador.dto.ServicioDto;
import ar.programa.proyectointegrador.dto.TecnicoDto;
import ar.programa.proyectointegrador.dto.TipoProblemaDto;
import ar.programa.proyectointegrador.dto.TipoUsuarioDto;
import ar.programa.proyectointegrador.dto.UsuarioDto;
import ar.programa.proyectointegrador.entity.Cliente;
import ar.programa.proyectointegrador.entity.DetalleIncidencia;
import ar.programa.proyectointegrador.entity.Especialidad;
import ar.programa.proyectointegrador.entity.Incidencia;
import ar.programa.proyectointegrador.entity.Servicio;
import ar.programa.proyectointegrador.entity.Tecnico;
import ar.programa.proyectointegrador.entity.TipoProblema;
import ar.programa.proyectointegrador.entity.TipoUsuario;
import ar.programa.proyectointegrador.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T21:11:16-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class MapperEntityImpl implements MapperEntity {

    @Override
    public ClienteDto toDto(Cliente bean) {
        if ( bean == null ) {
            return null;
        }

        ClienteDto.ClienteDtoBuilder clienteDto = ClienteDto.builder();

        clienteDto.id( bean.getId() );
        clienteDto.razonSocial( bean.getRazonSocial() );
        clienteDto.cuit( bean.getCuit() );
        clienteDto.mail( bean.getMail() );

        return clienteDto.build();
    }

    @Override
    public Cliente toBean(ClienteDto dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente.ClienteBuilder cliente = Cliente.builder();

        cliente.id( dto.getId() );
        cliente.razonSocial( dto.getRazonSocial() );
        cliente.cuit( dto.getCuit() );
        cliente.mail( dto.getMail() );

        return cliente.build();
    }

    @Override
    public List<ClienteDto> toDtoListCliente(List<Cliente> beanList) {
        if ( beanList == null ) {
            return null;
        }

        List<ClienteDto> list = new ArrayList<ClienteDto>( beanList.size() );
        for ( Cliente cliente : beanList ) {
            list.add( toDto( cliente ) );
        }

        return list;
    }

    @Override
    public List<Cliente> toEntityListCliente(List<ClienteDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Cliente> list = new ArrayList<Cliente>( dtoList.size() );
        for ( ClienteDto clienteDto : dtoList ) {
            list.add( toBean( clienteDto ) );
        }

        return list;
    }

    @Override
    public DetalleIncidenciaDto toDto(DetalleIncidencia bean) {
        if ( bean == null ) {
            return null;
        }

        DetalleIncidenciaDto.DetalleIncidenciaDtoBuilder detalleIncidenciaDto = DetalleIncidenciaDto.builder();

        detalleIncidenciaDto.id( bean.getId() );
        detalleIncidenciaDto.detalleProblema( bean.getDetalleProblema() );
        detalleIncidenciaDto.descripcionProblema( bean.getDescripcionProblema() );
        detalleIncidenciaDto.resuelto( bean.getResuelto() );

        return detalleIncidenciaDto.build();
    }

    @Override
    public DetalleIncidencia toBean(DetalleIncidenciaDto dto) {
        if ( dto == null ) {
            return null;
        }

        DetalleIncidencia.DetalleIncidenciaBuilder detalleIncidencia = DetalleIncidencia.builder();

        detalleIncidencia.id( dto.getId() );
        detalleIncidencia.detalleProblema( dto.getDetalleProblema() );
        detalleIncidencia.descripcionProblema( dto.getDescripcionProblema() );
        detalleIncidencia.resuelto( dto.getResuelto() );

        return detalleIncidencia.build();
    }

    @Override
    public List<DetalleIncidenciaDto> toDtoListDetalleIncidencia(List<DetalleIncidencia> beanList) {
        if ( beanList == null ) {
            return null;
        }

        List<DetalleIncidenciaDto> list = new ArrayList<DetalleIncidenciaDto>( beanList.size() );
        for ( DetalleIncidencia detalleIncidencia : beanList ) {
            list.add( toDto( detalleIncidencia ) );
        }

        return list;
    }

    @Override
    public List<DetalleIncidencia> toEntityListDetalleIncidencia(List<DetalleIncidenciaDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DetalleIncidencia> list = new ArrayList<DetalleIncidencia>( dtoList.size() );
        for ( DetalleIncidenciaDto detalleIncidenciaDto : dtoList ) {
            list.add( toBean( detalleIncidenciaDto ) );
        }

        return list;
    }

    @Override
    public EspecialidadDto toDto(Especialidad bean) {
        if ( bean == null ) {
            return null;
        }

        EspecialidadDto.EspecialidadDtoBuilder especialidadDto = EspecialidadDto.builder();

        especialidadDto.id( bean.getId() );
        especialidadDto.nombre( bean.getNombre() );

        return especialidadDto.build();
    }

    @Override
    public Especialidad toBean(EspecialidadDto dto) {
        if ( dto == null ) {
            return null;
        }

        Especialidad especialidad = new Especialidad();

        especialidad.setId( dto.getId() );
        especialidad.setNombre( dto.getNombre() );

        return especialidad;
    }

    @Override
    public List<EspecialidadDto> toDtoListEspecialidad(List<Especialidad> beanList) {
        if ( beanList == null ) {
            return null;
        }

        List<EspecialidadDto> list = new ArrayList<EspecialidadDto>( beanList.size() );
        for ( Especialidad especialidad : beanList ) {
            list.add( toDto( especialidad ) );
        }

        return list;
    }

    @Override
    public List<Especialidad> toEntityListEspecialidad(List<EspecialidadDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Especialidad> list = new ArrayList<Especialidad>( dtoList.size() );
        for ( EspecialidadDto especialidadDto : dtoList ) {
            list.add( toBean( especialidadDto ) );
        }

        return list;
    }

    @Override
    public IncidenciaDto toDto(Incidencia bean) {
        if ( bean == null ) {
            return null;
        }

        IncidenciaDto.IncidenciaDtoBuilder incidenciaDto = IncidenciaDto.builder();

        incidenciaDto.id( bean.getId() );
        incidenciaDto.alias( bean.getAlias() );
        incidenciaDto.descripcion( bean.getDescripcion() );
        incidenciaDto.fechaEstimada( bean.getFechaEstimada() );
        incidenciaDto.resuelto( bean.getResuelto() );

        return incidenciaDto.build();
    }

    @Override
    public Incidencia toBean(IncidenciaDto dto) {
        if ( dto == null ) {
            return null;
        }

        Incidencia incidencia = new Incidencia();

        incidencia.setId( dto.getId() );
        incidencia.setAlias( dto.getAlias() );
        incidencia.setDescripcion( dto.getDescripcion() );
        incidencia.setFechaEstimada( dto.getFechaEstimada() );
        incidencia.setResuelto( dto.getResuelto() );

        return incidencia;
    }

    @Override
    public List<IncidenciaDto> toDtoListIncidencia(List<Incidencia> beanList) {
        if ( beanList == null ) {
            return null;
        }

        List<IncidenciaDto> list = new ArrayList<IncidenciaDto>( beanList.size() );
        for ( Incidencia incidencia : beanList ) {
            list.add( toDto( incidencia ) );
        }

        return list;
    }

    @Override
    public List<Incidencia> toEntityListIncidencia(List<IncidenciaDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Incidencia> list = new ArrayList<Incidencia>( dtoList.size() );
        for ( IncidenciaDto incidenciaDto : dtoList ) {
            list.add( toBean( incidenciaDto ) );
        }

        return list;
    }

    @Override
    public ServicioDto toDto(Servicio bean) {
        if ( bean == null ) {
            return null;
        }

        ServicioDto.ServicioDtoBuilder servicioDto = ServicioDto.builder();

        servicioDto.id( bean.getId() );
        servicioDto.nombre( bean.getNombre() );

        return servicioDto.build();
    }

    @Override
    public Servicio toBean(ServicioDto dto) {
        if ( dto == null ) {
            return null;
        }

        Servicio servicio = new Servicio();

        servicio.setId( dto.getId() );
        servicio.setNombre( dto.getNombre() );

        return servicio;
    }

    @Override
    public List<ServicioDto> toDtoListServicio(List<Servicio> beanList) {
        if ( beanList == null ) {
            return null;
        }

        List<ServicioDto> list = new ArrayList<ServicioDto>( beanList.size() );
        for ( Servicio servicio : beanList ) {
            list.add( toDto( servicio ) );
        }

        return list;
    }

    @Override
    public List<Servicio> toEntityListServicio(List<ServicioDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Servicio> list = new ArrayList<Servicio>( dtoList.size() );
        for ( ServicioDto servicioDto : dtoList ) {
            list.add( toBean( servicioDto ) );
        }

        return list;
    }

    @Override
    public TecnicoDto toDto(Tecnico bean) {
        if ( bean == null ) {
            return null;
        }

        TecnicoDto.TecnicoDtoBuilder tecnicoDto = TecnicoDto.builder();

        tecnicoDto.id( bean.getId() );
        tecnicoDto.nombre( bean.getNombre() );
        tecnicoDto.mail( bean.getMail() );
        tecnicoDto.nroTel( bean.getNroTel() );

        return tecnicoDto.build();
    }

    @Override
    public Tecnico toBean(TecnicoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Tecnico tecnico = new Tecnico();

        tecnico.setId( dto.getId() );
        tecnico.setNombre( dto.getNombre() );
        tecnico.setMail( dto.getMail() );
        tecnico.setNroTel( dto.getNroTel() );

        return tecnico;
    }

    @Override
    public List<TecnicoDto> toDtoListTecnico(List<Tecnico> beanList) {
        if ( beanList == null ) {
            return null;
        }

        List<TecnicoDto> list = new ArrayList<TecnicoDto>( beanList.size() );
        for ( Tecnico tecnico : beanList ) {
            list.add( toDto( tecnico ) );
        }

        return list;
    }

    @Override
    public List<Tecnico> toEntityListTecnico(List<TecnicoDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Tecnico> list = new ArrayList<Tecnico>( dtoList.size() );
        for ( TecnicoDto tecnicoDto : dtoList ) {
            list.add( toBean( tecnicoDto ) );
        }

        return list;
    }

    @Override
    public TipoProblemaDto toDto(TipoProblema bean) {
        if ( bean == null ) {
            return null;
        }

        TipoProblemaDto.TipoProblemaDtoBuilder tipoProblemaDto = TipoProblemaDto.builder();

        tipoProblemaDto.id( bean.getId() );
        tipoProblemaDto.tipo( bean.getTipo() );
        tipoProblemaDto.tiempoEnDias( bean.getTiempoEnDias() );

        return tipoProblemaDto.build();
    }

    @Override
    public TipoProblema toBean(TipoProblemaDto dto) {
        if ( dto == null ) {
            return null;
        }

        TipoProblema.TipoProblemaBuilder tipoProblema = TipoProblema.builder();

        tipoProblema.id( dto.getId() );
        tipoProblema.tipo( dto.getTipo() );
        tipoProblema.tiempoEnDias( dto.getTiempoEnDias() );

        return tipoProblema.build();
    }

    @Override
    public List<TipoProblemaDto> toDtoListTipoProblema(List<TipoProblema> beanList) {
        if ( beanList == null ) {
            return null;
        }

        List<TipoProblemaDto> list = new ArrayList<TipoProblemaDto>( beanList.size() );
        for ( TipoProblema tipoProblema : beanList ) {
            list.add( toDto( tipoProblema ) );
        }

        return list;
    }

    @Override
    public List<TipoProblema> toEntityListTipoProblema(List<TipoProblemaDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipoProblema> list = new ArrayList<TipoProblema>( dtoList.size() );
        for ( TipoProblemaDto tipoProblemaDto : dtoList ) {
            list.add( toBean( tipoProblemaDto ) );
        }

        return list;
    }

    @Override
    public UsuarioDto toDto(Usuario bean) {
        if ( bean == null ) {
            return null;
        }

        UsuarioDto.UsuarioDtoBuilder usuarioDto = UsuarioDto.builder();

        usuarioDto.id( bean.getId() );
        usuarioDto.nombreUsuario( bean.getNombreUsuario() );
        usuarioDto.pass( bean.getPass() );

        return usuarioDto.build();
    }

    @Override
    public Usuario toBean(UsuarioDto dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.id( dto.getId() );
        usuario.nombreUsuario( dto.getNombreUsuario() );
        usuario.pass( dto.getPass() );

        return usuario.build();
    }

    @Override
    public List<UsuarioDto> toDtoListUsuario(List<Usuario> beanList) {
        if ( beanList == null ) {
            return null;
        }

        List<UsuarioDto> list = new ArrayList<UsuarioDto>( beanList.size() );
        for ( Usuario usuario : beanList ) {
            list.add( toDto( usuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> toEntityListUsuario(List<UsuarioDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( dtoList.size() );
        for ( UsuarioDto usuarioDto : dtoList ) {
            list.add( toBean( usuarioDto ) );
        }

        return list;
    }

    @Override
    public TipoUsuarioDto toDto(TipoUsuario bean) {
        if ( bean == null ) {
            return null;
        }

        TipoUsuarioDto.TipoUsuarioDtoBuilder tipoUsuarioDto = TipoUsuarioDto.builder();

        tipoUsuarioDto.id( bean.getId() );
        tipoUsuarioDto.tipo( bean.getTipo() );

        return tipoUsuarioDto.build();
    }

    @Override
    public TipoUsuario toBean(TipoUsuarioDto dto) {
        if ( dto == null ) {
            return null;
        }

        TipoUsuario.TipoUsuarioBuilder tipoUsuario = TipoUsuario.builder();

        tipoUsuario.id( dto.getId() );
        tipoUsuario.tipo( dto.getTipo() );

        return tipoUsuario.build();
    }

    @Override
    public List<TipoUsuarioDto> toDtoListTipoUsuario(List<TipoUsuario> beanList) {
        if ( beanList == null ) {
            return null;
        }

        List<TipoUsuarioDto> list = new ArrayList<TipoUsuarioDto>( beanList.size() );
        for ( TipoUsuario tipoUsuario : beanList ) {
            list.add( toDto( tipoUsuario ) );
        }

        return list;
    }

    @Override
    public List<Usuario> toEntityListTipoUsuario(List<TipoUsuario> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( dtoList.size() );
        for ( TipoUsuario tipoUsuario : dtoList ) {
            list.add( tipoUsuarioToUsuario( tipoUsuario ) );
        }

        return list;
    }

    protected Usuario tipoUsuarioToUsuario(TipoUsuario tipoUsuario) {
        if ( tipoUsuario == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.id( tipoUsuario.getId() );

        return usuario.build();
    }
}
