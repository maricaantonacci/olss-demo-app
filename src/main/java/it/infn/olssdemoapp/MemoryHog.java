package it.infn.olssdemoapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryHog {

  static class MemoryChunk {

    private final char[] chunk;

    public MemoryChunk(int size) {
      if (size <= 0) {
        throw new IllegalArgumentException("size must be a positive number");
      }

      chunk = new char[size];
      Arrays.fill(chunk, '0');
    }

    public int size() {
      return chunk.length;
    }
  }

  private final List<MemoryChunk> chunks = new ArrayList<>();


  public void addChunk(int size) {
    chunks.add(new MemoryChunk(size));
  }

  public void clearChunks() {
    chunks.clear();
    Runtime.getRuntime().gc();
  }

  public long size() {
    return chunks.stream().collect(Collectors.summingInt(MemoryChunk::size));
  }
}
