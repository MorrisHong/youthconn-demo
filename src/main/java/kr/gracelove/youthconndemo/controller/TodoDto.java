package kr.gracelove.youthconndemo.controller;

import kr.gracelove.youthconndemo.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/20
 */


public class TodoDto {

	@Getter
	public static class TodoRequest {
		private String title;
	}

	@Getter
	static class TodoResponse {
		private Long id;

		private String title;

		private boolean done;

		private LocalDateTime createdAt;


		public static TodoResponse of(Todo todo) {
			TodoResponse todoResponse = new TodoResponse();
			todoResponse.id = todo.getId();
			todoResponse.title = todo.getTitle();
			todoResponse.done = todo.isDone();
			todoResponse.createdAt = todo.getCreatedAt();

			return todoResponse;
		}
	}


}
