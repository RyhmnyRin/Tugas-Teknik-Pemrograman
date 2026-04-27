package com.p2p;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import com.p2p.domain.*;
import com.p2p.service.*;

public class LoanServiceTest {
    @Test
    // TC - 01
    void shouldRejectLoanWhenBorrowerNotVerified() {

        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================

        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act (Action)
        // =========================
        // Borrower mencoba mengajukan loan
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
        // =========================
        // Assert (Expected Result)
        // =========================
        assertTrue(true);
    }

    // TC - 02
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        // SCENARIO :
        // Borrorwer nya valid
        // Amount <= 0
        // EXPECTATION :
        // Exception

        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal invalidAmount = BigDecimal.ZERO;

        // Act: Sistem mengeluarkan exception karena amount <= 0
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, invalidAmount);
        });
    }

    // TC - 03
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {
        // SCENARIO:
        // Borrower nya verified
        // Credit score >= threshold
        // EXPECTED:
        // status = APPROVED

        Borrower borrower = new Borrower(true, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert: status harus APPROVED
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    // TC - 04
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {
        // SCENARIO:
        // Borrower nya verified
        // Credit Score < threshold
        // EXPECTED:
        // Status = REJECTED

        Borrower borrower = new Borrower(true, 599);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert: status harus REJECTED
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }


}
