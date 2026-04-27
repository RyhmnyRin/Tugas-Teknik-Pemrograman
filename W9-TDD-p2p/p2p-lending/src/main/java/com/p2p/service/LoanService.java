package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanService {
    // Inisialisasi Logger
    private static final Logger logger = LogManager.getLogger(LoanService.class);

    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        logger.info("Proses pengajuan loan untuk borrower. Amount: {}", amount);
        // =========================
        // VALIDASI UTAMA (TC-01)
        // =========================
        // Jika borrower belum terverifikasi,
        // maka proses harus dihentikan
        // TC - 01 dan TC - 02
            validateBorrower(borrower);
            validateAmount(amount);
        // Membuat objek loan baru
        Loan loan = new Loan();
        // =========================
        // LOGIC SEDERHANA (sementara)
        // =========================
        // Jika credit score tinggi → APPROVED
        // Jika tidak → REJECTED
        if (borrower.getCreditScore() >= 600) {
            logger.info("Credit score mencukupi ({}). Loan APPROVED.", borrower.getCreditScore());
            loan.approve();
        } else {
            logger.warn("Credit score rendah ({}). Loan REJECTED.", borrower.getCreditScore());
            loan.reject();
        }
        return loan;
    }

    // Private Validate Method (TC - 01 dan TC - 02)
    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            logger.error("Gagal: Borrower belum terverifikasi.");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Gagal: Jumlah pinjaman tidak valid.");
            throw new IllegalArgumentException("Invalid loan amount");
        }
    }
}
