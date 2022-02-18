package com.learnup.homework.operasales.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmailNotifier {

    @Value("${mail}")
    String mail;

    @Pointcut("@annotation(com.learnup.homework.operasales.annotations.EmailNotify)")
    public void emailNotify() {}

    @Around("emailNotify()")
    public void after(JoinPoint point) {
        String mailSubject;
        switch (point.getSignature().getName()) {
            case "addPremiere":
                mailSubject = "Анонс мероприятия";
                break;
            case "setPremiere":
                mailSubject = "Изменение мероприятия";
                break;
            case "buyTicket":
                mailSubject = "Покупка билета";
                break;
            default:
                mailSubject = "Событие";
                break;
        }
        sendMail(mailSubject);
    }

    public void sendMail(String text) {
        System.out.println("Отправка письма на почту " + mail + ": " + text);
    }
}
