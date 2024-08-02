package com.javaproject.tariffcalculator.rest;

import com.javaproject.tariffcalculator.dto.MobileTariffInsertDTO;
import com.javaproject.tariffcalculator.dto.MobileTariffReadOnlyDTO;
import com.javaproject.tariffcalculator.dto.MobileTariffUpdateDTO;
import com.javaproject.tariffcalculator.mapper.Mapper;
import com.javaproject.tariffcalculator.model.MobileTariff;
import com.javaproject.tariffcalculator.service.IMobileTariffService;
import com.javaproject.tariffcalculator.service.exception.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MobileTariffRestController {

    private final IMobileTariffService mobileTariffService;

    @GetMapping("/mobiletariffs")
    public ResponseEntity<List<MobileTariffReadOnlyDTO>> getMobileTariffNameByMobileTariffData(@RequestParam("data") int data){
        List<MobileTariff> mobileTariffs;

        try {
            mobileTariffs = mobileTariffService.getMobileTariffNameByMobileTariffData(data);
            List<MobileTariffReadOnlyDTO> readOnlyDTOS = new ArrayList<>();
            for (MobileTariff mobileTariff : mobileTariffs) {
                readOnlyDTOS.add(Mapper.mapToMobileTariffReadOnlyDTO(mobileTariff));
            }
            return new ResponseEntity<>(readOnlyDTOS, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/mobiletariffs/{id}")
    public ResponseEntity<MobileTariffReadOnlyDTO> getMobileTariff(@PathVariable("id") String id ) {
        MobileTariff mobileTariff;

        try {
            mobileTariff = mobileTariffService.getByMobileTariffId(id);
            MobileTariffReadOnlyDTO dto = Mapper.mapToMobileTariffReadOnlyDTO(mobileTariff);
            return ResponseEntity.ok(dto);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/mobiletariffs")
    public ResponseEntity<MobileTariffReadOnlyDTO> addMobileTariff(@Valid @RequestBody MobileTariffInsertDTO dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        try {
            MobileTariff mobileTariff = mobileTariffService.insertMobileTariff(dto);
            MobileTariffReadOnlyDTO mobileTariffReadOnlyDTO = Mapper.mapToMobileTariffReadOnlyDTO(mobileTariff);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(mobileTariffReadOnlyDTO.getMobileTariffId())
                    .toUri();

            return ResponseEntity.created(location).body(mobileTariffReadOnlyDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @PutMapping("/mobiletariffs/{id}")
    public ResponseEntity<MobileTariffReadOnlyDTO> updateMobileTariff(@PathVariable("id") String id, @Valid @RequestBody MobileTariffUpdateDTO dto,
                                                                      BindingResult bindingResult) {

        if(!Objects.equals(id, dto.getMobileTariffId())) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        try {
            MobileTariff mobileTariff = mobileTariffService.updateMobileTariff(dto);
            MobileTariffReadOnlyDTO readOnlyDTO = Mapper.mapToMobileTariffReadOnlyDTO(mobileTariff);
            return new ResponseEntity<>(readOnlyDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/mobiletariffs/{id}")
    public ResponseEntity<MobileTariffReadOnlyDTO> deleteMobileTariff(@PathVariable("id") String id) {

        try {
            MobileTariff mobileTariff = mobileTariffService.deleteMobileTariff(id);
            MobileTariffReadOnlyDTO readOnlyDTO = Mapper.mapToMobileTariffReadOnlyDTO(mobileTariff);
            return  ResponseEntity.ok(readOnlyDTO);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
