
package br.edu.ifrs.restinga.ds.carlossoares.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrs.restinga.ds.carlossoares.dao.AlunoDAO;
import br.edu.ifrs.restinga.ds.carlossoares.enuns.TipoDisciplinas;
import br.edu.ifrs.restinga.ds.carlossoares.exception.NaoEncontrado;
import br.edu.ifrs.restinga.ds.carlossoares.exception.RequisicaoInvalida;
import br.edu.ifrs.restinga.ds.carlossoares.model.Aluno;

/**
 *
 * @author carlos
 */

@Controller
@RequestMapping("/alunos")
public class Alunos {

	@Autowired
	AlunoDAO alunoDAO;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroAluno");
		mv.addObject(new Aluno());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Aluno aluno, Errors errors) {
		ModelAndView mv = new ModelAndView("CadastroAluno");
		if (errors.hasErrors()) {

			return mv;
		}

		alunoDAO.save(aluno);

		mv.addObject("mensagem", "Aluno salvo com sucesso!");
		return mv;
	}

	@RequestMapping
	public ModelAndView pesquisar() {
		List<Aluno> todosAlunos = (List<Aluno>) alunoDAO.findAll();
		ModelAndView mv = new ModelAndView("PesquisaAlunos");
		mv.addObject("alunos", todosAlunos);
		return mv;
	}

	@ModelAttribute("todasDisciplinasAluno")
	public List<TipoDisciplinas> todasDisciplinasAluno() {
		return Arrays.asList(TipoDisciplinas.values());
	}

	
//	@RequestMapping(path = "/alunos/{id}", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	public ResponseEntity<Aluno> recuperar(@PathVariable int id) {
//
//		Optional<Aluno> findById = alunoDAO.findById(id);
//		if (findById.isPresent()) {
//			return ResponseEntity.ok(findById.get());
//		} else {
//			return ResponseEntity.notFound().build();
//
//		}
//	}

	// @RequestMapping(path = "/alunos/", method =RequestMethod.GET)
	// @ResponseStatus(HttpStatus.OK)
	// public Iterable<Aluno> listar() {
	// return alunoDAO.findAll();
	//
	// }

	// @RequestMapping(path="/alunos/",method = RequestMethod.POST)
	// @ResponseStatus(HttpStatus.CREATED)
	// public Aluno inserir(@RequestBody Aluno aluno) {
	// aluno.setId(0);
	//
	// if(aluno.getId()<=0) {
	// throw new RequisicaoInvalida("Nome do Aluno nao pode ser nulo");
	// }
	//
	//
	//
	// Aluno alunoComId = alunoDAO.save(aluno);
	// return alunoComId;
	// }

//	@RequestMapping(path = "/alunos/{id}", method = RequestMethod.PUT)
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void atualizar(@PathVariable int id, @RequestBody Aluno aluno) {
//		aluno.setId(id);
//		if (aluno.getId() <= 0) {
//			throw new RequisicaoInvalida("Nome do Aluno nao pode ser nulo");
//		}
//		alunoDAO.save(aluno);
//	}
//
//	@RequestMapping(path = "/alunos/{id}", method = RequestMethod.DELETE)
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void apagar(@PathVariable int id) {
//
//		if (!alunoDAO.existsById(id)) {
//			throw new NaoEncontrado("ID não encontrada");
//		}
//
//		alunoDAO.deleteById(id);
//
//	}

}
