package br.com.posprodutos.controllers;

import br.com.posprodutos.dto.TotalSalesDTO;
import br.com.posprodutos.model.Purchase;
import br.com.posprodutos.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/vendas")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class SalesController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @PostMapping
    public ResponseEntity<Purchase> newSale(@RequestBody Purchase saleDetails){
        var saved = purchaseRepository.save(saleDetails);
        return ResponseEntity.ok().body(saved);
    }

    @GetMapping
    public ResponseEntity<TotalSalesDTO> getDaySales(@RequestHeader String requestId){
        var cal = Calendar.getInstance();
        var formatter = new SimpleDateFormat("dd-MM-yyyy");
        var today = cal.getTime();
        cal.add(Calendar.DATE, -1);
        var yesterday = cal.getTime();
        cal.add(Calendar.DATE, +1);
        var last24Sales = purchaseRepository.findAllByDateBetween(yesterday,today);

        var total = last24Sales.stream()
                .map(Purchase::getTotalValue)
                .reduce(0.0, Double::sum);


        return ResponseEntity.ok().body(TotalSalesDTO.builder()
                .requestId(requestId)
                .total(total)
                .date(formatter.format(cal.getTime())).build());
    }

}
