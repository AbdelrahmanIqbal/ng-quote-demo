package com.example.class1spring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

	private final QuoteService quoteService;

	public QuoteController(QuoteService quoteService) {
		this.quoteService = quoteService;
	}

	@GetMapping("/{id}")
	public Quote getQuoteById(@PathVariable int id) {
		return quoteService.getQuote(id);
	}

	@GetMapping
	public List<QuoteEntity> getAllQuote() {
		return quoteService.getAllQuotes();
	}

	@PostMapping(value="/create")
	public String createQuote(@RequestBody Quote quote){
		return quoteService.createQuote(quote);
	}

	@PutMapping(value="/update/{id}")
	public String updateQuote(@PathVariable int id, @RequestBody Quote quote){
		quote.setId(id);
		return quoteService.updateQuote(quote);
	}

	@DeleteMapping(value="/delete/{id}")
	public String deleteQuote(@PathVariable int id){
		return quoteService.deleteQuote(id);
	}
}
