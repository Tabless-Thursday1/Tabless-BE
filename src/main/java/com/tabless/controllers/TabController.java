package com.tabless.controllers;

import com.tabless.models.Tab;
import com.tabless.services.TabService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tabs")
public class TabController {
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);
    @Autowired
    private TabService tabService;

    @ApiOperation(value = "Adds a tab to the user selected with the ID variable.", response = Tab.class)
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping(value = "/new/{id}", produces = {"application/json"})
    public ResponseEntity<?> addTabToUser(@PathVariable long id, @RequestBody Tab tab, HttpServletRequest request){
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

         tabService.addTabToUser(id, tab);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Modifies a tab based on the tab ID provided.", response = Tab.class)
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PutMapping(value = "/modify/{id}", produces = {"application/json"})
    public ResponseEntity<?> modifyTab(@PathVariable long id, @RequestBody Tab tab, HttpServletRequest request){
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        tabService.modifyTabById(id, tab);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Deletes a tab based on the ID.")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteTab(@PathVariable long id, HttpServletRequest request){
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        tabService.deleteTab(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
