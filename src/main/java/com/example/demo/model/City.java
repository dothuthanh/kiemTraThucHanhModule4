package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Size(min = 2, max = 30, message = "sai roi ban e tu 2 den 30 ma")
    @NotBlank(message = "an dau cach chu gi khon nhu m que t day")
    private String nameCity;
    @Size(min = 2, max = 30, message = "sai roi ban e tu 2 den 30 ma")
    @NotBlank(message = "nhap lai di ban eyyy")
    private String acreage;
    @Size(min = 2, max = 30, message = "sai roi ban e tu 2 den 30 ma")
    @NotBlank(message = "nao nao nhap lai di")
    private String population;
    @Size(min = 2, max = 30, message = "sai roi ban e tu 2 den 30 ma")
    @NotBlank(message = "nhap cho doang hoang vao")
    private String gdp;
    @Size(min = 2, max = 30, message = "sai roi ban e tu 2 den 30 ma")
    @NotBlank(message = "danh chet cha may bay gio")
    private String introduce;
    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;



}
