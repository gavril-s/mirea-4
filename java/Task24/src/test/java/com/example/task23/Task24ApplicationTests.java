package com.example.Task19;

import com.example.Task19.service.MarketService;
import com.example.Task19.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Task18ApplicationTests {

	@Mock
	private MarketRepository marketRepository;

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private MarketService marketService;

	@InjectMocks
	private ProductService productService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateMarket() {
		Market market = new Market("Supermarket", "123 Main St");
		when(marketRepository.save(market)).thenReturn(market);

		Market createdMarket = marketService.createMarket(market);

		assertEquals(market.getName(), createdMarket.getName());
		assertEquals(market.getAddress(), createdMarket.getAddress());
		verify(marketRepository, times(1)).save(market);
	}

	@Test
	public void testGetAllMarkets() {
		Market market1 = new Market("Supermarket", "123 Main St");
		Market market2 = new Market("Grocery Store", "456 Elm St");
		List<Market> markets = Arrays.asList(market1, market2);
		when(marketRepository.findAll()).thenReturn(markets);

		List<Market> retrievedMarkets = marketService.getAllMarkets();

		assertEquals(markets.size(), retrievedMarkets.size());
		assertEquals(markets.get(0).getName(), retrievedMarkets.get(0).getName());
		assertEquals(markets.get(1).getAddress(), retrievedMarkets.get(1).getAddress());
		verify(marketRepository, times(1)).findAll();
	}

	@Test
	public void testAuthenticateUser() {
		String username = "exampleUser";
		String password = "examplePassword";

		when(userRepository.findByUsername(username)).thenReturn(new User(username, password));

		boolean isAuthenticated = authService.authenticateUser(username, password);

		assertEquals(true, isAuthenticated);
		verify(userRepository, times(1)).findByUsername(username);
	}

	@Test
	public void testSendEmail_Success() {
		String recipient = "recipient@example.com";
		String subject = "Test Subject";
		String message = "Test Message";

		doNothing().when(javaMailSender).send(any(SimpleMailMessage.class));

		emailService.sendEmail(recipient, subject, message);

		verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));
	}

	@Test
	public void testExportDataAndClearDirectory() {
		// Prepare data
		List<Market> markets = new ArrayList<>();
		markets.add(new Market("Market 1", "Address 1"));
		markets.add(new Market("Market 2", "Address 2"));

		List<Product> products = new ArrayList<>();
		products.add(new Product("Product 1", 10.0));
		products.add(new Product("Product 2", 20.0));

		// Configure mock repositories
		when(marketRepository.findAll()).thenReturn(markets);
		when(productRepository.findAll()).thenReturn(products);

		dataExportService.exportDataAndClearDirectory();

		verify(marketRepository, times(1)).findAll();
		verify(productRepository, times(1)).findAll();

		File marketsFile = new File(new ClassPathResource("data/markets.txt").getFile().getPath());
		File productsFile = new File(new ClassPathResource("data/products.txt").getFile().getPath());

	}


}
