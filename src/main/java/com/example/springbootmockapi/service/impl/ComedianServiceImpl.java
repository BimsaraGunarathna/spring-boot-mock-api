package com.example.springbootmockapi.service.impl;

import com.example.springbootmockapi.dto.comedian.ComedianDTO;
import com.example.springbootmockapi.dto.comedian.CreateComedianDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
import com.example.springbootmockapi.entity.special.Special;
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

    //private ComedianMapper comedianMapper = Mappers.getMapper(ComedianMapperImpl.class);
    @Autowired
    private ComedianMapper comedianMapper;

    /***
     * to search and return single Comedian from Repository.
     * @param id
     * @return comedian
     */
    @Override
    public ComedianDTO getAComedian(String id) {
        Optional<Comedian> optionalComedian =  comedianRepository.findById(id);


        ComedianDTO fetchedComedianDTO = comedianMapper.comedianToComedianDTO(optionalComedian.get());
        return fetchedComedianDTO;
    }

    /***
     * to create a new comedian
     * @param createComedianDTO
     * @return comedian
     */
    @Override
    public ComedianDTO createComedian(CreateComedianDTO createComedianDTO) {
        ComedianDTO comedianDTO =  comedianMapper.createComedianDTOToComedianDTO(createComedianDTO);
        Comedian optionalComedian =  comedianRepository.save(comedianMapper.comedianDTOToComedian(comedianDTO));
        return comedianDTO;
    }

    /***
     * to update a comedian
     * @param id
     * @param newComedianDTO
     * @return comedian
     */
    //(03) to change a comedian
    @Override
    public ComedianDTO updateComedian(String id, ComedianDTO newComedianDTO) {


        comedianRepository.findById(id)
                .map(singleComedian -> {
                    singleComedian.setName(newComedianDTO.getName());
                    singleComedian.setRole(newComedianDTO.getRole());
                    return comedianRepository.save(singleComedian);
                })
                .orElseGet(() -> {
                    newComedianDTO.setId(id);
                    Comedian newComedian = comedianMapper.comedianDTOToComedian(newComedianDTO);
                    return comedianRepository.save(newComedian);
                });
        return newComedianDTO;
    }

    /***
     * to delete comedian
     * @param id
     * @return deletedOrNot
     */
    @Override
    public boolean deleteComedian(String id) {
        //handle the event comedian doesn't exits
        if (comedianRepository.existsById(id)) {
            System.out.println(comedianRepository.findById(id));
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
