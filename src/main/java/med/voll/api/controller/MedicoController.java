package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping //não é necessário @Transactional porque aqui é apenas um método de leitura
    public Page<DadosListagemMedicos> listarNomes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        //findAll devolve um list de médico e necessario fazer a conversao
        //faz a conversão de médico para DadosListagemMedicos
        //new chama o construtor do dto DadosListagemMedicos
        //:: operador de referência
        //return repository.findAll(paginacao).stream().map(DadosListagemMedicos::new).toList();
        //padrao de nomenclatura  do springData que consegue montar a query
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@Valid @RequestBody DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    /*
    @DeleteMapping("/{id}")
    @Transactional
    //@PathVariable indica para o Spring que o parâmetro dinamigo que vem URL -> long id faz parte da url
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
     */

    @DeleteMapping("/{id}")
    @Transactional
    public void desativarMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
