package edu.neumont.pro150.pokemon.pokiguess.controllor;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Turns bad requests into a short, readable 400 answer for every controller:
 *   {"error":"text is required"}
 * Without this, Spring still answers 400, but without saying which rule failed.
 * (Module 4 covers exception handlers in more depth.)
 */
@RestControllerAdvice
public class ApiErrors {

    /** A @Valid rule failed, e.g. @NotBlank on text. */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> invalid(MethodArgumentNotValidException problem) {
        String messages = problem.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return ResponseEntity.badRequest().body(Map.of("error", messages));
    }

    /** The body wasn't valid JSON, or a field had the wrong type (e.g. "moodId":"two"). */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> unreadable(HttpMessageNotReadableException problem) {
        return ResponseEntity.badRequest().body(Map.of("error", "The request body isn't valid JSON for this endpoint"));
    }

    /**
     * The database refused the change: a duplicate UNIQUE value, or a row something else still
     * points at. A safety net for checks the controllers forgot. 409 instead of a 500.
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> conflict(DataIntegrityViolationException problem) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of(
                        "error", "That change breaks a rule in the database (a duplicate, or something still in use)"));
    }
}
