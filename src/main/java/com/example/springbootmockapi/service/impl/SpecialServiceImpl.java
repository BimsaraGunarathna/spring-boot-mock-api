package com.example.springbootmockapi.service.impl;

import com.example.springbootmockapi.dto.comedian.ComedianDTO;
import com.example.springbootmockapi.dto.special.CreateSpecialDTO;
import com.example.springbootmockapi.dto.special.SpecialDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
import com.example.springbootmockapi.exception.ResourceNotFoundException;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.mapper.ComedianMapper;
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
    private ComedianMapper comedianMapper;
    //private ComedianMapper comedianMapper = Mappers.getMapper(ComedianMapper.class);

    @Autowired
    private SpecialRepository repository;

    @Autowired
    private ComedianService comedianService;

    /***
     * (01) To search and return single Special from Repository.
     * @param id
     * @return special
     */
    @Override
    public SpecialDTO getASpecial(String id) {
        //Long idInLong = Long.valueOf(id);
        Optional<Special> optionalSpecial =  repository.findById(id);

        SpecialDTO fetchedSpecialDTO = specialMapper.specialToSpecialDTO(optionalSpecial.get());
        return fetchedSpecialDTO;
    }

    /***
     * (02) to create a new comedian
     * @param createSpecialDTO
     * @return newSpecial
     */
    @Override
    public Special createSpecial(CreateSpecialDTO createSpecialDTO) {
        SpecialDTO specialDTO = specialMapper.createSpecialDTOToSpecialDTO(createSpecialDTO);
        Special newSpecial = specialMapper.specialDTOToSpecial(specialDTO);
        return repository.save(newSpecial);
    }

    public SpecialDTO findASpecial(String id) {
        Special specialFound = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find special"));

        SpecialDTO specialDTO = specialMapper.specialToSpecialDTO(specialFound);

        return specialDTO;
    }

    /***
     * (03) To update a comedian
     * @param id
     * @param newSpecialDTO
     * @return special
     */
    //(03) to change a comedian
    @Override
    public Special updateSpecial(String id, SpecialDTO newSpecialDTO) {

        return repository.findById(id)
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
    }

    /***
     * (04) to delete comedian
     * @param id
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
