package ir.isc.assignment.reopsitory;//package ir.co.iscassignment.Repository;

import ir.isc.assignment.model.Issuer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuerRepository extends JpaRepository<Issuer, Long> {
    Issuer findByIssuerName(String issuerName);
}
