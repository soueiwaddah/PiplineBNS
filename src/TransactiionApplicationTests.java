package bns.transactiion;

import bns.transactiion.DTO.ClientDto;
import bns.transactiion.Entities.Client;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import bns.transactiion.Repository.ClientRepository;
import bns.transactiion.Services.IClientService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class TransactiionApplicationTests {



/*	@MockBean
	ClientRepository clientrepo;
	@Autowired
	IClientService clientService;

	@Test
	void getClientByCINTest() {
		log.info("debut test affichage par cin");

		Client client = new Client();

		client.setCin(87562);
		client.setMatriculeFs("hfyt7854");
		client.setNom("firas");
		client.setPrenom("laroussi");
		client.setPasseport("785jgyf2");
		client.setRne("jhgyfr6987ju");
		Optional<Client> optionalEntityType = Optional.of(client);
		when(clientrepo.findByCin(87562)).thenReturn(optionalEntityType);
		clientService.getClientByCIN(client.getCin());

		log.info("fin test affichage client avec succées");


	} */

	@Autowired
	ClientRepository clientrepo;
	@Autowired
	IClientService clientService;

	@Test
	public void testAjouterClient() throws ParseException {

		ClientDto clientdto = new ClientDto();

		try {
			log.info("In AjouterClient() : ");
			log.debug("start ajoutClient");
			clientService.ajouterClient(clientdto);
			log.debug("end ajoutClient");
		}catch (Exception e) {
			log.error("Erreur dans AjouterClient() :" + e);
		}
	}



}
