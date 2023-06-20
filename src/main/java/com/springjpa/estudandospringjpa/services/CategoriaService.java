package com.springjpa.estudandospringjpa.services;


import com.springjpa.estudandospringjpa.domain.Categoria;
import com.springjpa.estudandospringjpa.dto.CategoriaDTO;
import com.springjpa.estudandospringjpa.exceptions.ObjectNotFoundException;
import com.springjpa.estudandospringjpa.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    @Autowired
    private EmailService emailService;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    @Transactional(readOnly = true)
    public Categoria insert(Categoria obj) {
        obj.setId(null);
        obj = repo.save(obj);
        emailService.sendOrderConfirmationEmail(obj);
        return obj;

    }

    public Categoria update(Categoria obj) {
      Categoria newObj =  find(obj.getId());
      updateData(newObj, obj);
      return repo.save(obj);
    }

    private void updateData(Categoria newObj, Categoria obj) {
        newObj.setNome(newObj.getNome());

    }

    public void delete(Integer id) {
            find(id);
        try {
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw  new DataIntegrityViolationException("Não é possivel excluir uma categoria que possui produtos");
        }

    }
    public List<Categoria> findAll() {
        return repo.findAll();
    }

    public Page<Categoria> findPage(Integer  page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Categoria fromDto(CategoriaDTO objDto){
        return new Categoria(objDto.getId(), objDto.getNome());
    }
}
