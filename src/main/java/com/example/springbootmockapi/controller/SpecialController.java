package com.example.springbootmockapi.controller;

import com.example.springbootmockapi.dto.comedian.ComedianDTO;
import com.example.springbootmockapi.dto.special.CreateSpecialDTO;
import com.example.springbootmockapi.dto.special.SpecialDTO;
import com.example.springbootmockapi.entity.special.Special;
import com.example.springbootmockapi.response.CMSResponse;
import com.example.springbootmockapi.service.SpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


/**
 * Class for Special Controller
 * @author Bimsara Gunarathna
 * @since 7/23/7
 */
@Validated
@RestController
@RequestMapping("/special")
public class SpecialController {

    @Autowired
    SpecialService specialService;

    /***
     * to send all the comedians
     * @return specialsResponse
     */
    @GetMapping()
    public ResponseEntity<CMSResponse> getSpecials() {
        Collection<Special> specials = specialService.getSpecials();
        CMSResponse response = new CMSResponse(HttpStatus.CREATED, specials,"Specials are retrieved successfully.");
        return new ResponseEntity<CMSResponse>(response, HttpStatus.OK);
    }

    /***
     * to create a new comedian
     * @param createSpecialDTO
     * @return ResponseEntity
     */
    @PostMapping()
    public ResponseEntity<CMSResponse> newSpecial(@Valid @RequestBody CreateSpecialDTO createSpecialDTO) {
        SpecialDTO special = specialService.createSpecial(createSpecialDTO);
        CMSResponse<SpecialDTO> cmsResponse = new CMSResponse<>(HttpStatus.CREATED, special, "A new comedian is created.");

        return new ResponseEntity<CMSResponse>( cmsResponse, HttpStatus.CREATED);
    }

    /***
     * to return a single comedian
     * @param id
     * @return special
     */
    @GetMapping("/{id}")
    public ResponseEntity<CMSResponse> getASpecial (@PathVariable String id) {
        SpecialDTO fetchedSpecialDTO = specialService.getASpecial(id);
        CMSResponse<SpecialDTO> cmsResponse;
        if (fetchedSpecialDTO == null) {
            cmsResponse = new CMSResponse<>(HttpStatus.NOT_FOUND, null, "Special not found");
        } else {
            cmsResponse = new CMSResponse<>(HttpStatus.OK, fetchedSpecialDTO, "Special is retrieved successfully");
        }
        return new ResponseEntity<CMSResponse>( cmsResponse, HttpStatus.OK);
    }

    /***
     * to change a comedian
     * @param newCreateSpecialDTO
     * @param id
     * @return updatedSpecial
     */
    @PutMapping("/{id}")
    public ResponseEntity<CMSResponse> replaceSpecial(@RequestBody CreateSpecialDTO newCreateSpecialDTO, @PathVariable String id) {
        SpecialDTO updatedSpecialDTO = specialService.updateSpecial(id, newCreateSpecialDTO);

        CMSResponse<SpecialDTO> cmsResponse;
        if (updatedSpecialDTO == null) {
            cmsResponse = new CMSResponse<>(HttpStatus.NOT_FOUND, null, "Special not found");
        } else {
            cmsResponse = new CMSResponse<>(HttpStatus.OK, updatedSpecialDTO, "Special is updated successfully");
        }
        return new ResponseEntity<CMSResponse>( cmsResponse, HttpStatus.OK);
    }

    /***
     * to delete a comedian
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSpecial(@PathVariable String id) {
        boolean deletionStatus = specialService.deleteSpecial(id);
        if (deletionStatus) {
            return new ResponseEntity<>("Special is deleted ", HttpStatus.OK);
        }
        return new ResponseEntity<>("Special doesn't exits!", HttpStatus.NOT_FOUND);
    }
}
