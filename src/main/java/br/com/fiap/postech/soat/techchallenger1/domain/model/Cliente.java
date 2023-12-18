package br.com.fiap.postech.soat.techchallenger1.domain.model;


import br.com.fiap.postech.soat.techchallenger1.adapters.dto.ClienteDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String nome;
    private String email;

    public Cliente(ClienteDto clienteDto) {
        this.cpf = clienteDto.getCpf();
        this.nome = clienteDto.getNome();
        this.email = clienteDto.getEmail();
    }


}
