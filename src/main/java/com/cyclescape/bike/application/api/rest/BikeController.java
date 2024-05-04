package com.cyclescape.bike.application.api.rest;

import com.cyclescape.bike.application.domain.model.Bike;
import com.cyclescape.bike.application.domain.service.BikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/bikes")
@Tag(name = "BikeController", description = "Bicycles Management Endpoints")
public class BikeController {
    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    // URL: http://localhost:8080/api/leadyourway/v1/bicycles
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping
    @Operation(
            summary="Get Bicycles",
            description = "Get All Bicycles"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Bicycles found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Bike.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Bicycles not found"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error"
            )
    })
    public ResponseEntity<List<Bike>> getAllBikes() {
        //print somethign
        System.out.println("getAllBikes");
        return new ResponseEntity<List<Bike>>(bikeService.getAllBikes(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/leadyourway/v1/bicycles/{bicycleId}
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/{bikeId}")
    @Operation(
            summary = "Get Bicycle",
            description = "Get Bicycle by Id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Bicycle found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Bike.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Bicycle not found"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid id"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error"
            )
    })
    public ResponseEntity<Bike> getBikeById(@PathVariable(name = "bikeId") Long bikeId) {
        return new ResponseEntity<>(bikeService.getBikeById(bikeId), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/leadyourway/v1/bicycles/{bicycleId}
    // Method: PUT
    @Transactional
    @PutMapping("/{bikeId}")
    @Operation(
            summary = "Update Bicycle",
            description = "Update Bicycle by Id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Bicycle updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Bike.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Bicycle not found"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "One or more fields are invalid"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error"
            )
    })
    public ResponseEntity<Bike> updateBikeByBicycleId(@PathVariable(name = "bikeId") Long bikeId, @RequestBody Bike bike) {
        return new ResponseEntity<>(bikeService.updateBike(bikeId, bike), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/leadyourway/v1/bicycles/{bicycleId}
    // Method: DELETE
    @Transactional
    @DeleteMapping("/{bikeId}")
    @Operation(
            summary = "Delete Bicycle",
            description = "Delete Bicycle by Id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Bicycle deleted successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Bike.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Bicycle not found"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid id"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error"
            )
    })
    public ResponseEntity<String> deleteBikeByBicycleId(@PathVariable(name = "bikeId") Long bikeId) {
        return new ResponseEntity<String>("Bicicleta eliminada correctamente", HttpStatus.OK);
    }
}
