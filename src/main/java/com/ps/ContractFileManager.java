package com.ps;

import java.io.*;

public class ContractFileManager {

    public void saveContract(Contract contract) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactionLog.csv", true));

            if (contract instanceof SalesContract) {

                ((SalesContract) contract).isFinance();//todo if it is financed
                contract.getDate();
                contract.getCustomerName();
                contract.getCustomerEmail();
//                contract.vin();
                String customerVehInfo = String.format("%s|%s|%s|%s|%s");

                ((SalesContract) contract).getSalesTax();
                ((SalesContract) contract).getRecordingFee();
                ((SalesContract) contract).getProcessingFee();
                ((SalesContract) contract).getMonthlyPayment();
                ((SalesContract) contract).getTotalPrice();
                String saleInfo = String.format("%.2f|%.2f|%.2f|%.2f|%.2f|");

                bufferedWriter.write(customerVehInfo + "\r" + saleInfo);

            } else if (contract instanceof LeaseContract) {// Lease vehicle

                contract.getDate();
                contract.getCustomerName();
                contract.getCustomerEmail();
//                contract.getVehicle();
                String customerVehInfo = String.format("Lease|%s|%s|%s|%s");

                ((LeaseContract) contract).getEndingValue();
                ((LeaseContract) contract).getLeasingFee();
                ((LeaseContract) contract).getMonthlyPayment();
                String leaseInfo = String.format("%.2f|%.2f|%.2f");

                bufferedWriter.write(customerVehInfo + "\r" + leaseInfo);
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
