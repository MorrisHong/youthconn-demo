package kr.gracelove.youthconndemo.controller;

import kr.gracelove.youthconndemo.entity.Todo;
import kr.gracelove.youthconndemo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/20
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/todos")
public class TodoController {

	private final TodoService todoService;

	@GetMapping("/{id}")
	public TodoDto.TodoResponse findTodo(@PathVariable Long id) {
		Todo todo = todoService.findTodo(id);
		return TodoDto.TodoResponse.of(todo);
	}

	@GetMapping
	public List<TodoDto.TodoResponse> findTodos(@RequestParam boolean done) {
		List<Todo> todos = todoService.findTodos(done);
		return todos.stream().map(TodoDto.TodoResponse::of).collect(Collectors.toList());
	}

	@PostMapping
	public TodoDto.TodoResponse save(@RequestBody TodoDto.TodoRequest todoRequest) {
		Todo savedTodo = todoService.save(todoRequest);
		return TodoDto.TodoResponse.of(savedTodo);
	}

	@PatchMapping("/{id}")
	public TodoDto.TodoResponse update(@PathVariable Long id, @RequestBody TodoDto.TodoRequest todoRequest) {
		Todo updatedTodo = todoService.update(id, todoRequest);
		return TodoDto.TodoResponse.of(updatedTodo);
	}

}
