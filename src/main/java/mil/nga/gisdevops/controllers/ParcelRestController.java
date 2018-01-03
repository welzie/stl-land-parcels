package mil.nga.gisdevops.controllers;

import mil.nga.gisdevops.models.Parcel;
import mil.nga.gisdevops.repositories.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikemenne on 12/29/17.
 */

@RestController
@RequestMapping(value = "/api/v1/parcels")
public class ParcelRestController {

    @Autowired
    private ParcelRepository parcelRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Parcel> readParcels() {
        return parcelRepository.findAll();
    }



}
