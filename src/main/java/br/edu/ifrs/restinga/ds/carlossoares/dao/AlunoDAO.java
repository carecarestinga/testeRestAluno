
package br.edu.ifrs.restinga.ds.carlossoares.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifrs.restinga.ds.carlossoares.model.Aluno;

/**
 *
 * @author carlos
 */
@Repository
public interface AlunoDAO extends CrudRepository<Aluno, Integer>{
    
}
