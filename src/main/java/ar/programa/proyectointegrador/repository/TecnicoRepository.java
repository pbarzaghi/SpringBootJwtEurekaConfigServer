package ar.programa.proyectointegrador.repository;

import ar.programa.proyectointegrador.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 @author pabloBarzaghi
 */
@Repository
@Transactional
@EnableJpaRepositories
public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {

   /*
      QRY  Quien fue el tecnico con mas incidentes resueltos  en los ultimos N dias
    */

  @Query(" SELECT t FROM Tecnico as t" +
            " INNER JOIN  Incidencia as i ON " +
            " t = i.tecnico  " +
            " AND  i.resuelto = TRUE " +
             " AND i.fechaEstimada  BETWEEN :fechaInicio AND :fechaFin " +
            " GROUP BY  i.tecnico ORDER BY COUNT(i.tecnico) DESC ")
  public List<Tecnico> findAllTecnicosByIncidenciaResueltaEntreFechas(@Param("fechaInicio") LocalDateTime fechaInicio,
                                                                        @Param("fechaFin")LocalDateTime fechaFin);


     /*  QRY  Quien fue el tecnico con mas incidentes resueltos de una determinada
              especialidad en los ultimos N dias

     */


    @Query(
            "SELECT t FROM Tecnico t " +
                    "INNER JOIN Incidencia i ON (t = i.tecnico AND i.resuelto = TRUE AND i.fechaEstimada BETWEEN :fechaInicio AND :fechaFin) " +
                    "INNER JOIN t.especialidades te ON (te.id = :idEsp) " +
                    "GROUP BY i.tecnico " +
                    "ORDER BY COUNT(i.tecnico) DESC"
    )
    public List<Tecnico> findAllTecnicosByIncidenciaResueltaEntreFechasEspecialidad(
            @Param("fechaInicio") LocalDateTime fechaInicio,
            @Param("fechaFin") LocalDateTime fechaFin,
            @Param("idEsp") Integer idEsp
    );



   @Query(  "SELECT " +
           "   t, MIN(tp.tiempoEnDias) as minTiempoEnDias " +
           " FROM " +
           "   Tecnico t " +
           " INNER JOIN Incidencia i ON t = i.tecnico " +
           " INNER JOIN TipoProblema tp ON i.tipoProblema = tp " +
           " WHERE " +
           "   i.resuelto = TRUE " +
           " GROUP BY " +
           "   t " +
           " ORDER BY " +
           "   minTiempoEnDias ASC"
           )
    public List<Tecnico> findTecnicoMasRapidoResolvioLaIncidencia() ;
}
