package kr.gracelove.youthconndemo.service;

import kr.gracelove.youthconndemo.controller.TodoDto;
import kr.gracelove.youthconndemo.entity.Todo;
import kr.gracelove.youthconndemo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/20
 */

@RequiredArgsConstructor
@Service
public class TodoService {

	private final TodoRepository todoRepository;
	private final ModelMapper modelMapper;

	@Transactional
	public Todo save(TodoDto.TodoRequest todoRequest) {
		Todo todo = Todo.builder()
				.title(todoRequest.getTitle())
				.createdAt(LocalDateTime.now())
				.build();

		todoRepository.save(todo);
		return todo;
	}

	@Transactional
	public Todo update(Long id, TodoDto.TodoRequest todoRequest) {
		Todo findTodo = todoRepository.findById(id)
				.orElseThrow(RuntimeException::new);

		modelMapper.map(todoRequest, findTodo);

		return findTodo;
	}

	@Transactional(readOnly = true)
	public Todo findTodo(Long id) {
		return todoRepository.findById(id)
				.orElseThrow(RuntimeException::new);
	}

	@Transactional(readOnly = true)
	public List<Todo> findTodos(boolean done) {
		return todoRepository.findAllByDone(done);
	}
}
