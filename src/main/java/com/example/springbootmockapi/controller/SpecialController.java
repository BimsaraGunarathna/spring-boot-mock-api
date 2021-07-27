package com.example.springbootmockapi.controller;

import com.example.springbootmockapi.dto.SpecialDTO;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.service.SpecialService;
import com.example.springbootmockapi.validation.special.SpecialRequest;
import com.example.springbootmockapi.validation.special.SpecialResponse;
import com.example.springbootmockapi.validation.special.SpecialsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Class for Special Controller
 * @author Bimsara Gunarathna
 * @since 7/23/7
 */
@RestController
public class SpecialController {
    //Constants
    private static final String SPECIALS_URL = "/specials";
    private static final String SPECIAL_URL = "/special";

    @Autowired
    SpecialService specialService;

    /***
     * (01) to send all the comedians
     * @return specialsResponse
     */
    @GetMapping(SPECIALS_URL)
    public ResponseEntity<SpecialsResponse> getSpecials() {
        SpecialsResponse response = new SpecialsResponse("Specials are retrieved successfully.", specialService.getSpecials());
        return new ResponseEntity<SpecialsResponse>(response, HttpStatus.OK);
    }

    /***
     * (02) to create a new comedian
     * @param newSpecial
     * @return ResponseEntity
     */
    @PostMapping(SPECIAL_URL)
    public ResponseEntity<SpecialResponse> newSpecial(@Valid @RequestBody SpecialDTO newSpecial) {
        SpecialResponse response = new SpecialResponse("A new comedian is created.", specialService.createSpecial(newSpecial));
        return new ResponseEntity<SpecialResponse>( response, HttpStatus.CREATED);
    }

    /***
     * (03) to return a single comedian
     * @param id
     * @return special
     */
    @GetMapping(SPECIAL_URL + "/{id}")
    public ResponseEntity<SpecialResponse> getASpecial (@PathVariable Long id) {
        System.out.println( id);

        Special fetchedSpecial = specialService.getASpecial(id.toString());

        SpecialResponse response = new SpecialResponse("Comedian retrieved successfully!", fetchedSpecial);

        return new ResponseEntity<SpecialResponse>( response, HttpStatus.OK);
    }

    /***
     * (04) to change a comedian
     * @param newSpecial
     * @param id
     * @return updatedSpecial
     */
    @PutMapping(SPECIAL_URL + "/{id}")
    public ResponseEntity<Object> replaceSpecial(@RequestBody Special newSpecial, @PathVariable Long id) {
        Special updatedSpecial = specialService.updateSpecial(id.toString(), newSpecial);
        return new ResponseEntity<>("Special is updated! " + updatedSpecial, HttpStatus.OK);

    }

    /***
     * (05) to delete a comedian
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping(SPECIAL_URL + "/{id}")
    public ResponseEntity<String> deleteSpecial(@PathVariable Long id) {
        boolean deletionStatus = specialService.deleteSpecial(id.toString());
        if (deletionStatus) {
            return new ResponseEntity<>("Special is deleted ", HttpStatus.OK);
        }
        return new ResponseEntity<>("Special doesn't exits!", HttpStatus.NOT_FOUND);
    }

}
