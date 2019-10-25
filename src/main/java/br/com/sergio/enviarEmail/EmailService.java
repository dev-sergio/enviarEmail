package br.com.sergio.enviarEmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void enviar(String nome, String emailConvidado){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.gmail.com"); 
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("email", "senha"));
            email.setSSLOnConnect(true);

            email.setFrom("email");
            email.setSubject("Voce foi convidado pelo ListaVIP");
            email.setMsg("Ola, " + nome + ". Voce acaba de ser convidado pelo ListaVIP.");
            email.addTo(emailConvidado);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}