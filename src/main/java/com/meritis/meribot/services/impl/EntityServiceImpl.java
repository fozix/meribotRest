//package com.meritis.meribot.services.impl;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.meritis.meribot.models.Entity;
//import com.meritis.meribot.repositories.EntityRepository;
//import com.meritis.meribot.services.EntityService;
//
//@Service
//public class EntityServiceImpl implements EntityService{
//	
//	private EntityRepository entityRepository;
//	
//	@Autowired
//	public void setEntityRepository( EntityRepository repo) {
//		entityRepository = repo;
//	}
//
//	@Override
//	public Entity getEntityById(String id) {
//		Optional<Entity> entity = entityRepository.findById(id);
//		return entity.isPresent() ? entity.get() : null;
//	}
//
//	@Override
//	public Iterable listAllEntities() {
//		return entityRepository.findAll();
//	}
//
//	@Override
//	public void saveEntity(Entity storedEntity) {
//		entityRepository.save(storedEntity);
//	}
//
//	@Override
//	public void deleteEntity(String id) {
//		entityRepository.deleteById(id);
//	}
//
//}
