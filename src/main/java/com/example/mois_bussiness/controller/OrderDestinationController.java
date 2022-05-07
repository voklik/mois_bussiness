package com.example.mois_bussiness.controller;

import com.example.mois_bussiness.domain.OrderDestination;
import com.example.mois_bussiness.dto.OrderDestinationDTO;
import com.example.mois_bussiness.service.OrderDestinationService;
import com.example.mois_bussiness.util.OrderDestinationPDFExporter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "rest/api/orders")
public class OrderDestinationController {

    private final OrderDestinationService orderDestinationService;

    @GetMapping({"/", "/{page}/{size}"})
    public ResponseEntity<Page<OrderDestinationDTO>> getAllOrders(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "15") int size) {

        return new ResponseEntity<>(orderDestinationService.getAllOrders(
                PageRequest.of(
                        page, size)
        ), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDestination>> getDestinationByUser(@PathVariable Long userId) {
        List<OrderDestination> orderDestinationByUser = orderDestinationService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orderDestinationByUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDestination> getDestination(@PathVariable Long id) {
        OrderDestination orderDestination = orderDestinationService.getOrderDestination(id);
        return ResponseEntity.ok(orderDestination);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createOrder(@RequestBody @Valid OrderDestinationDTO orderDestinationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ErrorUtil.getErrorResponse(bindingResult);
        }

        OrderDestination orderDestination = orderDestinationService.createOrder(
                orderDestinationDTO.getDateOrder(),
                orderDestinationDTO.getPrice(),
                orderDestinationDTO.getCurrencyType().getId(),
                orderDestinationDTO.getOrderState().getId(),
                orderDestinationDTO.getOffer().getId(),
                orderDestinationDTO.getUserId()
        );

        return ResponseEntity.ok(orderDestination);
    }

    @GetMapping("/exportPDF")
    public void exportToPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormat.format(new Date());

        String headerKey = "Content-disposition";
        String headerValue = "attachment; filename=myOffer_" + currentDateTime +  ".pdf";

        response.setHeader(headerKey, headerValue);

        OrderDestinationDTO orderDestinationDTO = new OrderDestinationDTO();
        OrderDestination orderDestination = orderDestinationService.getOrderDestination(orderDestinationDTO.getId());

        OrderDestinationPDFExporter exporter = new OrderDestinationPDFExporter(orderDestination);
        exporter.export(response);
    }
}
