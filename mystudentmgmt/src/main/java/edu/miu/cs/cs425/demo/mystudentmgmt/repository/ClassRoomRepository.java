package edu.miu.cs.cs425.demo.mystudentmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.demo.studentmgmt.model.ClassRoom;


@Repository
public interface ClassRoomRepository extends CrudRepository<ClassRoom, Long>{

}
