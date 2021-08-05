package com.example.springbootmockapi.service.impl;

import com.example.springbootmockapi.dto.ComedianDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
import com.example.springbootmockapi.mapper.ComedianMapper;
import com.example.springbootmockapi.mapper.impl.ComedianMapperImpl;
import com.example.springbootmockapi.repository.ComedianRepository;
import com.example.springbootmockapi.service.ComedianService;
import org.mapstruct.factory.Mappers;
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
    private ComedianRepository repository;

    //private ComedianMapper comedianMapper = Mappers.getMapper(ComedianMapperImpl.class);
    @Autowired
    private ComedianMapper comedianMapper;

    /***
     * (01) To search and return single Comedian from Repository.
     * @param id
     * @return comedian
     */
    @Override
    public ComedianDTO getAComedian(String id) {

        Long idInLong = Long.valueOf(id);
        Optional<Comedian> optional = repository.findById(idInLong);
        ComedianDTO fetchedComedianDTO = comedianMapper.comedianToComedianDTO(optional.get());
        return fetchedComedianDTO;
    }

    /***
     * (02) to create a new comedian
     * @param comedianDTO
     * @return comedian
     */
    @Override
    public Comedian createComedian(ComedianDTO comedianDTO) {
        return repository.save(comedianMapper.comedianDTOToComedian(comedianDTO));
    }

    /***
     * (03) To update a comedian
     * @param id
     * @param newComedianDTO
     * @return comedian
     */
    //(03) to change a comedian
    @Override
    public Comedian updateComedian(String id, ComedianDTO newComedianDTO) {
        Long idInLong = Long.valueOf(id);

        return repository.findById(idInLong)
                .map(singleComedian -> {
                    singleComedian.setName(newComedianDTO.getName());
                    singleComedian.setRole(newComedianDTO.getRole());
                    return repository.save(singleComedian);
                })
                .orElseGet(() -> {
                    newComedianDTO.setId(idInLong);
                    Comedian newComedian = comedianMapper.comedianDTOToComedian(newComedianDTO);
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
    public Collection<ComedianDTO> getComedians() {
        return comedianMapper.comediansToComedianDTOs(repository.findAll());
    }
}
