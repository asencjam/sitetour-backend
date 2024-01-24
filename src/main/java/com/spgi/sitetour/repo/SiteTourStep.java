package com.spgi.sitetour.repo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiteTourStep {
    @Id
    private int siteTourStepId;
    private String selector;
    private String content;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "useCaseId")
    @JsonIgnore
    private UseCase useCase;
}
