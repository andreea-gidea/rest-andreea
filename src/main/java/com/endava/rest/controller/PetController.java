package com.endava.rest.controller;

import com.endava.rest.exception.DataNotFoundException;
import com.endava.rest.exception.InvalidDataException;
import com.endava.rest.model.PersonNM;
import com.endava.rest.model.Pet;
import com.endava.rest.service.PetService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value = "Pets Rest Controller", tags = "/pets")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/pets")
public class PetController {

  private final PetService petService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Pet> getAllPets() {
    return petService.findAll();
  }

  @ApiOperation(value = "Get Pet by id ", response = Pet.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success|OK"),
      @ApiResponse(code = 401, message = "Not Authorized!"),
      @ApiResponse(code = 403, message = "Forbidden!"),
      @ApiResponse(code = 404, message = "Not Found!") })
  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Pet> getPetById(@PathVariable Long id) {
    if(id < 0)
    {
      throw new DataNotFoundException("pet not found for id");
    }

    return petService.findById(id);
  }

  @Validated
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public void savePet(@RequestBody @ApiParam @Valid Pet pet, BindingResult bindingResult) {
    if(bindingResult.hasErrors())
    {
      throw new InvalidDataException("invalid person");
    }

    petService.save(pet);
  }

  @DeleteMapping(path = "/{id}")
  public void deletePet(@PathVariable() Long id)
  {
    petService.delete(id);
  }
}
