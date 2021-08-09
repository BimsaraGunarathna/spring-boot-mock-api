package com.example.springbootmockapi.service.impl;

import com.example.springbootmockapi.dto.special.CreateSpecialDTO;
import com.example.springbootmockapi.dto.special.SpecialDTO;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.mapper.SpecialMapper;
import com.example.springbootmockapi.repository.SpecialRepository;
import com.example.springbootmockapi.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/***
 * To store specials to JPA
 * @author Bimsara Gunarathna
 * @since 7/23/2021
 */
@Service
public class SpecialServiceImpl implements SpecialService {

    @Autowired
    private SpecialMapper specialMapper;

    //private ComedianMapper comedianMapper = Mappers.getMapper(ComedianMapper.class);

    @Autowired
    private SpecialRepository repository;


    /***
     * (01) To search and return single Special from Repository.
     * @param id - id of the Special to be retrieved.
     * @return special
     */
    @Override
    public SpecialDTO getASpecial(String id) {
        if(repository.existsById(id)) {
            Optional<Special> optionalSpecial =  repository.findById(id);
            System.out.println(optionalSpecial.get().getDescription());
            return specialMapper.specialToSpecialDTO(optionalSpecial.get());
        }
        return null;
    }

    /***
     * (02) to create a new comedian
     * @param createSpecialDTO - A CreateSpecialDTO object
     * @return newSpecial
     */
    @Override
    public SpecialDTO createSpecial(CreateSpecialDTO createSpecialDTO) {
        SpecialDTO specialDTO = specialMapper.createSpecialDTOToSpecialDTO(createSpecialDTO);
        Special newSpecial = specialMapper.specialDTOToSpecial(specialDTO);
        repository.save(newSpecial);
        return specialDTO;
    }

    /***
     * (03) To update a comedian
     * @param id - id of the Comedian to be updated.
     * @param newCreateSpecialDTO
     * @return special
     */
    //(03) to change a comedian
    @Override
    public SpecialDTO updateSpecial(String id, CreateSpecialDTO newCreateSpecialDTO) {
        SpecialDTO newSpecialDTO = specialMapper.createSpecialDTOToSpecialDTO(newCreateSpecialDTO);
        if (repository.existsById(id)) {
            repository.findById(id)
                    .map(singleSpecial -> {
                        singleSpecial.setName(newSpecialDTO.getName());
                        singleSpecial.setDescription(newSpecialDTO.getDescription());
                        return repository.save(singleSpecial);
                    })
                    .orElseGet(() -> {
                        newSpecialDTO.setId(id);
                        Special newSpecial = specialMapper.specialDTOToSpecial(newSpecialDTO);
                        return repository.save(newSpecial);
                    });
            return newSpecialDTO;
        }
        return null;

    }

    /***
     * (04) to delete comedian
     * @param id - id of the Comedian to be deleted.
     * @return deletedOrNot
     */
    @Override
    public boolean deleteSpecial(String id) {
        //handle the event comedian doesn't exits
        if (repository.existsById(id)) {
            System.out.println(repository.findById(id));
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    /***
     * (05) to get all the comedians
     * @return specials
     */
    @Override
    public Collection<Special> getSpecials() {
        return repository.findAll();
    }
}
