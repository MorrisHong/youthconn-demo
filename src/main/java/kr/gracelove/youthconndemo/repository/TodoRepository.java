package kr.gracelove.youthconndemo.repository;

import kr.gracelove.youthconndemo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/20
 */

public interface TodoRepository extends JpaRepository<Todo, Long> {

	List<Todo> findAllByDone(boolean done);
}
