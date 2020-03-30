package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private int [] oneElementSeq = {72};
    private int [] seq = {1, 3, 5, 6, 10, 27, 45};
    private BinarySearch binarySearch = BinarySearch.create();

    @Test
    void searchElementInOneElementSequenceWhenElementIsPresent() {
        int numberSought = 72, position = 0;
        SearchResult searchResult = binarySearch.search(numberSought, oneElementSeq);

        assertTrue(searchResult.isFound());
        assertEquals(position, searchResult.getPosition());
        assertEquals(numberSought, oneElementSeq[searchResult.getPosition()]);
    }

}