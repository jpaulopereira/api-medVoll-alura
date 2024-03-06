package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

//Passa a entidade e o ID-> Chave primária
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    //findAllby"Nome do atributo" "true" -> faz um select automatico
    //A nomenclatura findAllByAtivoTrue segue a convenção de nomenclatura de consultas automáticas no Spring Data JPA
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    //:especialidade -> é o atributo do parâmetro //Digitar em cima do método
    //m.id not in -> traz is médicos que o id não estão dentro do sub select
    @Query("""
            select m from Medicos m
                   where
                   m.ativo = true
                   and
                   m.especialidade = :especialidade
                   and
                   m.id not in(
                       select c.medico.id from Consulta c
                       where
                       c.data = :data
                   )
                   order by rand()
                   limit 1
                """)
    Medico escolherMedicoAleatorio(Especialidade especialidade, LocalDateTime data);

    //WHERE m.id = ?1
    @Query("""
            SELECT
            m.ativo
            FROM Medicos m
            WHERE m.id = :idMedico
            """)
    Boolean findAtivoById(Long idMedico);
}
