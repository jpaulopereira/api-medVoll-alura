package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

//Especialidade é um enum
public record DadosCadastroMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
