package com.example.springbootmockapi.controller;

import com.example.springbootmockapi.dto.comedian.ComedianDTO;
import com.example.springbootmockapi.dto.comedian.CreateComedianDTO;
import com.example.springbootmockapi.entity.comedian.Comedian;
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
    public ResponseEntity<CMSResponse> getComedians() {
        Collection<ComedianDTO> retrievedComedians = comedianService.getComedians();
        CMSResponse<Collection<ComedianDTO>> cmsResponse = new CMSResponse<>(HttpStatus.OK, retrievedComedians, "Comedians are retrieved successfully");
        return new ResponseEntity<CMSResponse>(cmsResponse, HttpStatus.OK);
    }

    /***
     * to return a single comedian
     * @param id
     * @return comedian
     */
    @GetMapping( "/{id}")
    public ResponseEntity<CMSResponse> getAComedian(@PathVariable String id) {
        System.out.println( id);
        ComedianDTO fetchedComedianDTO = comedianService.getAComedian(id);
        CMSResponse<ComedianDTO> cmsResponse;
        if (fetchedComedianDTO == null) {
            //throw new ComedianNotFoundException()
            cmsResponse = new CMSResponse<>(HttpStatus.NOT_FOUND, null, "Comedian not found");
        } else {
            cmsResponse = new CMSResponse<>(HttpStatus.OK, fetchedComedianDTO, "Comedian is retrieved successfully");
        }

        return new ResponseEntity<CMSResponse>( cmsResponse, HttpStatus.OK);
    }

    /***
     * to create a new comedian
     * @param newCreateComedianDTO
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<CMSResponse> newComedian(@Valid @RequestBody CreateComedianDTO newCreateComedianDTO) {
        ComedianDTO comedian = comedianService.createComedian(newCreateComedianDTO);
        CMSResponse<ComedianDTO> cmsResponse = new CMSResponse<>(HttpStatus.OK, comedian, "Comedian is created successfully");
        System.out.println("@POST: " + newCreateComedianDTO.getName());
        return new ResponseEntity<CMSResponse>(cmsResponse, HttpStatus.CREATED);
    }

    /***
     * to change a comedian
     * @param newComedian
     * @param id
     * @return updatedComedian
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> replaceComedian(@RequestBody ComedianDTO newComedian, @PathVariable String id) {
        ComedianDTO updatedComedian = comedianService.updateComedian(id, newComedian);
        return new ResponseEntity<>("Comedian is updated! " + updatedComedian, HttpStatus.OK);
    }

    /***
     * to delete a comedian
     * @param id
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
