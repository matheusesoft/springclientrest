package com.uol.clientrest.listener;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import com.uol.clientrest.presistence.dao.TemperaturaDAO;
import com.uol.clientrest.persistence.model.Temperatura;
import com.uol.clientrest.webservice.ClimaService;;

@Service
public class ClimaListener implements MessageListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClimaListener.class);
	
	@Autowired
	private ClimaService climaService;

	@Override
	public void onMessage(Message message, byte[] pattern) {
		
		TemperaturaDAO temperaturaDAO = convertByteToTemperaturaDAO(message);
		LOGGER.info("Received <" + temperaturaDAO + ">");
		
		Temperatura temperatura = new Temperatura(temperaturaDAO);
		
		temperatura = climaService.salvar(temperatura);
		LOGGER.info("Saved <" + temperatura + ">");
	}

	private TemperaturaDAO convertByteToTemperaturaDAO(Message message) {
		ByteArrayInputStream in = new ByteArrayInputStream(message.getBody());
	    ObjectInputStream is;
	    TemperaturaDAO temperaturaDAO = null;
		try {
			is = new ObjectInputStream(in);
			temperaturaDAO = (TemperaturaDAO) is.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return temperaturaDAO;
	}
}
