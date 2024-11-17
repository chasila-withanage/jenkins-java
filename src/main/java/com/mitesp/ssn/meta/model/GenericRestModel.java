package com.mitesp.ssn.meta.model;

import lombok.Builder;

import java.util.List;

public class GenericRestModel {

    @Builder
    public record GenericResponse(boolean status, String message) {
    }

    @Builder
    public record MetaDataResponseDTO(int value, String label, String code) {
    }


    @Builder
    public record CustomPagedDTO<T>(int totalRecords, int currentPage, int noOfRecords, int totalPages,
                                    boolean hasNextPage, boolean hasPrevPage, List<T> data) {
    }
}
