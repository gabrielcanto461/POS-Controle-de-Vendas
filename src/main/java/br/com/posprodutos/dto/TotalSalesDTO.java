package br.com.posprodutos.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TotalSalesDTO {
    private String requestId;
    private Double total;
    private String date;
}
