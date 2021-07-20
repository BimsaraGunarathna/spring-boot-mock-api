package com.example.springbootmockapi.services.comedian;

import com.example.springbootmockapi.exceptions.ComedianNotFoundException;
import com.example.springbootmockapi.models.Comedian;
import com.example.springbootmockapi.repositories.ComedianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ComedianServiceImpl implements ComedianService {

    private final ComedianRepository repository;

    //(01) to get a single comedian
    @Override
    public Comedian getAComedian(String id) {
        Long idInLong = Long.valueOf(id).longValue();
        return repository.findById(idInLong).orElseThrow(() -> new ComedianNotFoundException(idInLong));
    }

    //(02) to create a new comedian
    @Override
    public Comedian createComedian(Comedian comedian) {
        return repository.save(comedian);
    }

    //(03) to change a comedian
    @Override
    public Comedian updateComedian(String id, Comedian newComedian) {
        Long idInLong = Long.valueOf(id).longValue();

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

    //(04) to delete comedian
    @Override
    public boolean deleteComedian(String id) {
        Long idInLong = Long.valueOf(id).longValue();
        //handle the event comedian doesn't exits
        if (repository.existsById(idInLong)) {
            System.out.println(repository.findById(idInLong));
            repository.deleteById(idInLong);
            return true;
        }
        return false;
    }

    //(05) to get all comedians
    @Override
    public Collection<Comedian> getComedians() {
        return repository.findAll();
    }
}
