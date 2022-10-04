package com.kodilla.transfersrealizationservice.repository;

import com.kodilla.commons.Transfer;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class TransfersRepository {
    List<Transfer> transferList = new ArrayList<>();
}
