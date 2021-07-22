package com.example.springbootmockapi.service.impl;

import com.example.springbootmockapi.exception.ComedianNotFoundException;
import com.example.springbootmockapi.model.comedian.Comedian;
import com.example.springbootmockapi.model.comedian.ComedianRequest;
import com.example.springbootmockapi.repository.ComedianRepository;
import com.example.springbootmockapi.service.ComedianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/***
 * To process request for ComedianController
 * @author Bimsara Gunarathna
 * @since 7/19/2021
 */
@Service
public class ComedianServiceImpl implements ComedianService {

    @Autowired
    private ComedianRepository repository;

    /***
     * (01) To search and return single Comedian from Repository.
     * @param id
     * @return comedian
     */
    @Override
    public Comedian getAComedian(String id) {
        Long idInLong = Long.valueOf(id);
        return repository.findById(idInLong).orElseThrow(() -> new ComedianNotFoundException(idInLong));
    }

    /***
     * (02) to create a new comedian
     * @param comedian
     * @return comedian
     */
    @Override
    public Comedian createComedian(ComedianRequest comedianRequest) {
        Comedian newComedian = new Comedian(comedianRequest.getName(), comedianRequest.getRole());
        return repository.save(newComedian);
    }

    /***
     * (03) To update a comedian
     * @param id
     * @param newComedian
     * @return comedian
     */
    //(03) to change a comedian
    @Override
    public Comedian updateComedian(String id, Comedian newComedian) {
        Long idInLong = Long.valueOf(id);

        return repository.findById(idInLong)
                .map(singleComedian -> {
                    singleComedian.setName(newComedian.getName());
                    singleComedian.setRole(newComedian.getRole());
                    return repository.save(singleComedian);
                })
                .orElseGet(() -> {
                    newComedian.setId(idInLong);
                    return repository.save(newComedian);
                });

    }

    /***
     * (04) to delete comedian
     * @param id
     * @return deletedOrNot
     */
    @Override
    public boolean deleteComedian(String id) {
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
     * @return comedians
     */
    @Override
    public Collection<Comedian> getComedians() {
        return repository.findAll();
    }
}
