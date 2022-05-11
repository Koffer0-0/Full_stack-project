package com.example.snickersdevops.service;

import com.example.snickersdevops.exceptions.ResourceUnavailableException;
import com.example.snickersdevops.exceptions.UnauthorizedActionException;
import com.example.snickersdevops.model.Quiz;
import com.example.snickersdevops.model.User;
import com.example.snickersdevops.model.support.Response;
import com.example.snickersdevops.model.support.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuizService {
	Quiz save(Quiz quiz, User user);

	Page<Quiz> findAll(Pageable pageable);

	Page<Quiz> findAllPublished(Pageable pageable);

	Page<Quiz> findQuizzesByUser(User user, Pageable pageable);

	Quiz find(Long id) throws ResourceUnavailableException;

	Quiz update(Quiz quiz) throws ResourceUnavailableException, UnauthorizedActionException;

	void delete(Quiz quiz) throws ResourceUnavailableException, UnauthorizedActionException;

	Page<Quiz> search(String query, Pageable pageable);

	Result checkAnswers(Quiz quiz, List<Response> answersBundle);

	void publishQuiz(Quiz quiz);
}
