package com.airportService.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class LuggageType {
    @Id
    @GeneratedValue
    private Long id;
    private String luggageType;
}