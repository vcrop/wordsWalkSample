package ru.vcrop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Finder {

    private final Node ROOT = DictionaryTrie.root();

    private void walk(String[][] matrix, int row, int col, Node dict, List<String> result, Set<Integer> visited) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length
                || visited.contains(row * matrix[row].length + col) || dict == Node.EMPTY)
            return;

        visited.add(row * matrix[row].length + col);

        dict = dict.next(matrix[row][col]);

        if (dict.getValue().isPresent())
            result.add(dict.getValue().get());

        walk(matrix, row - 1, col, dict, result, visited);
        walk(matrix, row + 1, col, dict, result, visited);
        walk(matrix, row, col - 1, dict, result, visited);
        walk(matrix, row, col + 1, dict, result, visited);

        visited.remove(row * matrix[row].length + col);

    }

    public List<String> find(String[][] matrix) {
        List<String> result = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++)
            for (int col = 0; col < matrix[row].length; col++)
                walk(matrix, row, col, ROOT, result, new HashSet<>());

        return result;
    }
}
