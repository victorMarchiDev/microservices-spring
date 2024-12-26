package victorMarchiDev.msclientes.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import victorMarchiDev.msclientes.domain.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);
}
