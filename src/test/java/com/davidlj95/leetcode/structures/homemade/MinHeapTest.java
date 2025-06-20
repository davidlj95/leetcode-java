package com.davidlj95.leetcode.structures.homemade;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinHeapTest {
    static final Collection<Integer> MIN_HEAP_CTCI_1 = List.of(4, 50, 7, 55, 90, 87);
    static final Collection<Integer> MIN_HEAP_CTCI_2 = List.of(12, 50, 23, 88, 90, 32, 74, 96);

    @SuppressWarnings("unused")
    static final OfferTestCase[] OFFER_TEST_CASES = {
            new OfferTestCase(List.of(), 1),
            new OfferTestCase(MIN_HEAP_CTCI_1, 2),
            new OfferTestCase(MIN_HEAP_CTCI_1, 34),
    };

    @SuppressWarnings("unused")
    static final Collection<Collection<Integer>> POLL_TEST_CASES = List.of(
            List.of(),
            List.of(1),
            MIN_HEAP_CTCI_2,
            MIN_HEAP_CTCI_1,
            Stream.concat(MIN_HEAP_CTCI_2.stream(), Stream.of(94, 93, 92, 37, 35, 78, 84)).collect(Collectors.toList())
    );

    @ParameterizedTest
    @FieldSource("OFFER_TEST_CASES")
    void offer(OfferTestCase testCase) {
        PriorityQueue<Integer> javaHeap = new PriorityQueue<>(testCase.input);
        MinHeap<Integer> sut = new MinHeap<>(testCase.input);

        javaHeap.offer(testCase.value);
        sut.offer(testCase.value);

        assertIteratorsEqual(javaHeap.iterator(), sut.iterator());
    }

    @ParameterizedTest
    @FieldSource("POLL_TEST_CASES")
    void poll(Collection<Integer> heap) {
        PriorityQueue<Integer> javaHeap = new PriorityQueue<>(heap);
        MinHeap<Integer> sut = new MinHeap<>(heap);

        var javaPolled = javaHeap.poll();
        var actualPolled = sut.poll();

        assertEquals(javaPolled, actualPolled);
        assertIteratorsEqual(javaHeap.iterator(), sut.iterator());
    }

    private <T> void assertIteratorsEqual(Iterator<T> expected, Iterator<T> actual) {
        var expectedList = new ArrayList<T>();
        expected.forEachRemaining(expectedList::add);

        var actualList = new ArrayList<T>();
        actual.forEachRemaining(actualList::add);

        assertEquals(expectedList, actualList);
    }

    record OfferTestCase(Collection<Integer> input, int value) {

    }
}

