package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.controller;


import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.NotificacaoPagamentoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @PostMapping("/payment")
    public ResponseEntity<String> paymentNotification(@RequestBody NotificacaoPagamentoDto notification){
        String paymentStatus = notification.getStatus();

        /*
                To do:
                Lógica do webhook
        */
        if("approved".equalsIgnoreCase(paymentStatus)){
            System.out.println("Pagamento aprovado");
        } else if ("recusado".equalsIgnoreCase(paymentStatus)){
            System.out.println("Pagamento recusado");
        } else {
            System.out.println("Pagamento em estado desconhecido");
        }
        return new ResponseEntity<>("Notificacao de pagamento recebida com sucesso", HttpStatus.OK);
    }
}
