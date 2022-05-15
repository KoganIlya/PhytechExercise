package phytechexerciseServer.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phytechexerciseServer.dao.ItemsRepository;
import phytechexerciseServer.dao.StockRepository;
import phytechexerciseServer.dto.ItemDto;
import phytechexerciseServer.model.Stock;

@Service
public class ServerServiceImpl implements ServerService {

	ItemsRepository itemsRepository;
	StockRepository stockRepository;
	ModelMapper modelMapper;

	@Autowired
	public ServerServiceImpl(ItemsRepository itemsRepository, StockRepository stockRepository,
			ModelMapper modelMapper) {
		this.itemsRepository = itemsRepository;
		this.stockRepository = stockRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ItemDto> getItemsList() {

		List<Stock> stocks = stockRepository.findAll();
		if (stocks.isEmpty()) {
			throw new NoSuchElementException("Stock empty");
		} else {
			List<ItemDto> items = stocks.stream().map(s -> modelMapper.map(s.getItem(), ItemDto.class))
					.collect(Collectors.toList());
			return items;
		}

	}

	@Override
	public int amountOfItem(long itemId) {
		Stock stock = stockRepository.findById(itemId).orElseThrow();
		return stock.getAmount();
	}

	@Override
	public ItemDto sellItem(long itemId) {
		Stock stock = stockRepository.findById(itemId).orElseThrow();
		if (stock.getAmount() > 0) {
			stock.setAmount(stock.getAmount() - 1);
			stockRepository.save(stock);
			return modelMapper.map(stock.getItem(), ItemDto.class);
		} else {
			throw new NoSuchElementException("No such item");
		}

	}

}
