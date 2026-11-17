package com.nikhil.lc4jmultitoolconversationmemory.dto;

import jakarta.validation.constraints.NotBlank;

public record ChatRequest(@NotBlank String sessionId, @NotBlank String question) {
}
