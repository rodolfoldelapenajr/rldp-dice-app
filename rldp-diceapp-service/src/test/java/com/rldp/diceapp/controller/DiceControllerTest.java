package com.rldp.diceapp.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rldp.diceapp.service.DiceService;

public class DiceControllerTest {

    @Mock
    private DiceService service;
    
    @InjectMocks
    private DiceController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void onSetUp()
    {
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
	@Test
	public void shouldRollDice() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = get("/dice/roll")
				.param("pieces", "2")
				.param("sides", "4")
				.param("rolls", "2");
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(requestBuilder);
		verify(service, times(1)).rollDice(any());
	}
    
	@Test
	public void shouldThrowBadRequestException() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = get("/dice/roll")
				.param("pieces", "2")
				.param("sides", "2")
				.param("rolls", "2");
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();
		assertEquals(HttpStatus.BAD_REQUEST, HttpStatus.valueOf(response.getStatus()));
	}

}
