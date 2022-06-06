package ru.vcrop;

import java.util.Optional;

public interface Node {
    String getKey();

    Optional<String> getValue();

    Node next(String key);

    static Node EMPTY = new Node() {
        @Override
        public String getKey() {
            return null;
        }

        @Override
        public Optional<String> getValue() {
            return Optional.empty();
        }

        @Override
        public Node next(String key) {
            return EMPTY;
        }

    };

}
