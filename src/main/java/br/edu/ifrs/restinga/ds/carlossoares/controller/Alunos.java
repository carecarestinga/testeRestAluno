package br.edu.ifrs.restinga.ds.carlossoares.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifrs.restinga.ds.carlossoares.dao.AlunosRepository;
import br.edu.ifrs.restinga.ds.carlossoares.model.Aluno;
import br.edu.ifrs.restinga.ds.carlossoares.model.TipoDisciplinas;

@Controller
@RequestMapping("/alunos")
public class Alunos {
	
	@Autowired
	private AlunosRepository alunos;

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
		
			return mv.addObject("PesquisaAlunos");
		}
		
		alunos.save(aluno);
		
		mv.addObject("mensagem", "Aluno salvo com sucesso!");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Aluno> todosAlunos = (List<Aluno>) alunos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaAlunos");
		mv.addObject("alunos", todosAlunos);
		return mv;
	}
	
	@ModelAttribute("todasDisciplinasAlunos")
	public List<TipoDisciplinas> todasDisciplinasAlunos() {
		return Arrays.asList(TipoDisciplinas.values());
	}
	
}
