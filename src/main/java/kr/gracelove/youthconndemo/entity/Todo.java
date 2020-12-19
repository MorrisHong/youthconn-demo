package kr.gracelove.youthconndemo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author : Eunmo Hong
 * @since : 2020/12/20
 */

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Todo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private boolean done;

	private LocalDateTime createdAt;

	@Builder
	public Todo(Long id, String title, boolean done, LocalDateTime createdAt) {
		this.id = id;
		this.title = title;
		this.done = done;
		this.createdAt = createdAt;
	}
}
