package br.com.fiap.postech.soat.techchallenger1.adapters.controller;


import br.com.fiap.postech.soat.techchallenger1.adapters.dto.NotificacaoPagamentoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @PostMapping
    public ResponseEntity<String> handleMercadoPagoWebhook(@RequestBody String payload) {
        try {
            // Desserializa a carga útil JSON
            ObjectMapper objectMapper = new ObjectMapper();
            NotificacaoPagamentoDto notificacaoPagamentoDto = objectMapper.readValue(payload, NotificacaoPagamentoDto.class);

            System.out.println("Recebida notificação de pagamento: " + notificacaoPagamentoDto);
            
            // Responde ao serviço do mp
            return new ResponseEntity<>("Notification received", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Erro ao processar webhook: ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}