package pl.waw.great.swap.service.api.verification;

import java.time.LocalDateTime;

public class VerificationResponse {
    private String ean;
    private VerificationState verificationState;

    private LocalDateTime created;

    public VerificationResponse(String ean, VerificationState verificationState, LocalDateTime created) {
        this.ean = ean;
        this.verificationState = verificationState;
        this.created = created;
    }

    public VerificationResponse() {
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public VerificationState getVerificationState() {
        return verificationState;
    }

    public void setVerificationState(VerificationState verificationState) {
        this.verificationState = verificationState;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
