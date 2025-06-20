package com.davidlj95.leetcode.structures.homemade;

import java.util.*;

public class MinHeap<T extends Comparable<T>> extends AbstractQueue<T> {
    private final List<T> heap;

    @SuppressWarnings("unused")
    public MinHeap() {
        heap = new ArrayList<>();
    }

    public MinHeap(Collection<T> heap) {
        this.heap = new ArrayList<>(heap);
    }

    @Override
    public Iterator<T> iterator() {
        return heap.iterator();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean offer(T t) {
        heap.add(t);
        var nodeRef = new HeapNodeRef(heap.size() - 1);
        var parentRef = nodeRef.getParent();
        if (parentRef == null) return true;
        while (t.compareTo(parentRef.getValue()) < 0) {
            nodeRef.swapWith(parentRef);
            parentRef = nodeRef.getParent();
            if (parentRef == null) break;
        }
        return true;
    }

    @Override
    public T poll() {
        var head = this.peek();
        if (head == null) return null;

        var rootNodeRef = new HeapNodeRef(0);
        var lastNodeRef = new HeapNodeRef(heap.size() - 1);
        rootNodeRef.setValue(lastNodeRef.getValue());
        lastNodeRef.remove();

        var nodeRef = rootNodeRef;
        while (nodeRef.getLeftChild() != null || nodeRef.getRightChild() != null) {
            var leftRef = nodeRef.getLeftChild();
            var rightRef = nodeRef.getRightChild();
            if (leftRef == null) {
                //noinspection DataFlowIssue
                nodeRef.swapWith(rightRef);
                continue;
            }
            if (rightRef == null) {
                nodeRef.swapWith(leftRef);
                continue;
            }
            var smallestChild = leftRef.getValue().compareTo(rightRef.getValue()) < 0 ? leftRef : rightRef;
            nodeRef.swapWith(smallestChild);
        }

        return head;
    }

    @Override
    public T peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    private class HeapNodeRef {
        private int index;

        private HeapNodeRef(int index) {
            this.index = index;
        }

        private T getValue() {
            return heap.get(index);
        }

        private T setValue(T value) {
            return heap.set(index, value);
        }

        private HeapNodeRef getParent() {
            var parentIndex = (index - 1) / 2;
            if (parentIndex < 0) return null;
            return new HeapNodeRef(parentIndex);
        }

        private HeapNodeRef getLeftChild() {
            var leftChildIndex = 2 * index + 1;
            if (leftChildIndex >= heap.size()) return null;
            return new HeapNodeRef(leftChildIndex);
        }

        private HeapNodeRef getRightChild() {
            var rightChildIndex = 2 * index + 2;
            if (rightChildIndex >= heap.size()) return null;
            return new HeapNodeRef(rightChildIndex);
        }

        private void remove() {
            heap.remove(index);
        }

        private void swapWith(HeapNodeRef otherRef) {
            var otherValue = otherRef.getValue();
            heap.set(otherRef.index, this.getValue());
            heap.set(index, otherValue);

            var otherIndex = otherRef.index;
            otherRef.index = index;
            this.index = otherIndex;
        }
    }
}
