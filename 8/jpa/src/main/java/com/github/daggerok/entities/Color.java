package com.github.daggerok.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum Color {
  RED(255, 0, 0),
  BLACK(0, 0, 0),
  WHITE(255, 255, 255);

  private final int r, g, b;
}
