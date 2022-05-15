package phytechexerciseServer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phytechexerciseServer.dao.ItemsRepository;
import phytechexerciseServer.dao.StockRepository;
import phytechexerciseServer.model.Item;
import phytechexerciseServer.model.Stock;
import phytechexerciseServer.model.dto.ItemDto;


@Service
public class ServirServiceImpl implements ServerService {
	
	ItemsRepository itemsRepository;
	StockRepository stockRepository;
	ModelMapper modelMapper;
	
	
    @Autowired
	public ServirServiceImpl(ItemsRepository itemsRepository, StockRepository stockRepository, ModelMapper modelMapper) {
		this.itemsRepository = itemsRepository;
		this.stockRepository = stockRepository;
		this.modelMapper=modelMapper;
	}

	@Override
	public List<ItemDto> getItemsList() {
		List<Stock> stocks = stockRepository.findAll();
		List<ItemDto> items = stocks.stream()
                              .map(s->s.getId())
				              .map(i->itemsRepository.findById(i).orElseThrow())
				              .map(it->modelMapper.map(it, ItemDto.class))
				              .collect(Collectors.toList());
		return items;

	}

	@Override
	public int amountOfItem(long id) {
		Stock stock = stockRepository.findById(id).orElseThrow();
		return stock.getAmount();
	}

	@Override
	public ItemDto sellItem(long id) {
		Stock stock = stockRepository.findById(id).orElseThrow();
	    Item item = itemsRepository.findById(id).orElseThrow();
		stock.setAmount(stock.getAmount()-1);
		stockRepository.save(stock);
		return modelMapper.map(item, ItemDto.class);
	}

}
