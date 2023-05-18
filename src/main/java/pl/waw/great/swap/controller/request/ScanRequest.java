package pl.waw.great.swap.controller.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.waw.great.swap.service.api.verification.ActionType;

@AllArgsConstructor
@Getter
@Setter
public class ScanRequest {
    private String ean;
    private ActionType actionType;
}
