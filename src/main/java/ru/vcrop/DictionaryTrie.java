package ru.vcrop;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class DictionaryTrie {

    private static NodeImpl ROOT;

    public static Node root() {
        if (ROOT == null) {
            try (Stream<String> lines = Files.lines(Paths.get(Objects.requireNonNull(DictionaryTrie.class.getClassLoader().getResource("singular.txt")).toURI()))) {
                ROOT = new NodeImpl(null, null);

                lines.forEach(line -> {
                    NodeImpl current = ROOT;

                    for (String ch : line.split(""))
                        current = (NodeImpl) current.appendChild(ch);
                    current.setValue(line);
                });
            } catch (IOException | URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return ROOT;
    }

    private static class NodeImpl implements Node {

        String key;
        String value;
        Map<String, Node> child = new HashMap<>();

        NodeImpl(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public Optional<String> getValue() {
            return Optional.ofNullable(value);
        }

        @Override
        public Node next(String key) {
            return child.getOrDefault(key, Node.EMPTY);
        }

        Node appendChild(String key) {
            return child.computeIfAbsent(key, k -> new NodeImpl(key, null));
        }

        void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "NodeImpl{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

}
