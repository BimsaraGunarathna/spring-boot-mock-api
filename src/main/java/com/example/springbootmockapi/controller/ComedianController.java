package com.example.springbootmockapi.controller;

import com.example.springbootmockapi.dto.comedian.ComedianDTO;
import com.example.springbootmockapi.response.CMSResponse;
import com.example.springbootmockapi.service.ComedianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


/**
 * Class for Comedian Controller
 * @author bimsa
 * @since 21/7
 */
//remove this and check
@Validated
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
    public ResponseEntity<CMSResponse<Collection<ComedianDTO>>> getComedians() {
        Collection<ComedianDTO> retrievedComedians = comedianService.getComedians();
        CMSResponse<Collection<ComedianDTO>> cmsResponse = new CMSResponse<>(HttpStatus.OK, retrievedComedians, "Comedians are retrieved successfully");
        return new ResponseEntity<>(cmsResponse, HttpStatus.OK);
    }

    /***
     * to return a single comedian
     * @param id -
     * @return comedian
     */
    @GetMapping( "/{id}")
    public ResponseEntity<CMSResponse<ComedianDTO>> getAComedian(@PathVariable String id) {
        ComedianDTO fetchedComedianDTO = comedianService.getAComedian(id);
        CMSResponse<ComedianDTO> cmsResponse;
        if (fetchedComedianDTO == null) {
            cmsResponse = new CMSResponse<>(HttpStatus.NOT_FOUND, null, "Comedian not found");
        } else {
            cmsResponse = new CMSResponse<>(HttpStatus.OK, fetchedComedianDTO, "Comedian is retrieved successfully");
        }

        return new ResponseEntity<>( cmsResponse, HttpStatus.OK);
    }

    /***
     * to create a new comedian
     * @param newComedianDTO - CreateComedianDTO object to create a new comedian
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<CMSResponse<ComedianDTO>> newComedian(@Valid @RequestBody ComedianDTO newComedianDTO) {
        ComedianDTO comedian = comedianService.createComedian(newComedianDTO);
        CMSResponse<ComedianDTO> cmsResponse = new CMSResponse<>(HttpStatus.OK, comedian, "Comedian is created successfully");
        return new ResponseEntity<>(cmsResponse, HttpStatus.CREATED);
    }

    /***
     * to change a comedian
     * @param newComedianDTO - comedian instance to be created
     * @param id - id of comedian to be changed
     * @return updatedComedian
     */
    @PutMapping("/{id}")
    public ResponseEntity<CMSResponse<ComedianDTO>> replaceComedian(@RequestBody ComedianDTO newComedianDTO, @PathVariable String id) {
        ComedianDTO updatedComedian = comedianService.updateComedian(id, newComedianDTO);
        CMSResponse<ComedianDTO> cmsResponse;
        if (updatedComedian == null) {
            cmsResponse = new CMSResponse<>(HttpStatus.NOT_FOUND, null, "Comedian can't found to be updated.");
        } else {
            cmsResponse = new CMSResponse<>(HttpStatus.OK, updatedComedian, "Comedian is updated successfully");
        }
        return new ResponseEntity<>( cmsResponse, HttpStatus.OK);
    }

    /***
     * to delete a comedian
     * @param id - id of comedian to be deleted
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComedian(@PathVariable String id) {
        boolean deletionStatus = comedianService.deleteComedian(id);
        if (deletionStatus) {
            return new ResponseEntity<>("Comedian is deleted ", HttpStatus.OK);
        }
        return new ResponseEntity<>("Comedian doesn't exits!", HttpStatus.NOT_FOUND);
    }
}
