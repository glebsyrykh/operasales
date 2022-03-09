package com.learnup.homework.operasales;

import com.learnup.homework.operasales.entities.PremiereEntity;
import com.learnup.homework.operasales.services.PremiereService;
import com.learnup.homework.operasales.services.TicketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OperasalesApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ctx = SpringApplication.run(OperasalesApplication.class, args);

		final PremiereService premiereService = ctx.getBean(PremiereService.class);
		final TicketService ticketService = ctx.getBean(TicketService.class);
		premiereService.addPremiere("Тристан и Изольда", "Описание...", "18+", 300);

		premiereService.setPremiere(new PremiereEntity(3L, "Лоэнгрин", "Описание 2", "16+", 250, 1));

		premiereService.printPremiere(3L);

		premiereService.printAll();
		System.out.println("всего премьер:" + premiereService.getAll().size());

		Long ticketId = ticketService.buyTicket(3L, 5, 6);
		System.out.println("Билет " + ticketId.toString());
		ticketService.refundTicket(ticketId);
	}

}
