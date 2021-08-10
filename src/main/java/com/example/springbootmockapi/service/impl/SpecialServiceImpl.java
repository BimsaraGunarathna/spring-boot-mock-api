package com.example.springbootmockapi.service.impl;
import com.example.springbootmockapi.dto.special.CreateSpecialDTO;
import com.example.springbootmockapi.dto.special.SpecialDTO;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.mapper.SpecialMapper;
import com.example.springbootmockapi.repository.SpecialRepository;
import com.example.springbootmockapi.service.ComedianService;
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


    @Autowired
    private SpecialRepository repository;


    @Autowired
    private ComedianService comedianService;


    /***
     * to search and return single Special from Repository.
     * @param id - id of the Special to be retrieved.
     * @return special
     */
    @Override
    public SpecialDTO getASpecial(String id) {
        Optional<Special> pickedSpecial =  repository.findById(id);
        if(pickedSpecial.isPresent()) {
            return specialMapper.specialToSpecialDTO(pickedSpecial.get());
        }
        return null;
    }

    /***
     * to create a new comedian
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
     * To update a comedian
     * @param id - id of the Comedian to be updated.
     * @param newCreateSpecialDTO
     * @return special
     */
    //(03) to change a comedian
    @Override
    public SpecialDTO updateSpecial(String id, CreateSpecialDTO newCreateSpecialDTO) {
        SpecialDTO newSpecialDTO = specialMapper.createSpecialDTOToSpecialDTO(newCreateSpecialDTO);
        Optional<Special> newSpecial = repository.findById(id)
                .map(singleSpecial -> {
                    singleSpecial.setName(newSpecialDTO.getName());
                    singleSpecial.setDescription(newSpecialDTO.getDescription());
                    return repository.save(singleSpecial);
                });
        if(newSpecial.isPresent()) {
            return newSpecialDTO;
        }
        return null;

    }

    /***
     * to delete comedian
     * @param id - id of the Comedian to be deleted.
     * @return deletedOrNot
     */
    @Override
    public boolean deleteSpecial(String id) {
        //handle the event comedian doesn't exits
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    /***
     * to get all the comedians
     * @return specials
     */
    @Override
    public Collection<SpecialDTO> getSpecials() {
        Collection<Special> specials = repository.findAll();
        return specialMapper.specialsToSpecialDTOs(specials);
    }
}
