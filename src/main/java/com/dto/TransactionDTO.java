package com.dto;

import lombok.Data;

/**
 * Project: AplicatieBancara
 * Author: mihai
 * Date: 11/8/2020
 */

/*Transaction detine toate detaliile oricarei tranzactii (debitare, creditare, transfer intre conturi, etc.).
 Tranzactiile vor fi salvate intr-un repository dedicat acestora.
 */

@Data
public class TransactionDTO {

    private Long transactionId;
    private String sender;
    private String receiver;
    private String comment;
}
