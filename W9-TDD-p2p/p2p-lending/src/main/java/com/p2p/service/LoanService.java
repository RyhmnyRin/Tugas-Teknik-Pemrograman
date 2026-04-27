package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;
public class LoanService {
    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        // =========================
        // VALIDASI UTAMA (TC-01)
        // =========================
        // Jika borrower belum terverifikasi,
        // maka proses harus dihentikan
        // TC - 01
        validateBorrower(borrower);
        // TC - 02
        validateAmount(amount);
        // Membuat objek loan baru
        Loan loan = new Loan();
        // =========================
        // LOGIC SEDERHANA (sementara)
        // =========================
        // Jika credit score tinggi → APPROVED
        // Jika tidak → REJECTED
        if (borrower.getCreditScore() >= 600) {
            loan.approve();
        } else {
            loan.reject();
        }
        return loan;
    }

    // Private Validate Method (TC - 01 dan TC - 02)
    private void validateBorrower(Borrower borrower){
        if (!borrower.canApplyLoan()){
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount){
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Invalid loan amount");
        }
    }
}
