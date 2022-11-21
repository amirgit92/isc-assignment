package ir.isc.assignment.service;

import ir.isc.assignment.model.Issuer;
import org.springframework.stereotype.Service;

public interface IssuerService {
    Issuer newIssuer(String issuerName, String issuerNumber);
}
