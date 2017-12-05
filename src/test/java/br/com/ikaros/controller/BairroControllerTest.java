package br.com.ikaros.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.ikaros.Application;
import br.com.ikaros.facade.FacadeFP;
import br.com.ikaros.model.Bairro;
import br.com.ikaros.model.Cidade;
import br.com.ikaros.model.Estado;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BairroControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	private String userId = "1";

	@SuppressWarnings("rawtypes")
	private HttpMessageConverter mappingJackson2HttpConverter;

	@SuppressWarnings("unused")
	private Estado estado;
	
	private Cidade cidade;
	
	private List<Bairro> bairroList = new ArrayList<>();
	
	@Autowired
	private FacadeFP facade;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		mappingJackson2HttpConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
				.findAny()
				.orElse(null);

		assertNotNull("the JSON message converter must not be null", mappingJackson2HttpConverter);
	}
	
	@Before
	public void setup() throws Exception {
		mockMvc = webAppContextSetup(webApplicationContext).build();
		estado = facade.findOneEstado(1);
		cidade = facade.findOneCidade(1);
		bairroList = (List<Bairro>) facade.findAllBairros();
	}
	
	@Test
	public void createBairro() throws Exception {
		String bairroJson = json(new Bairro(cidade, "Bairro Teste"));
		
		mockMvc.perform(post("/" + userId + "/bairros")
				.contentType(contentType)
				.content(bairroJson))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void readBairros() throws Exception {
		mockMvc.perform(get("/" + userId + "/bairros"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$", notNullValue()));
	}
	
	@Test
	public void readSingleBairro() throws Exception {
		mockMvc.perform(get("/" + userId + "/bairros/" + bairroList.get(0).getIdBairro()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(contentType))
		.andExpect(jsonPath("$.idBairro", is(bairroList.get(0).getIdBairro())))
		.andExpect(jsonPath("$.nomeBairro", is(bairroList.get(0).getNomeBairro())));
	}
	
	@Test
	public void updateBairro() throws Exception {
		Bairro uptBairro = bairroList.get(2);
		uptBairro.setNomeBairro(uptBairro.getNomeBairro() + " UPDATED");
		String bairroJson = json(uptBairro);
		
		mockMvc.perform(put("/" + userId + "/bairros")
				.contentType(contentType)
				.content(bairroJson))
				.andExpect(status().isOk());
	}
	
	@Test
	public void deleteBairro() throws Exception {
		int index = bairroList.size() - 1;
		Bairro delBairro = facade.findOneBairro(bairroList.get(index).getIdBairro());
		String bairroJson = json(delBairro);
		
		mockMvc.perform(delete("/" + userId + "/bairros")
				.contentType(contentType)
				.content(bairroJson))
				.andExpect(status().isNoContent());
	}
	
	@Test
	public void deleteBairroById() throws Exception {
		int index = bairroList.get(0).getIdBairro();
		
		mockMvc.perform(delete("/" + userId + "/bairros/" + index)
				.contentType(contentType))
				.andExpect(status().isNoContent());
	}
	
	@SuppressWarnings("unchecked")
	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}

}
