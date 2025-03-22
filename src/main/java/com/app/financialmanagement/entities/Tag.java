package com.app.financialmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

import io.swagger.v3.oas.annotations.Hidden;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name="master_tags")
public class Tag implements Serializable {
    private static final long serialVersionUID = 7614500210597678021L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Integer id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Hidden
    @Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private Set<TicketTagMapping> ticketTagMappings;

    @Hidden
    @Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    private Set<NoteTagMapping> noteTagMappings;

    @PrePersist
    void onCreate(){
        this.createdAt = LocalDateTime.now();
        this.name = this.name.toUpperCase();
    }
}
