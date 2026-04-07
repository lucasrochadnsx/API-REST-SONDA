package br.com.sonda_teste.aeronaveV2.infra.persistence;

import br.com.sonda_teste.aeronaveV2.infra.entity.AeronaveEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface AeronaveDataRepository extends JpaRepository<AeronaveEntity, Long> {

    @Query("""
               select a from AeronaveEntity a
               where
                 (
                   :termo is not null and
                   (
                     lower(a.nome) like lower(concat('%', :termo, '%'))
                     or lower(a.descricao) like lower(concat('%', :termo, '%'))
                     or cast(a.fabricante as string) like concat('%', :termo, '%')
                     or cast(a.anoFabricacao as string) = :termo
                     or cast(a.id as string) = :termo
                   )
                 )
            """)
    List<AeronaveEntity> findByTermo(@Param("termo") String termo);

    List<AeronaveEntity> findByVendidoFalse();

    List<AeronaveEntity> findAllByOrderByAnoFabricacaoAsc();

    List<AeronaveEntity> findAllByOrderByFabricanteAsc();

    @Query("""
                select a from AeronaveEntity a where a.createdAt >= :data
                order by a.createdAt desc
            """)
    List<AeronaveEntity> findRecent(@Param("data") OffsetDateTime data);

    @Query("""
            select a.fabricante as fabricante, count(a) as total
            from AeronaveEntity a
            group by a.fabricante
            order by a.fabricante
            """)
    List<FabricanteCountProjection> countByFabricante();

    @Query("""
            select (a.anoFabricacao/10)*10 as decade, count(a) as total
            from AeronaveEntity a
            group by (a.anoFabricacao/10)*10
            order by (a.anoFabricacao/10)*10
            """)
    List<DecadaCountProjection> countByDecade();

    @Query("""
        select a.id as id,
               a.nome as nome,
               a.fabricante as fabricante,
               a.anoFabricacao as anoFabricacao,
               a.descricao as descricao,
               a.vendido as vendido,
               a.createdAt as createdAt,
               a.updatedAt as updatedAt
          from AeronaveEntity a
         where lower(a.nome) like lower(concat('%', :termo, '%'))
            or lower(a.descricao) like lower(concat('%', :termo, '%'))
        """)
    Page<AeronaveListItemProjection> searchPaged(@Param("termo") String termo, Pageable pageable);
}
