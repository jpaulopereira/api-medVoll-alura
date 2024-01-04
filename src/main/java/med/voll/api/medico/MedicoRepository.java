package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Passa a entidade e o ID-> Chave primária
public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
