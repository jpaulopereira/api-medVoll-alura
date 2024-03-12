package med.voll.api.domain.medico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


//Utilizada para testar uma inteface Repository
@DataJpaTest
//Utilizada o próprio banco, não um em memória
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//Carrega o properties de test
@ActiveProfiles("test")
class MedicoRepositoryTest {

    @Test
    @DisplayName("Deveria devolver null quando unico medico cadastrado nao esta disponivel na data")
    void escolherMedicoAleatorioCenarioUm() {
    }
}