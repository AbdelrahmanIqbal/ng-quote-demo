package com.example.class1spring;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class QuoteService {

	private final QuoteRepository quoteRepository;

	public QuoteService(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}

	Quote getQuote(int id) {
		QuoteEntity quoteEntity =  quoteRepository.findById(id).get();
		Quote quote =  new Quote();
		quote.setId(quoteEntity.getId());
		quote.setQuoteText(quoteEntity.getQuoteText());
		quote.setAuthor(quoteEntity.getAuthor());
		return quote;
	}

	List<QuoteEntity> getAllQuotes() {
		List<QuoteEntity> allQuotes = (List<QuoteEntity>) quoteRepository.findAll();
		return allQuotes;
	}

	String createQuote(Quote quote) {
		if (!quoteRepository.existsById(quote.getId())) {
			QuoteEntity quoteEntity = fillQuoteEntity(quote);
			try {
				quoteRepository.save(quoteEntity);
				return "Your quote number is #" + quoteEntity.getId();
			} catch(Exception e){
				return e.getMessage().toString();
			}
		} else{
			return "Quote already exists.";
		}
	}

	String updateQuote(Quote quote) {
		int id = quote.getId();
		if (quoteRepository.existsById(id)) {
			QuoteEntity quoteEntity = fillQuoteEntity(quote);
			try {
				quoteRepository.save(quoteEntity);
				return "Quote number #" + id + " has been updated.";
			} catch(Exception e){
				return e.getMessage().toString();
			}
		} else{
			return "Quote does not exist.";
		}
	}

	String deleteQuote(int id) {
		if (quoteRepository.existsById(id)) {
			QuoteEntity quoteEntity = fillQuoteEntity(getQuote(id));
			try {
				quoteRepository.delete(quoteEntity);
				return "Quote number #" + id + " has been deleted.";
			} catch(Exception e){
				return e.getMessage().toString();
			}
		} else{
			return "Quote does not exist.";
		}
	}

	private QuoteEntity fillQuoteEntity(Quote quote){
		QuoteEntity quoteEntity = new QuoteEntity();
		quoteEntity.setId(quote.getId());
		quoteEntity.setAuthor(quote.getAuthor());
		quoteEntity.setQuoteText(quote.getQuoteText());
		return quoteEntity;
	}

}
