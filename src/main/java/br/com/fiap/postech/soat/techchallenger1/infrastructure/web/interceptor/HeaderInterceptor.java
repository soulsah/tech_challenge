package br.com.fiap.postech.soat.techchallenger1.infrastructure.web.interceptor;

import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.AutorizacaoDto;
import br.com.fiap.postech.soat.techchallenger1.infrastructure.web.dto.ReponseTokenDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;


public class HeaderInterceptor implements HandlerInterceptor {

    RestTemplate restTemplate = new RestTemplate();


    private String url = "https://5b2rp6zqeb.execute-api.sa-east-1.amazonaws.com/dev/";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorizationHeader = request.getHeader("Authorization");


        if (fazRequest(authorizationHeader)) {
            return true;
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

    public boolean fazRequest(String authorizationHeader) {

        var retorno = restTemplate.postForEntity(url, new AutorizacaoDto(authorizationHeader), ReponseTokenDto.class);
        var statusCode = retorno.getBody();

        if (statusCode.getStatusCode().equals("200")){
            return true;
        }

        return false;
    }

}
