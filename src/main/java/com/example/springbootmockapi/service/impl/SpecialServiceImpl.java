package com.example.springbootmockapi.service.impl;

import com.example.springbootmockapi.exception.ResourceNotFoundException;
import com.example.springbootmockapi.model.special.Special;
import com.example.springbootmockapi.repository.SpecialRepository;
import com.example.springbootmockapi.service.SpecialService;
import com.example.springbootmockapi.validation.special.SpecialRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/***
 * To store specials to JPA
 * @author Bimsara Gunarathna
 * @since 7/23/2021
 */

@Service
public class SpecialServiceImpl implements SpecialService {

    @Autowired
    private SpecialRepository repository;

    /***
     * (01) To search and return single Special from Repository.
     * @param id
     * @return special
     */
    @Override
    public Special getASpecial(String id) {
        Long idInLong = Long.valueOf(id);
        return repository.findById(idInLong).orElseThrow(() -> new ResourceNotFoundException("Could not find special"));
    }

    /***
     * (02) to create a new comedian
     * @param specialRequest
     * @return newSpecial
     */
    @Override
    public Special createSpecial(SpecialRequest specialRequest) {
        //Special mappedSpecial = mapper.
        Special newSpecial = new Special(specialRequest.getName(), specialRequest.getDescription());
        return repository.save(newSpecial);
    }

    /***
     * (03) To update a comedian
     * @param id
     * @param newSpecial
     * @return special
     */
    //(03) to change a comedian
    @Override
    public Special updateSpecial(String id, Special newSpecial) {
        Long idInLong = Long.valueOf(id);

        return repository.findById(idInLong)
                .map(singleSpecial -> {
                    singleSpecial.setName(newSpecial.getName());
                    singleSpecial.setDescription(newSpecial.getDescription());
                    return repository.save(singleSpecial);
                })
                .orElseGet(() -> {
                    newSpecial.setId(idInLong);
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
        Long idInLong = Long.valueOf(id);
        //handle the event comedian doesn't exits
        if (repository.existsById(idInLong)) {
            System.out.println(repository.findById(idInLong));
            repository.deleteById(idInLong);
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
