package com.kodilla.transfersrealizationservice.service;

import com.kodilla.commons.TransferMessage;
import com.kodilla.transfersrealizationservice.repository.AccountsRepository;
import com.kodilla.transfersrealizationservice.repository.TransfersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TransferService {
    private final AccountsRepository accountsRepository;
    private final TransfersRepository transfersRepository;

    public void handleTansfer(TransferMessage transferMessage) {
        transfersRepository.getTransferList().add(transferMessage.getTransfer());
        System.out.println(transfersRepository.getTransferList());

        accountsRepository.getAccountList()
                .stream()
                .filter(a -> a.getAccountNumber().equals(transferMessage.getTransfer().getSenderAccount()))
                .forEach(a -> a.setSaldo(a.getSaldo().subtract(transferMessage.getTransfer().getAmount())));

        accountsRepository.getAccountList()
                .stream()
                .filter(a -> a.getAccountNumber().equals(transferMessage.getTransfer().getRecipientAccount()))
                .forEach(a -> a.setSaldo(a.getSaldo().add(transferMessage.getTransfer().getAmount())));
        System.out.println(accountsRepository.getAccountList());
    }
}
