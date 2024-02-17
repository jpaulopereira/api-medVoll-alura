package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Passa a entidade e o ID-> Chave primária
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    //findAllby"Nome do atributo" "true" -> faz um select automatico
    //A nomenclatura findAllByAtivoTrue segue a convenção de nomenclatura de consultas automáticas no Spring Data JPA
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
