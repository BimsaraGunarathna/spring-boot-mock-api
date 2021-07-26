package com.example.springbootmockapi.controller;

import com.example.springbootmockapi.model.comedian.Comedian;
import com.example.springbootmockapi.response.CMSResponse;
import com.example.springbootmockapi.validation.comedian.ComedianRequest;
import com.example.springbootmockapi.validation.comedian.ComedianResponse;
import com.example.springbootmockapi.validation.comedian.ComediansResponse;
import com.example.springbootmockapi.service.ComedianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Class for Comedian Controller
 * @author bimsa
 * @since 21/7
 */
@RestController
@RequestMapping("/comedian")
public class ComedianController {

    @Autowired
    ComedianService comedianService;

    /***
     * to send all the comedians
     * @return comedians
     */
    @GetMapping
    public ResponseEntity<ComediansResponse> getComedians() {
        ComediansResponse response = new ComediansResponse("Comedians are retrieved successfully.", comedianService.getComedians());
        return new ResponseEntity<ComediansResponse>(response, HttpStatus.OK);
    }

    /***
     * to create a new comedian
     * @param newComedian
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<CMSResponse> newComedian(@Valid @RequestBody ComedianRequest newComedian) {
        ComedianResponse response = new ComedianResponse("A new comedian is created.", comedianService.createComedian(newComedian));
        Comedian comedian = response.getComedian();
        CMSResponse<Comedian> cmsResponse = new CMSResponse<>(HttpStatus.OK.value(), comedian, "Commedian Created successfully");
        return new ResponseEntity<CMSResponse>(cmsResponse, HttpStatus.CREATED);
    }

    /***
     * to return a single comedian
     * @param id
     * @return comedian
     */
    @GetMapping( "/{id}")
    public ResponseEntity<ComedianResponse> getAComedian(@PathVariable Long id) {
        System.out.println( id);

        Comedian fetchedComedian = comedianService.getAComedian(id.toString());

        ComedianResponse response = new ComedianResponse("Comedian retrieved successfully!", fetchedComedian);

        return new ResponseEntity<ComedianResponse>( response, HttpStatus.OK);
    }

    /***
     * to change a comedian
     * @param newComedian
     * @param id
     * @return updatedComedian
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> replaceComedian(@RequestBody Comedian newComedian, @PathVariable Long id) {
        Comedian updatedComedian = comedianService.updateComedian(id.toString(), newComedian);
        return new ResponseEntity<>("Comedian is updated! " + updatedComedian, HttpStatus.OK);

    }

    /***
     * to delete a comedian
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComedian(@PathVariable Long id) {
        boolean deletionStatus = comedianService.deleteComedian(id.toString());
        if (deletionStatus) {
            return new ResponseEntity<>("Comedian is deleted ", HttpStatus.OK);
        }
        return new ResponseEntity<>("Comedian doesn't exits!", HttpStatus.NOT_FOUND);
    }
    /*

    //(01) to return all comedians
    @GetMapping("/comedians")
    CollectionModel<EntityModel<Comedian>> all() {

        List<EntityModel<Comedian>> comedians = repository.findAll().stream()
                .map(comedian -> EntityModel.of(comedian,
                        linkTo(methodOn(ComedianController.class).one(comedian.getId())).withSelfRel(),
                        linkTo(methodOn(ComedianController.class).all()).withRel("comedians")))
                .collect(Collectors.toList());

        return CollectionModel.of(comedians, linkTo(methodOn(ComedianController.class).all()).withSelfRel());
    }

    //(02) to create a new comedian.
    @PostMapping("/comedians")
    Comedian newComedian(@RequestBody Comedian newComedian) {
        return repository.save(newComedian);
    }

    //(03) to return a single comedian
    @GetMapping("/comedians/{id}")
    EntityModel<Comedian> one(@PathVariable Long id) {
        Comedian comedian = repository.findById(id) //
                .orElseThrow(() -> new ComedianNotFoundException(id));

        return EntityModel.of(comedian, //
                linkTo(methodOn(ComedianController.class).one(id)).withSelfRel(),
                linkTo(methodOn(ComedianController.class).all()).withRel("comedians"));
    }

    //(03) to change a comedian
    @PutMapping("/comedians/{id}")
    Comedian replaceComedian(@RequestBody Comedian newComedian, @PathVariable Long id) {

        return repository.findById(id)
                .map(comedian -> {
                    comedian.setName(newComedian.getName());
                    comedian.setRole(newComedian.getRole());
                    return repository.save(comedian);
                })
                .orElseGet(() -> {
                    newComedian.setId(id);
                    return repository.save(newComedian);
                });
    }

    //(04) to delete a comedian
    @DeleteMapping("/comedians/{id}")
    void deleteComedian(@PathVariable Long id) {
        repository.deleteById(id);
    }

    */
}
