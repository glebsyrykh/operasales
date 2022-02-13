package com.learnup.homework.operasales;

import com.learnup.homework.operasales.services.PremiereService;
import com.learnup.homework.operasales.services.TicketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OperasalesApplication {

	public static void main(String[] args) {

		final ConfigurableApplicationContext ctx = SpringApplication.run(OperasalesApplication.class, args);
		ctx.getBean(PremiereService.class).addPremiere("Тристан и Изольда", "Описание...", "18+", 300);
		ctx.getBean(PremiereService.class).getPremiere();
		System.out.println("-----------");
		ctx.getBean(PremiereService.class).setPremiere("Кармэн", "Описание2", "16+", 200);
		ctx.getBean(PremiereService.class).getPremiere();
		System.out.println("-----------");
		ctx.getBean(PremiereService.class).addPremiere("Новая опера", "Описание3", "6+", 100);
		ctx.getBean(PremiereService.class).getPremiereList();
		System.out.println("-----------");
		ctx.getBean(PremiereService.class).deletePremiere();
		ctx.getBean(PremiereService.class).getPremiereList();

		System.out.println("-----------||-----------");
		ctx.getBean(TicketService.class).buyTicket(Long.valueOf(23424), 5, 6);
		ctx.getBean(TicketService.class).refundTicket(Long.valueOf(23424));
	}

}
