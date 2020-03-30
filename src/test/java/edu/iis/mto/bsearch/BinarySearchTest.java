package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private int [] emptySeq = {};
    private int [] oneElementSeq = {72};
    private int [] negativeSeq = {-21, -9, -2};
    private int [] negativeToPositiveSeq = {-21, -9, 2, 7, 11};
    private int [] seq = {1, 3, 5, 6, 10, 27, 45};
    private BinarySearch binarySearch = BinarySearch.create();

    @Test
    void searchElementInOneElementSequenceWhenElementIsPresent() {
        int numberSought = 72, position = 0;
        SearchResult searchResult = binarySearch.search(numberSought, oneElementSeq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), equalTo(position));
        assertThat(oneElementSeq[searchResult.getPosition()], equalTo(numberSought));
    }

    @Test
    void searchElementInOneElementSequenceWhenElementIsNotPresent() {
        int numberSought = 27, position = -1;
        SearchResult searchResult = binarySearch.search(numberSought, oneElementSeq);

        assertThat(searchResult.isFound(), is(not(true)));
        assertThat(searchResult.getPosition(), equalTo(position));
    }

    @Test
    void searchElementInSequenceWhenElementIsPresentOnFirstPosition() {
        int numberSought = 1, position = 0;
        SearchResult searchResult = binarySearch.search(numberSought, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), equalTo(position));
        assertThat(seq[searchResult.getPosition()], equalTo(numberSought));
    }

    @Test
    void searchElementInSequenceWhenElementIsPresentOnLastPosition() {
        int numberSought = 45, position = seq.length - 1;
        SearchResult searchResult = binarySearch.search(numberSought, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), equalTo(position));
        assertThat(seq[searchResult.getPosition()], equalTo(numberSought));
    }

    @Test
    void searchElementInSequenceWhenElementIsPresentOnCenterPosition() {
        int numberSought = 6, position = (seq.length - 1) / 2;
        SearchResult searchResult = binarySearch.search(numberSought, seq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), equalTo(position));
        assertThat(seq[searchResult.getPosition()], equalTo(numberSought));
    }

    @Test
    void searchElementInSequenceWhenElementIsNotPresent() {
        int numberSought = 111, position = -1;
        SearchResult searchResult = binarySearch.search(numberSought, seq);

        assertThat(searchResult.isFound(), is(not(true)));
        assertThat(searchResult.getPosition(), equalTo(position));
    }

    @Test()
    void searchElementInEmptySequence() {
        int numberSought = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            binarySearch.search(numberSought, emptySeq);
        });
    }

    @Test()
    void searchElementInNullSequence() {
        int numberSought = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            binarySearch.search(numberSought, null);
        });
    }

    @Test
    void searchElementInNegativeSequence() {
        int numberSought = -9, position = 1;
        SearchResult searchResult = binarySearch.search(numberSought, negativeSeq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), equalTo(position));
        assertThat(negativeSeq[searchResult.getPosition()], equalTo(numberSought));
    }

    @Test
    void searchElementInNegativeToPositiveSequence() {
        int numberSought = 7, position = 3;
        SearchResult searchResult = binarySearch.search(numberSought, negativeToPositiveSeq);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), equalTo(position));
        assertThat(negativeToPositiveSeq[searchResult.getPosition()], equalTo(numberSought));
    }

}