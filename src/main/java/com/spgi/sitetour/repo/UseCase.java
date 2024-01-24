package com.spgi.sitetour.repo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UseCase {

    @Id
    private int useCaseId;
    private String description;
    private String instruction;

    @OneToMany(fetch= FetchType.LAZY, mappedBy = "useCase")
    private List<SiteTourStep> siteTourSteps;
}
