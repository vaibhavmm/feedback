package com.vaibhav.feedback.repo;

import com.vaibhav.feedback.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
