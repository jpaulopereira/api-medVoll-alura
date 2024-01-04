package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

//Passa a entidade e o ID-> Chave primária
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
