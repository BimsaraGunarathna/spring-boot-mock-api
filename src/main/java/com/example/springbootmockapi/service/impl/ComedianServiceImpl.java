package com.example.springbootmockapi.service.impl;

import com.example.springbootmockapi.dto.comedian.ComedianDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
import com.example.springbootmockapi.mapper.ComedianMapper;
import com.example.springbootmockapi.repository.ComedianRepository;
import com.example.springbootmockapi.service.ComedianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/***
 * To process request for ComedianController
 * @author Bimsara Gunarathna
 * @since 7/19/2021
 */
@Service
public class ComedianServiceImpl implements ComedianService {

    @Autowired
    private ComedianRepository comedianRepository;

    @Autowired
    private ComedianMapper comedianMapper;

    /***
     * to search and return single Comedian from Repository.
     * @param id - id of the Comedian to be retrieved
     * @return comedian
     */
    @Override
    public ComedianDTO getAComedian(String id) {
            Optional<Comedian> optionalComedian =  comedianRepository.findById(id);
            if (optionalComedian.isPresent()) {
                return comedianMapper.comedianToComedianDTO(optionalComedian.get());
            }

        return null;
    }

    /***
     * to create a new comedian
     * @param comedianDTO - A CreateComedianDTO object
     * @return comedian
     */
    @Override
    public ComedianDTO createComedian(ComedianDTO comedianDTO) {
        comedianRepository.save(comedianMapper.comedianDTOToComedian(comedianDTO));
        return comedianDTO;
    }

    /***
     * to update a comedian
     * @param id - id of the Comedian to be updated
     * @param newComedianDTO - A CreateComedianDTO object
     * @return comedian
     */
    @Override
    public ComedianDTO updateComedian(String id, ComedianDTO newComedianDTO) {

        Optional<Comedian> updatedComedian = comedianRepository.findById(id)
                .map(singleComedian -> {
                    singleComedian.setName(newComedianDTO.getName());
                    singleComedian.setRole(newComedianDTO.getRole());
                    return comedianRepository.save(singleComedian);
                });
        if(updatedComedian.isPresent()) {
            return newComedianDTO;
        }
        return null;
    }

    /***
     * to delete comedian
     * @param id - id of Comedian to be deleted
     * @return deletedOrNot
     */
    @Override
    public boolean deleteComedian(String id) {
        //handle the event comedian doesn't exits
        if (comedianRepository.existsById(id)) {
            comedianRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /***
     * to get all the comedians
     * @return comedians
     */
    @Override
    public Collection<ComedianDTO> getComedians() {
        return comedianMapper.comediansToComedianDTOs(comedianRepository.findAll());
    }
}
