package ir.isc.assignment.service;

import ir.isc.assignment.model.Issuer;
import ir.isc.assignment.reopsitory.IssuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssuerServiceImp implements IssuerService{
    @Autowired
    IssuerRepository issuerRepository;
    @Override
    public Issuer newIssuer(String issuerName, String issuerNumber) {
        Issuer issuer = new Issuer( issuerName, issuerNumber);
        return issuerRepository.save(issuer);
    }
}
