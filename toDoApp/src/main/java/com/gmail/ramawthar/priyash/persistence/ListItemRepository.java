package com.gmail.ramawthar.priyash.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ListItemRepository extends CrudRepository<ListItem, Integer> {

	List<ListItem> findByItemNumber(String ItemNumber);
}
